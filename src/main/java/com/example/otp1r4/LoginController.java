package com.example.otp1r4;

import com.example.otp1r4.dao.SignDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    Utils u = new Utils();

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLabelUsername;
    @FXML
    private Label errorLabelPassword;
    @FXML
    private Hyperlink signUpLink;

    String username;
    String password;

    public void clickLogin(ActionEvent actionEvent) throws Exception {
        SignDAO dao = new SignDAO();

        username = usernameField.getText();
        password = passwordField.getText();

        errorLabelUsername.setText("");
        errorLabelPassword.setText("");

        boolean isValid = true;

        if(username.isEmpty()) {
            errorLabelUsername.setText("Syötä käyttäjätunnus!");
            isValid = false;
        }  else if (!username.matches("([A-Za-z0-9\\-\\_]+)")){
            usernameField.setText("");
            errorLabelUsername.setText("Syötä käyttäjätunnus hyväksytyssä muodossa!");
            isValid =false;
        }

        if (password.isEmpty()){
            errorLabelPassword.setText("Syötä salasana!");
            isValid = false;
        }

        if(isValid) {
            if(dao.authenticate(username,password)){
                UserData userData = UserData.getInstance();
                userData.setUsername(username);
                u.changeScene("mainView.fxml", usernameField);
            }else {
                errorLabelPassword.setText("Käyttäjätunnus tai salasana väärin!");
            }
        }
    }

    public void clickSignup() throws IOException {
        u.changeScene("registerView.fxml", usernameField);
    }

    public void clickForgotPassword() throws IOException{
        u.changeScene("forgotPasswordView.fxml", usernameField);
    }

}