package controllers;

import FactoryPattern.*;
import ObserverPattern.DogAcquisition;
import com.example.ClientDBUtils;
import com.example.DBUtils;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {

    // MENU
    @FXML
    private Label label_welcome;

    @FXML
    private Button button_dog_selector;

    @FXML
    private Button button_messages;

    @FXML
    private Button button_logout;

    // MESSAGES
    @FXML
    private ListView<String> lv_messages;

    // DOG HAIR SETTER
    @FXML
    private Button button_dog_hair_setter;

    @FXML
    private AnchorPane ap_dog_hair;

    @FXML
    private ChoiceBox<String> cb_dogs;

    @FXML
    private ChoiceBox<String> cb_hair_types;

    @FXML
    private Line line_between_1;

    @FXML
    private Line line_between_2;

    @FXML
    private Label label_dog_hair_type;

    @FXML
    private Button button_submit;

    private User user;

    private String dogBreed = null;
    private String hairType = null;

    private String[] allDogBreeds = ClientDBUtils.getAllDogBreeds();
    private String[] allHairTypes = {
            new Longhair().getHairType(),
            new Shorthair().getHairType(),
            new Regularhair().getHairType()
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cb_dogs.getItems().addAll(allDogBreeds);
        cb_hair_types.getItems().addAll(allHairTypes);

        cb_dogs.setValue(allDogBreeds[0]);
        cb_hair_types.setValue(allHairTypes[0]);

        lv_messages.setVisible(false);
        ap_dog_hair.setVisible(false);

        button_dog_selector.setOnAction(e -> {
           DBUtils.changeScene(e, "dog-selector.fxml", "Dog Selector", user, null);
        });

        button_messages.setOnAction(e -> {
            String full_name = user.getFirstname() + " " + user.getLastname();

            DogAcquisition dogAcquisition = new DogAcquisition();
            String[] allNotifies = dogAcquisition.notifyObserver(full_name);

            String[] copyAllNotifies = new String[allNotifies.length];
            int c = 1, i = 0;

            for (String notify : allNotifies) {
                copyAllNotifies[i] = (c + ". " + notify);
                c++; i++;
            }

            lv_messages.getItems().addAll(copyAllNotifies);

            lv_messages.setVisible(true);
            button_messages.setDisable(true);
            button_dog_hair_setter.setDisable(false);
            ap_dog_hair.setVisible(false);
        });

        button_dog_hair_setter.setOnAction(e -> {
            ap_dog_hair.setVisible(true);
            button_messages.setDisable(false);
            button_dog_hair_setter.setDisable(true);
            lv_messages.setVisible(false);
        });

        button_submit.setOnAction(e -> {
            dogBreed = cb_dogs.getValue();
            hairType = cb_hair_types.getValue();

            Hairtype dogHairType = HairTypeFactory.getHairType(dogBreed, hairType);

            label_dog_hair_type.setText(dogHairType.getDogAndHairType());
        });

        button_logout.setOnAction(e -> {
            DBUtils.changeScene(e, "main.fxml", "Log In", null, null);
        });
    }

    public void setUserInfo(User user) {
        this.user = user;
        label_welcome.setText("Welcome " + user.getFirstname() + " " + user.getLastname() + "!");
    }
}
