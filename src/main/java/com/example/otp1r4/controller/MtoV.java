package com.example.otp1r4.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/** {@code @Brief} Interface for controllers - model to view.
 *  Methods that are needed for in model to view order.
 *
 *  See VtoM Interface for view to model applications.
 */
public interface MtoV {
    /**
     * @param nextView fxml file name ex. mainView.fxml
     * @param currentNode Scene node 'object' ex. TextField usernameField
     * @throws IOException
     */
    default void changeScene(String nextView, Node currentNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(nextView)));
        Stage window = (Stage) currentNode.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    /**
     * @param nextView fxml file name ex. mainView.fxml
     * @param currentNode Scene node 'object' ex. TextField usernameField
     * @throws IOException
     */
    default void addSceneOnTop(String nextView, Node currentNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(nextView)));
        Stage window = new Stage();
        window.initOwner(currentNode.getScene().getWindow());

        window.setScene(new Scene(root));
        window.show();
    }
}
