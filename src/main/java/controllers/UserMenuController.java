package controllers;

import FactoryPattern.*;
import ObserverPattern.DogAcquisition;
import SingletonPattern.MostPopularDog;
import com.example.ClientDBUtils;
import com.example.DBUtils;
import com.example.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {

    // MENU
    @FXML
    private Button button_dog_selector;

    @FXML
    private Button button_messages;

    @FXML
    private Button button_logout;
    //

    @FXML
    private Button button_dog_hair_setter;

    // MESSAGES
    @FXML
    private ListView<String> lv_messages;

    @FXML
    private AnchorPane ap_welcome_labels;

    @FXML
    private AnchorPane ap_messages_hair_setter;

    // DOG HAIR SETTER

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

    @FXML
    private TextField tf_most_popular_dog;

    private User user;

    private String dogBreed = null;
    private String hairType = null;

    private String[] allDogBreeds = null;
    private String[] allHairTypes = {
            new Longhair().getHairType(),
            new Shorthair().getHairType(),
            new Regularhair().getHairType()
    };

    private boolean wasClicked = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MostPopularDog mostPopularDog = MostPopularDog.getInstance(ClientDBUtils.getMostPopularDog());

        tf_most_popular_dog.setText(mostPopularDog.getPopularDog());

        ap_messages_hair_setter.setVisible(false);

        button_dog_selector.setOnAction(e -> {
            DBUtils.changeScene(e, "example-dog-selector.fxml", "Dog Selector", user, null);
        });

        button_messages.setOnAction(e -> {
            if (!wasClicked) {
                DogAcquisition dogAcquisition = new DogAcquisition();
                String full_name = user.getFirstname() + " " + user.getLastname();
                String[] allNotifies = dogAcquisition.notifyObserver(full_name);

                String[] copyAllNotifies = new String[allNotifies.length];
                int c = 1, i = 0;

                for (String notify : allNotifies) {
                    copyAllNotifies[i] = (c + ". " + notify);
                    c++;
                    i++;
                }
                lv_messages.getItems().addAll(copyAllNotifies);
            }

            ap_welcome_labels.setVisible(false);

            ap_messages_hair_setter.setVisible(true);
            lv_messages.setVisible(true);
            button_messages.setDisable(true);
            button_dog_hair_setter.setDisable(false);
            ap_dog_hair.setVisible(false);

            wasClicked = true;
        });


        button_dog_hair_setter.setOnAction(e -> {
            allDogBreeds = ClientDBUtils.getAllDogBreeds(user);

            if (allDogBreeds.length == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("You don't have any dogs!");
                alert.show();
            } else {
                cb_dogs.setValue(allDogBreeds[0]);
                cb_hair_types.setValue(allHairTypes[0]);

                cb_dogs.getItems().addAll(allDogBreeds);
                cb_hair_types.getItems().addAll(allHairTypes);

                ap_welcome_labels.setVisible(false);

                ap_dog_hair.setVisible(true);
                button_messages.setDisable(false);
                button_dog_hair_setter.setDisable(true);
                lv_messages.setVisible(false);
            }
        });

        button_submit.setOnAction(e -> {
            dogBreed = cb_dogs.getValue();
            hairType = cb_hair_types.getValue();

            Hairtype dogHairType = HairTypeFactory.getHairType(dogBreed, hairType);

            boolean alreadyHasDogHairType = ClientDBUtils.setDogHairType(user.getLogin(), dogBreed, hairType);

            if (alreadyHasDogHairType)
                label_dog_hair_type.setText(dogHairType.getDogAndHairType());
            else
                label_dog_hair_type.setText("You have some issues, try again!");
        });

        button_logout.setOnAction(e -> {
            DBUtils.changeScene(e, "example-sign-in.fxml", "Log In", null, null);
        });
    }

    public void setUserInfo(User user) {
        this.user = user;
    }
}
