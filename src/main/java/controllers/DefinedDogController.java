package controllers;

import SpeciesOfDogs.Dog;
import com.example.ClientDBUtils;
import com.example.DBUtils;
import com.example.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class DefinedDogController implements Initializable {

    // MENU
    @FXML
    private Button button_dog_selector;

    @FXML
    private Button button_messages;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_dog_hair_setter;
    //

    @FXML
    private Label label_defined_dog;

    @FXML
    private Button button_menu;

    @FXML
    private Label label_buy_dog;

    @FXML
    private Button button_yes;

    @FXML
    private Button button_no;

    @FXML
    private ImageView iv_dog_image;

    @FXML
    private Button button_show_dog;

    private User user;

    private Dog dog;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_dog_selector.setDisable(true);
        button_messages.setDisable(true);
        button_dog_hair_setter.setDisable(true);

        button_menu.setOnAction(e -> {
            DBUtils.changeScene(e, "example-user-menu.fxml", "Menu", user, null);
        });
        label_buy_dog.setVisible(false);
        button_yes.setVisible(false);
        button_no.setVisible(false);

        button_show_dog.setOnAction(e -> {
            String dogBreed = dog.getDogSpeecy().replace(' ', '_');

            System.out.println(dogBreed);

            Image image = new Image(Main.class.getResource("pictures/dogs/" + dogBreed + ".png").toExternalForm());

            iv_dog_image.setImage(image);

            label_defined_dog.setText(dog.displayMessage());

            label_buy_dog.setVisible(true);
            button_show_dog.setVisible(false);
            button_yes.setVisible(true);
            button_no.setVisible(true);
        });

        button_yes.setOnAction(e -> {
            String full_name = user.getFirstname() + " " + user.getLastname();
            if (!ClientDBUtils.hasThatDog(full_name, dog.getDogSpeecy(), user.getLogin())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("You already have that dog");
                alert.show();
            } else {
                DBUtils.changeScene(e, "example-services.fxml", "Services", user, dog);
            }
        });

        button_no.setOnAction(e -> {
            DBUtils.changeScene(e, "example-user-menu.fxml", "Menu", user, null);
        });

        button_logout.setOnAction(e -> {
            DBUtils.changeScene(e, "example-sign-in.fxml", "Log In", null, null);
        });
    }

    public void setUserInfo(User user, Dog dog) {
        this.user = user;
        this.dog = dog;
    }
}
