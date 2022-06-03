package com.madrinancomlab.exp_android_mvc_architecture_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.madrinancomlab.exp_android_mvc_architecture_2.Controller.InterfaceLoginController;
import com.madrinancomlab.exp_android_mvc_architecture_2.Controller.LoginController;
import com.madrinancomlab.exp_android_mvc_architecture_2.View.InterfaceLoginView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener, InterfaceLoginView
{
    EditText txtEmail, txtPassword;
    Button btnLogin;

    InterfaceLoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginController = new LoginController(this);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnLogin:
                loginController.onLogin(txtEmail.getText().toString(), txtPassword.getText().toString());
                break;
        }
    }

    @Override
    public void update(Observable observable, Object o)
    {

    }

    // THIS EVENT IS FROM InterfaceLoginView
    @Override
    public void onLoginSuccess(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // THIS EVENT IS FROM InterfaceLoginView
    @Override
    public void onLoginError(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}