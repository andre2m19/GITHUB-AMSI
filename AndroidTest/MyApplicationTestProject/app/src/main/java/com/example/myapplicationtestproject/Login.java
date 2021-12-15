package com.example.myapplicationtestproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    private TextInputEditText user, userpass;
    private String checkuser,checkdatasaved;
    private CheckBox datasaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=findViewById(R.id.user_text);
        userpass=findViewById(R.id.userpass_text);

        datasaved=findViewById(R.id.datasaved);

        //SharedPreferences
        SharedPreferences sharedPreferencesInfoUser = getSharedPreferences("DADOS_USER", Context.MODE_PRIVATE);
        checkuser = sharedPreferencesInfoUser.getString("USER_NAME",null);
        checkdatasaved = sharedPreferencesInfoUser.getString("USER_CHECK",null);

        // Checks if remember me button is gonna be checked
        // if yes gets user text and shows username
        // if no sets user text to null
        if(checkdatasaved!=null){
            datasaved.setChecked(true);
            user.setText(checkuser);
        }else{
            user.setText(null);
        }
    }

    public void OnClickLogin(View view) {
        String username = user.getText().toString();
        String password = userpass.getText().toString();

        // User validation
        if(!isUserValido(username)){
            //Set error on Text Layout (User input text)
            TextInputLayout til = findViewById(R.id.userl);
            til.setError("Username Invalido");
            return;
        }

        // Password validation
        if(!isPasswordValido(password)){
            //Set error on Text Layout (Password input text)
            TextInputLayout til = findViewById(R.id.userpassl);
            til.setError("PassWord Invalida");
            return;
        }

        //TODO CREATE ON MAIN ACTIVITY DELETE FROM APP MAIN
        // SharedPreferences
        // checks remember me button
        // if checked create a string with the name "USER_CHECK" saying saved
        // if not checked string is set to null
        if(datasaved.isChecked()){
            SharedPreferences sharedPreferencesInfoUser = getSharedPreferences("DADOS_USER", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesInfoUser.edit();
            editor.putString("USER_CHECK", "saved");
            editor.apply();
        }else {
            SharedPreferences sharedPreferencesInfoUser = getSharedPreferences("DADOS_USER", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesInfoUser.edit();
            editor.putString("USER_CHECK", null);
            editor.apply();
        }

        //Toast.makeText(this, "login com sucesso " + username +" "+ password, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AppMainMenu.class);
        intent.putExtra("USER_NAME",username);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // lOG IN VALIDATIONS

    private boolean isUserValido(String username){
        if(username==null)
            return false;

        return username.length()>=4;
    }

    private boolean isPasswordValido(String password){
        if(password==null)
            return false;

        return password.length()>=4;
    }

    // OnClickButtons

    public void OnClickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void OnClickAccountLogin(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
        finish();
    }
}
