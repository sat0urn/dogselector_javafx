package com.example;

import SpeciesOfDogs.Dog;
import controllers.*;
import models.Client;
import models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class DBUtils {

    public static String[] getAdminMessages() {
        String[] messages = null;
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery("SELECT messages FROM users WHERE role = 'ADMIN'");
            while (rs.next()) {
                Array array = rs.getArray("messages");
                messages = (String[]) array.getArray();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    public static User findUserByLogin(String login) {
        User user = null;
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                if (rs.getString("login").equals(login)) {
                    user = new User(
                            rs.getString("user_firstname"),
                            rs.getString("user_lastname"),
                            rs.getString("login"),
                            rs.getString("password")
                    );
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void changeScene(ActionEvent event, String fxmlFile, String title, User user, Dog dog) {
        Parent root = null;
        if (user != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                if (loader.getController().getClass().equals(UserMenuController.class)) {
                    UserMenuController userMenuController = loader.getController();
                    userMenuController.setUserInfo(user);
                }
                if (loader.getController().getClass().equals(DogSelectorController.class)) {
                    DogSelectorController dogSelectorController = loader.getController();
                    dogSelectorController.setUserInfo(user);
                }
                if (loader.getController().getClass().equals(DefinedDogController.class)) {
                    DefinedDogController definedDogController = loader.getController();
                    definedDogController.setUserInfo(user, dog);
                }
                if (loader.getController().getClass().equals(AdminMenuController.class)) {
                    AdminMenuController adminMenuController = loader.getController();
                    adminMenuController.setUserInfo(user);
                }
                if (loader.getController().getClass().equals(ServicesController.class)) {
                    ServicesController servicesController = loader.getController();
                    servicesController.setUserInfo(user, dog);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public static void signUpUser(ActionEvent event, String firstname, String lastname, String login, String password) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             PreparedStatement psInsert = con.prepareStatement("INSERT INTO users (user_firstname, user_lastname, login, password, messages, role) " +
                     "VALUES (?, ?, ?, ?, null, 'USER')");
             PreparedStatement psCheckUserExists = con.prepareStatement("SELECT * FROM users WHERE login = ?")) {

            psCheckUserExists.setString(1, login);

            ResultSet rs = psCheckUserExists.executeQuery();

            if (rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot user this login!");
                alert.show();
            } else {
                psInsert.setString(1, firstname);
                psInsert.setString(2, lastname);
                psInsert.setString(3, login);
                psInsert.setString(4, password);
                psInsert.executeUpdate();

                User user = findUserByLogin(login);

                changeScene(event, "example-user-menu.fxml", "Menu", user, null);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void logInUser(ActionEvent event, String login, String password) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE login = ?")) {

            ps.setString(1, login);

            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect!");
                alert.show();
            } else {
                while (rs.next()) {
                    if (rs.getString("login").equals(login)) {
                        if (rs.getString("password").equals(password)) {
                            if (rs.getString("role").equals("ADMIN")) {
                                User user = findUserByLogin(login);
                                changeScene(event, "example-admin-menu.fxml", "Admin Menu", user, null);
                            } else {
                                User user = findUserByLogin(login);
                                changeScene(event, "example-user-menu.fxml", "WELCOME!", user, null);
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("Password did not match!");
                            alert.show();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("This login is not registered!");
                        alert.show();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageToAdmin(Client client, String dogBreed, String description, double cost) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            String message =
                    client.getName() + "/" +
                            client.getLogin() + "/" +
                            dogBreed + "/" +
                            description + "/" +
                            cost;
            String query = "UPDATE users SET messages = array_append(messages, \'" + message.toString() + "\')" +
                    " WHERE role = 'ADMIN'";
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
