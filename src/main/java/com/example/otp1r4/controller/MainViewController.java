package com.example.otp1r4.controller;


import com.example.otp1r4.model.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Controller, Initializable {

    @FXML
    TabPane mainViewTabPane;
    @FXML
    Tab favoriteDevicesTab, allDevicesTab, deviceDataTab;
    @FXML
    Button profileButton, logoutButton;

    UserData user = UserData.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader tab1Loader = new FXMLLoader(getClass().getResource("/com/example/otp1r4/favoriteDevicesView.fxml"));
        FXMLLoader tab2Loader = new FXMLLoader(getClass().getResource("/com/example/otp1r4/allDevicesView.fxml"));
        FXMLLoader tab3Loader = new FXMLLoader(getClass().getResource("/com/example/otp1r4/deviceDataView.fxml"));
        try {
            Node tab1Content = tab1Loader.load();
            Node tab2Content = tab2Loader.load();
            //Node tab3Content = tab3Loader.load();

            favoriteDevicesTab.setContent(tab1Content);
            allDevicesTab.setContent(tab2Content);
            //deviceDataTab.setContent(tab3Content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickLogout() throws IOException {
        user = null;
        this.changeScene("login.fxml", logoutButton);
    }

    public void clickProfile() throws IOException {
        this.addSceneOnTop("profileView.fxml", profileButton);
    }
}
