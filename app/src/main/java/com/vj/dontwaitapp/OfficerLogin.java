package com.vj.dontwaitapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OfficerLogin extends AppCompatActivity {
    EditText userNameEdt, passwordEdt;
     Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_login);
        userNameEdt = findViewById(R.id.idEdtUserName);
        passwordEdt = findViewById(R.id.idEdtPassword);
        loginBtn = findViewById(R.id.idBtnLogin);
        // adding on click listener for our button.
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are getting data from our edit text.
                String userName = userNameEdt.getText().toString();
                String password = passwordEdt.getText().toString();

                // checking if the entered text is empty or not.
                if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(password)) {
                    Toast.makeText(OfficerLogin.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                }
                else{
                loginUser(userName, password);
                }
            }

            private void loginUser(String userName, String password) {
                if(userName.equals("username") && password.equals("password")){
                Intent office = new Intent(OfficerLogin.this, OfficerHome.class);
                startActivity(office);}
                else{
                    Toast.makeText(OfficerLogin.this, "Please enter Valid username and password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }}
