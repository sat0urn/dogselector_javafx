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
        Parent root = FXMLLoader.load(getClass().getResource("example-sign-in.fxml"));
        stage.setTitle("Log In");
        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("pictures/websites/favicon.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}