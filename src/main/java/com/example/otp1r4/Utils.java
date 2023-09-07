package com.example.otp1r4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Utils {

    /**
     *
     * @param nextView fxml file name ex. mainView.fxml
     * @param currentNode Scene node 'object' ex. TextField usernameField
     * @throws IOException
     */
    public void changeScene(String nextView, Node currentNode) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(nextView));
        Stage window = (Stage) currentNode.getScene().getWindow();
        window.setScene(new Scene(root));
    }

}
