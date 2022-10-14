package controllers;

import Behaviors_and_Realizations.IntellectBehavior;
import Behaviors_and_Realizations.MoodBehavior;
import SpeciesOfDogs.Dog;
import com.example.ClientDBUtils;
import com.example.DBUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class DogSelectorController implements Initializable {

    @FXML
    private Button button_menu;

    @FXML
    private RadioButton rb_active;
    @FXML
    private RadioButton rb_aggressive;
    @FXML
    private RadioButton rb_calm;

    @FXML
    private RadioButton rb_big;
    @FXML
    private RadioButton rb_medium;
    @FXML
    private RadioButton rb_small;

    @FXML
    private RadioButton rb_domestic;
    @FXML
    private RadioButton rb_street;

    @FXML
    private RadioButton rb_trained;
    @FXML
    private RadioButton rb_no_trained;

    @FXML
    private Button button_submit;

    private User user;

    private Dog dog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rb_active.setSelected(true);
        ToggleGroup moodToggleGroup = new ToggleGroup();
        rb_active.setToggleGroup(moodToggleGroup);
        rb_aggressive.setToggleGroup(moodToggleGroup);
        rb_calm.setToggleGroup(moodToggleGroup);

        rb_big.setSelected(true);
        ToggleGroup sizeToggleGroup = new ToggleGroup();
        rb_big.setToggleGroup(sizeToggleGroup);
        rb_medium.setToggleGroup(sizeToggleGroup);
        rb_small.setToggleGroup(sizeToggleGroup);

        rb_domestic.setSelected(true);
        ToggleGroup lifestyleToggleGroup = new ToggleGroup();
        rb_domestic.setToggleGroup(lifestyleToggleGroup);
        rb_street.setToggleGroup(lifestyleToggleGroup);

        rb_trained.setSelected(true);
        ToggleGroup intellectToggleGroup = new ToggleGroup();
        rb_trained.setToggleGroup(intellectToggleGroup);
        rb_no_trained.setToggleGroup(intellectToggleGroup);

        button_submit.setOnAction(e -> {
            String mood = ((RadioButton) moodToggleGroup.getSelectedToggle()).getText();
            String size = ((RadioButton) sizeToggleGroup.getSelectedToggle()).getText();
            String lifestyle = ((RadioButton) lifestyleToggleGroup.getSelectedToggle()).getText();
            String intellect = ((RadioButton) intellectToggleGroup.getSelectedToggle()).getText();


            Dog definedDog = new Dog() {
                @Override
                public String displayMessage() {
                    return null;
                }

                @Override
                public String getDogSpeecy() {
                    return null;
                }
            };

            dog = definedDog.defineTypeOfDog(mood, size, lifestyle, intellect);

            if (dog != null)
                DBUtils.changeScene(e, "defined-dog.fxml", "Your selected dog", user, dog);

        });

        button_menu.setOnAction(e -> {
            DBUtils.changeScene(e, "user-menu.fxml", "Menu", user, null);
        });

    }

    public void setUserInfo(User user) {
        this.user = user;
    }
}
