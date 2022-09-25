package com.vj.dontwaitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectRoll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_roll);
    }
    public void toOfficerLogin(View view) {
        Intent office = new Intent(SelectRoll.this, OfficerLogin.class);
        startActivity(office);
    }
    public void toTravelerHome(View view) {
        Intent office = new Intent(SelectRoll.this, TravellerHome.class);
        startActivity(office);

    }

}