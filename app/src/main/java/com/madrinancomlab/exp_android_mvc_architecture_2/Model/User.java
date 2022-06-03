package com.madrinancomlab.exp_android_mvc_architecture_2.Model;

public class User implements InterfaceUser
{
    private String email, password;

    public User(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail()
    {
        return null;
    }

    @Override
    public String getPassword()
    {
        return null;
    }

    @Override
    public int isValid()
    {
        return 0;
    }
}
