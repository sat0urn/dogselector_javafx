module com.example.dog_selector_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example to javafx.fxml;
    exports com.example;
    exports controllers;
    opens controllers to javafx.fxml;
    exports models;
    opens models to javafx.fxml;
    exports ObserverPattern;
    exports DecoratorPattern;
    exports Behaviors_and_Realizations;
    exports SpeciesOfDogs;
    exports SingletonPattern;
}