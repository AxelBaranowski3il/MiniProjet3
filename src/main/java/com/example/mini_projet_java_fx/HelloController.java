package com.example.mini_projet_java_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void startGame(ActionEvent event) {
        try {
            Parent root;
            Stage rapport = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("Game.fxml"));


            root = loader.load();
            rapport.setScene(new Scene(root));
            rapport.setTitle("JEU");
            rapport.show();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();

        } catch (IOException e) {
            System.out.println("Problème lors de"
                    + " la création de l'interface");
        }
    }
}