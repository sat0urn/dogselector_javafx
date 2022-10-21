package controllers;

import SpeciesOfDogs.Dog;
import com.example.ClientDBUtils;
import com.example.DBUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class DefinedDogController implements Initializable {

    @FXML
    private Label label_defined_dog;

    @FXML
    private Button button_show_dog;

    @FXML
    private Button button_menu;

    @FXML
    private Label label_buy_dog;

    @FXML
    private Button button_yes;

    @FXML
    private Button button_no;

    private User user;

    private Dog dog;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_menu.setOnAction(e -> {
            DBUtils.changeScene(e, "user-menu.fxml", "Menu", user, null);
        });

        label_buy_dog.setVisible(false);
        button_yes.setVisible(false);
        button_no.setVisible(false);

        button_show_dog.setOnAction(e -> {
            button_show_dog.setVisible(false);
            label_buy_dog.setVisible(true);
            button_yes.setVisible(true);
            button_no.setVisible(true);

            label_defined_dog.setText(dog.displayMessage());
        });

        button_yes.setOnAction(e -> {
            String full_name = user.getFirstname() + " " + user.getLastname();
            if (!ClientDBUtils.hasThatDog(full_name, dog.getDogSpeecy(), user.getLogin())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("You already have that dog");
                alert.show();
            } else {
                DBUtils.changeScene(e, "services.fxml", "Services", user, dog);
            }
        });

        button_no.setOnAction(e -> {
            DBUtils.changeScene(e, "user-menu.fxml", "Menu", user, null);
        });
    }

    public void setUserInfo(User user, Dog dog) {
        this.user = user;
        this.dog = dog;
    }
}
