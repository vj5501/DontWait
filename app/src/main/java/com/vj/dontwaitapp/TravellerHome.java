package com.vj.dontwaitapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class TravellerHome extends AppCompatActivity {


    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    ArrayList<Route> routeArrayList;
    RouteAdapter routeAdapter;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveller_home);

        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fwtching" );
        progressDialog.show();

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db=FirebaseFirestore.getInstance();
        routeArrayList =new ArrayList<Route>();
        routeAdapter= new RouteAdapter(this, routeArrayList);

        recyclerView.setAdapter(routeAdapter);
        getData();


    }

    private void getData() {

        db.collection("Routes")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error!=null){
                            if (progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                            Log.e("Firestore Error: ",error.getMessage());
                            return;
                        }
                        for (DocumentChange dc:value.getDocumentChanges()){
                            if (dc.getType()==DocumentChange.Type.ADDED){
                                routeArrayList.add(dc.getDocument().toObject(Route.class));
                            }
                            routeAdapter.notifyDataSetChanged();
                            if (progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                        }

                    }
                })   ;
    }

}