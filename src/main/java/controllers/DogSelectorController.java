package controllers;

import SpeciesOfDogs.Dog;
import com.example.DBUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class DogSelectorController implements Initializable {

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
    private Button button_menu;

    @FXML
    private ToggleButton tb_active;
    @FXML
    private ToggleButton tb_aggressive;
    @FXML
    private ToggleButton tb_calm;

    @FXML
    private ToggleButton tb_big;
    @FXML
    private ToggleButton tb_medium;
    @FXML
    private ToggleButton tb_small;

    @FXML
    private ToggleButton tb_domestic;
    @FXML
    private ToggleButton tb_street;

    @FXML
    private ToggleButton tb_trained;
    @FXML
    private ToggleButton tb_no_trained;

    @FXML
    private Button button_submit;

    private User user;

    private Dog dog = new Dog() {
        @Override
        public String displayMessage() {
            return null;
        }

        @Override
        public String getDogSpeecy() {
            return null;
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_dog_selector.setDisable(true);
        button_messages.setDisable(true);
        button_dog_hair_setter.setDisable(true);

        tb_active.setSelected(true);
        ToggleGroup moodToggleGroup = new ToggleGroup();
        tb_active.setToggleGroup(moodToggleGroup);
        tb_aggressive.setToggleGroup(moodToggleGroup);
        tb_calm.setToggleGroup(moodToggleGroup);

        tb_big.setSelected(true);
        ToggleGroup sizeToggleGroup = new ToggleGroup();
        tb_big.setToggleGroup(sizeToggleGroup);
        tb_medium.setToggleGroup(sizeToggleGroup);
        tb_small.setToggleGroup(sizeToggleGroup);

        tb_domestic.setSelected(true);
        ToggleGroup lifestyleToggleGroup = new ToggleGroup();
        tb_domestic.setToggleGroup(lifestyleToggleGroup);
        tb_street.setToggleGroup(lifestyleToggleGroup);

        tb_trained.setSelected(true);
        ToggleGroup intellectToggleGroup = new ToggleGroup();
        tb_trained.setToggleGroup(intellectToggleGroup);
        tb_no_trained.setToggleGroup(intellectToggleGroup);

        button_submit.setOnAction(e -> {
            String mood, size, lifestyle, intellect;
            try {
                mood = ((ToggleButton) moodToggleGroup.getSelectedToggle()).getText();
                size = ((ToggleButton) sizeToggleGroup.getSelectedToggle()).getText();
                lifestyle = ((ToggleButton) lifestyleToggleGroup.getSelectedToggle()).getText();
                intellect = ((ToggleButton) intellectToggleGroup.getSelectedToggle()).getText();

                dog = dog.defineTypeOfDog(mood, size, lifestyle, intellect);

                if (dog != null)
                    DBUtils.changeScene(e, "example-defined-dog.fxml", "Your selected dog", user, dog);
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Select all of behaviors type!");
                alert.show();
            }
        });

        button_menu.setOnAction(e -> {
            DBUtils.changeScene(e, "example-user-menu.fxml", "Menu", user, null);
        });

        button_logout.setOnAction(e -> {
            DBUtils.changeScene(e, "example-sign-in.fxml", "Log In", null, null);
        });
    }

    public void setUserInfo(User user) {
        this.user = user;
    }
}
