package com.example.otp1r4.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DeviceController implements Controller {
    @FXML
    Label deviceName;
    @FXML
    Label deviceDataLabel;

    public Label getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String name) {
        deviceName.setText(name);
    }
}
