package com.example.myapplicationtestproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {
    private TextInputEditText name, phone, address, email, username, password;
    private TextInputLayout name_error, phone_error, address_error, email_error, username_error, password_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name=findViewById(R.id.name_text_account);
        phone=findViewById(R.id.phone_text_account);
        address=findViewById(R.id.address_text_account);
        email=findViewById(R.id.email_text_account);
        username=findViewById(R.id.username_text_account);
        password=findViewById(R.id.userpass_text_account);

        name_error=findViewById(R.id.name_account_layout);
        phone_error=findViewById(R.id.phone_number_layout);
        address_error=findViewById(R.id.address_account_layout);
        email_error=findViewById(R.id.email_account_layout);
        username_error=findViewById(R.id.username_account_layout);
        password_error=findViewById(R.id.userpass_account_layout);

    }

    public void OnClickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void OnClickAccountCreate(View view) {

        String user_name = name.getText().toString();
        String user_phone = phone.getText().toString();
        String user_address = address.getText().toString();
        String user_email = email.getText().toString();
        String user_username = username.getText().toString();
        String user_password = password.getText().toString();


        if(!isNameValido(user_name)){
            name_error.setError("Invalid Name");
            return;
        }else {
            name_error.setError(null);
        }

        if(!isPhoneValido(user_phone)){
            phone_error.setError("Invalid Phone Number");
            return;
        }else {
            phone_error.setError(null);
        }

        if(!isAddressValido(user_address)){
            address_error.setError("Invalid Address");
            return;
        }else {
            address_error.setError(null);
        }

        if(!isEmailValido(user_email)) {
            email_error.setError("Invalid Email");
            return;
        }else {
            email_error.setError(null);
        }

        if(!isUsernameValido(user_username)) {
            username_error.setError("Invalid Username");
            return;
        }else{
            username_error.setError(null);
        }

        if(!isPasswordValido(user_password)){
        password_error.setError("Invalid Password");
        return;
        }else{
            password_error.setError(null);
        }

        if(!isPhoneValido(user_phone)){
        phone_error.setError("Invalid Phone Number");
        return;
        }else {
            phone_error.setError(null);
        }

        Toast.makeText(this, "Conta criada com sucesso ", Toast.LENGTH_SHORT).show();
        finish();
    }

    private boolean isNameValido(String user_name) {
        if(user_name==null)
            return false;

        return user_name.length()>=4;
    }

    private boolean isPhoneValido(String user_phone) {
        if(user_phone==null)
            return false;

        return user_phone.length()==9;
    }

    private boolean isAddressValido(String user_address) {
        if(user_address==null)
            return false;

        return user_address.length()>=4;
    }

    private boolean isEmailValido(String user_email) {
        if(user_email==null)
            return false;

        return Patterns.EMAIL_ADDRESS.matcher(user_email).matches();
    }

    private boolean isUsernameValido(String user_username) {
        if(user_username==null)
            return false;

        return user_username.length()>=4;
    }

    private boolean isPasswordValido(String user_password) {
        if(user_password==null)
            return false;

        return user_password.length()>=4;
    }

    public void OnClickLoginAccount(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
