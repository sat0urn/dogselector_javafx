module com.example.dog_selector_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens models to javafx.fxml;
    opens controllers to javafx.fxml;
    opens com.example to javafx.fxml;
    exports controllers;
    exports com.example;
    exports models;
    exports ObserverPattern;
    exports DecoratorPattern;
    exports Behaviors_and_Realizations;
    exports SpeciesOfDogs;
    exports SingletonPattern;
    exports StatePattern;
}