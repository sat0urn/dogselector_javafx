package controllers;

import com.example.ClientDBUtils;
import com.example.DBUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import models.Client;
import models.User;
import ObserverPattern.DogAcquisition;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {

    @FXML
    private Button button_messages;

    @FXML
    private ListView<String> lv_messages;

    @FXML
    private Button button_logout;

    @FXML
    private Label label_client_id;
    @FXML
    private TextField tf_client_id;

    @FXML
    private Label label_date;
    @FXML
    private DatePicker dp_date;

    @FXML
    private Button button_submit;

    @FXML
    private Label label_quot;
    @FXML
    private Label label_admin;

    @FXML
    private AnchorPane ap_admin_panel;

    private User user;

    private String[] fullMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ap_admin_panel.setVisible(false);

        button_messages.setOnAction(e -> {

            label_admin.setVisible(false);
            label_quot.setVisible(false);
            try {
                String[] messages = DBUtils.getAdminMessages();
                fullMessage = new String[messages.length];
                int c = 1, i = 0;
                for (String message : messages) {
                    String[] partMessages = message.split("/");
                    fullMessage[i] = c + ". " + partMessages[0] + " is waiting for " + partMessages[2] +
                            ", what date dog will be available to pick up?";
                    c++;
                    i++;
                }
                lv_messages.getItems().addAll(fullMessage);
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("You don't have any messages");
                alert.show();
            }

            ap_admin_panel.setVisible(true);
            button_messages.setDisable(true);
        });

        button_submit.setOnAction(e -> {
            try {
                int client_id = Integer.parseInt(tf_client_id.getText());
                String[] infos = DBUtils.getAdminMessages();
                String[] info = null;
                for (int i = 0; i < infos.length; i++) {
                    if ((i + 1) == client_id) {
                        info = infos[i].split("/");
                        break;
                    }
                }
                if (info != null) {
                    Client client = new Client(info[0], info[1], info[2], dp_date.getValue().toString());
                    DogAcquisition dogAcquisition = new DogAcquisition();
                    dogAcquisition.registerObserver(client);

                    ClientDBUtils.setServicesAndItsCost(client, info[3], Double.parseDouble(info[4]));
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("You don't have any messages!");
                    alert.show();
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You must write only numbers!");
                alert.show();
            }
        });

        button_logout.setOnAction(e -> {
            DBUtils.changeScene(e, "example-sign-in.fxml", "Log In", null, null);
        });
    }

    public void setUserInfo(User user) {
        this.user = user;
    }
}
