package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage.setTitle("Log In");
        stage.setScene(new Scene(root, 600, 400));
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("pictures/favicon.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}