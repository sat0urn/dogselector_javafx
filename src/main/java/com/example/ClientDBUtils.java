package com.example;

import javafx.scene.control.Alert;
import models.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ObserverPattern.*;

public class ClientDBUtils {

    public static List<Observer> getAllClients() {
        List<Observer> observers = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             PreparedStatement st = con.prepareStatement("SELECT * FROM clients")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Client client = new Client(
                        rs.getString("dog_buyer"),
                        rs.getString("login"),
                        rs.getString("dog_speecy"),
                        rs.getString("date")
                );
                observers.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return observers;
    }

    public static void addNewClient(Observer o) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            Client client = (Client) o;
            String query = "INSERT INTO clients VALUES(\'" +
                    client.getName() + "\', \'" +
                    client.getDogBreed() + "\', \'" +
                    client.getLogin() + "\', \'" +
                    client.getDate() + "\')";
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeClient(Observer o) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            Client client = (Client) o;
            ResultSet rs = st.executeQuery("SELECT * FROM clients");
            while (rs.next()) {
                if (rs.getString("dog_buyer").equals(client.getName()) &&
                        rs.getString("dog_speecy").equals(client.getDogBreed()) &&
                        rs.getString("date").equals(client.getDate())) {
                    String query = "DELETE FROM clients WHERE dog_buyer = \'" +
                            rs.getString("dog_buyer") + "\'";
                    st.executeUpdate(query);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setServicesAndItsCost(Client client, String description, double cost) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM clients");
            while (rs.next()) {
                if (rs.getString("dog_buyer").equals(client.getName()) &&
                    rs.getString("dog_speecy").equals(client.getDogBreed()) &&
                    rs.getString("login").equals(client.getLogin())) {
                    String updateDescription = "UPDATE clients SET description = \'" + description + "\' WHERE " +
                            "dog_buyer = \'" + client.getName() + "\' AND " +
                            "dog_speecy = \'" + client.getDogBreed() + "\' AND " +
                            "login = \'" + client.getLogin() + "\'";
                    String updateCost = "UPDATE clients SET cost = \'" + cost + "\' WHERE " +
                            "dog_buyer = \'" + client.getName() + "\' AND " +
                            "dog_speecy = \'" + client.getDogBreed() + "\' AND " +
                            "login = \'" + client.getLogin() + "\'";
                    st.executeUpdate(updateDescription);
                    st.executeUpdate(updateCost);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean hasThatDog(String dogBuyer, String dogSpeecy, String login) {
        boolean gate = true;
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             PreparedStatement psCheck = con.prepareStatement
                     (
                     "SELECT * FROM clients WHERE dog_buyer = \'" + dogBuyer + "\' AND " +
                             " dog_speecy = \'" + dogSpeecy + "\' AND login = \'" + login + "\'"
                     )
        ) {
            ResultSet rs = psCheck.executeQuery();
            if (rs.isBeforeFirst()) {
                return !gate;
            } else {
                while (rs.next()) {
                    if (rs.getString("dog_buyer").equals(dogBuyer) &&
                        rs.getString("dog_speecy").equals(dogSpeecy) &&
                        rs.getString("login").equals(login)) {
                        return gate;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gate;
    }


    public static String getDogName(String sizeBehavior, String moodBehavior, String lifestyleBehavior, String intellectBehavior) {
        String dog_name = null;
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM dog_breeds");
            while (rs.next()) {
                if (rs.getString("dog_size").equals(sizeBehavior) &&
                        rs.getString("dog_mood").equals(moodBehavior) &&
                        rs.getString("dog_lifestyle").equals(lifestyleBehavior) &&
                        rs.getString("dog_intellect").equals(intellectBehavior)) {
                    dog_name = rs.getString("dog_name");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dog_name;
    }

    public static String[] getAllDogBreeds() {
        String[] allDogBreeds = new String[36];
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery("SELECT * FROM dog_breeds");
            int i = 0;

            while (rs.next()) {
                allDogBreeds[i] = rs.getString("dog_name");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDogBreeds;
    }

    public static String getMostPopularDog() {
        String mostPopularDog = null;
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             PreparedStatement st = con.prepareStatement(
                     "SELECT dog_speecy, COUNT(dog_speecy) AS dog_count FROM clients " +
                             "GROUP BY dog_speecy ORDER BY dog_count DESC LIMIT 1"
             )) {
            ResultSet rs = st.executeQuery();
            while (rs.next())
                mostPopularDog = "Most popular dog by choice - " + rs.getString("dog_speecy");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mostPopularDog;
    }
}
