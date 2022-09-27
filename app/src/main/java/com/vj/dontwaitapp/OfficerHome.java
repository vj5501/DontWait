package com.vj.dontwaitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.Map;

public class OfficerHome extends AppCompatActivity {

    Button button;
    EditText etSource,etDesti, etBusno;
    EditText etTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_home);
        button=findViewById(R.id.button1);
        etSource=findViewById(R.id.etSource);
        etDesti=findViewById(R.id.etDest);
        etBusno=findViewById(R.id.etbusn);
        etTime=findViewById(R.id.etTime);
        etTime.setText(Timestamp.now().toDate().toString());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Editable busno= etBusno.getText();
                String source= etSource.getText().toString();
                String destination= etDesti.getText().toString();
                String time= (Timestamp.now().toDate().toString());



                FirebaseFirestore firestore=FirebaseFirestore.getInstance();
                Map<String,Object > route = new HashMap<>();
                route.put("BusNo",busno);
                route.put("Source",source);
                route.put("Destination",destination);
                route.put("LeavingTime",time);

                try {

                    firestore.collection("Routes").add(route).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(OfficerHome.this, "Added Route to Database", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(OfficerHome.this, "Error:Cannot Route to Database", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                catch (Exception e){
                    Toast.makeText(OfficerHome.this, "Added Route to Database", Toast.LENGTH_SHORT).show();

                }
                etBusno.setText(" ");
                etSource.setText(" ");
                etDesti.setText(" ");
                etTime.setText(Timestamp.now().toDate().toString());
            }
        });
    }
}