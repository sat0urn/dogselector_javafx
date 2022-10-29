package controllers;

import DecoratorPattern.DepRecFunc;
import DecoratorPattern.Grafted;
import DecoratorPattern.SelectedDog;
import DecoratorPattern.SelectodDogs.*;
import SpeciesOfDogs.Dog;
import StatePattern.AcquisitionSettingTime;
import StatePattern.SettedState;
import com.example.DBUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import models.Client;
import models.User;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ServicesController implements Initializable {

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
    private RadioButton rb_yes_1;
    @FXML
    private RadioButton rb_no_1;

    @FXML
    private RadioButton rb_yes_2;
    @FXML
    private RadioButton rb_no_2;

    @FXML
    private Button button_submit;

    @FXML
    private Line line_between_1;

    @FXML
    private Line line_between_2;

    @FXML
    private Label label_services;

    @FXML
    private Button button_menu;

    @FXML
    private Label label_dog_cost;

    private User user;

    private Dog dog;

    private SelectedDog currentSelectedDog = null;

    private List<SelectedDog> selectedDogList = Arrays.asList(
            new Akita_Inu(), new Basset_Hound(), new Beagle(), new Boston_Terrier(),
            new Boxer(), new Bulldog(), new Bullmastiff(), new Caucasion_Shephard(),
            new Chiwawa(), new Chow_Chow(), new Corgi(), new Dalmatian(),
            new Doberman(), new German_Shephard(), new German_Shorthaired_Pointer(),
            new Ghanaian(), new Golden_Retriever(), new Great_Dane(), new Husky(),
            new Irish_Water_Spaniel(), new Labrador(), new Mixed_Breed_1(), new Mixed_Breed_2(),
            new Neapolitan_Mastiff(), new Norwegian_Elkhound(), new Norwegian_Lundehund(), new Pomeranian(),
            new Pooch(), new Puddle(), new Pug(), new Samoyed(), new Spaniel(), new Tax(), new Tibet_Mastiff(),
            new Tosa_Inu(), new Yorkshire_Terrier());


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_dog_selector.setDisable(true);
        button_messages.setDisable(true);
        button_dog_hair_setter.setDisable(true);

        line_between_1.setVisible(false);
        line_between_2.setVisible(false);
        label_services.setVisible(false);
        button_menu.setVisible(false);

        rb_yes_1.setSelected(true);
        rb_yes_2.setSelected(true);

        ToggleGroup toggleGroup_1 = new ToggleGroup();
        rb_yes_1.setToggleGroup(toggleGroup_1);
        rb_no_1.setToggleGroup(toggleGroup_1);

        ToggleGroup toggleGroup_2 = new ToggleGroup();
        rb_yes_2.setToggleGroup(toggleGroup_2);
        rb_no_2.setToggleGroup(toggleGroup_2);

        button_submit.setOnAction(e -> {
            for (SelectedDog selectedDog : selectedDogList) {
                if (selectedDog.description.equals(dog.getDogSpeecy())) {
                    currentSelectedDog = selectedDog;
                }
            }
            if (rb_yes_1.isSelected())
                currentSelectedDog = new DepRecFunc(currentSelectedDog);

            if (rb_yes_2.isSelected())
                currentSelectedDog = new Grafted(currentSelectedDog);

            System.out.println(currentSelectedDog.getDescription());

            if (rb_yes_2.isSelected() || rb_yes_1.isSelected()) {
                label_services.setText("Your services: " + currentSelectedDog.getDescription() + "\n\n" +
                        "Cost: " + currentSelectedDog.cost() + "$");
            }

            if (rb_no_2.isSelected() && rb_no_1.isSelected()) {
                label_services.setText("You didn't choose any of services that we provided\n\n" +
                        "Your dog: " + currentSelectedDog.getDescription() + "\n\n" +
                        "Cost: " + currentSelectedDog.cost() + "$");
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("We will send you a message with dog acquisition time!\n" +
                    "(Check your messages)");
            alert.show();

            Client client = new Client(
                    user.getFirstname() + " " + user.getLastname(),
                    user.getLogin(),
                    dog.getDogSpeecy(),
                    currentSelectedDog.getDescription(),
                    currentSelectedDog.cost()
                    );

            AcquisitionSettingTime acquisitionSettingTime = new AcquisitionSettingTime(client);
            acquisitionSettingTime.setDateToClient();

            button_menu.setVisible(true);
            line_between_1.setVisible(true);
            line_between_2.setVisible(true);
            label_services.setVisible(true);

            button_submit.setDisable(true);
        });

        button_menu.setOnAction(e -> {
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
