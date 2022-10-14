package controllers;

import com.example.DBUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField tf_firstname;

    @FXML
    private TextField tf_lastname;

    @FXML
    private TextField tf_login;

    @FXML
    private PasswordField pf_password;

    @FXML
    private Button button_sign_up;

    @FXML
    private Button button_sign_in;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_sign_up.setOnAction(e -> {
            DBUtils.signUpUser(e, tf_firstname.getText(), tf_lastname.getText(), tf_login.getText(), pf_password.getText());
        });

        button_sign_in.setOnAction(e -> {
            DBUtils.changeScene(e, "main.fxml", "Log In", null, null);
        });
    }
}
