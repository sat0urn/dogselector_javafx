package controllers;

import com.example.DBUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField tf_login;

    @FXML
    private PasswordField pf_password;

    @FXML
    private Button button_sign_in;

    @FXML
    private Button button_sign_up;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_sign_in.setOnAction(e -> {
            DBUtils.logInUser(e, tf_login.getText(), pf_password.getText());
        });

        button_sign_up.setOnAction(e -> {
            DBUtils.changeScene(e, "sign-up.fxml", "Registration", null, null);
        });
    }
}
