package com.vj.dontwaitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OfficerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_home);
    }

    public void addEntry(View view) {
        Toast.makeText(this, "Added SuccessFully", Toast.LENGTH_SHORT).show();
    }
}