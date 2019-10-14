module Test {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.jfoenix;
    requires java.sql;
    requires mysql.connector.java;

    opens sample.controllers;
    opens sample;
    opens sample.Database;


}