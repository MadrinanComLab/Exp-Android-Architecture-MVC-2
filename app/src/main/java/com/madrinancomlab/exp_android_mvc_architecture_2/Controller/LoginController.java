package com.madrinancomlab.exp_android_mvc_architecture_2.Controller;

import com.madrinancomlab.exp_android_mvc_architecture_2.Model.User;
import com.madrinancomlab.exp_android_mvc_architecture_2.View.InterfaceLoginView;

public class LoginController implements InterfaceLoginController
{
    InterfaceLoginView loginView;

    public LoginController(InterfaceLoginView loginView)
    {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password)
    {
        // CREATING USER OBJECT
        User user = new User(email, password);
        int loginCode = user.isValid();

        switch (loginCode)
        {
            case 0:
                loginView.onLoginError("Please enter your email...");
                break;

            case 1:
                loginView.onLoginError("Please enter a valid email...");
                break;

            case 2:
                loginView.onLoginError("Please enter your password...");
                break;

            case 3:
                loginView.onLoginError("Password should be more than 6 characters length...");
                loginView.onLoginError("Please enter your email...");
                break;

            default:
                loginView.onLoginSuccess("Login Success!");
        }
    }
}
