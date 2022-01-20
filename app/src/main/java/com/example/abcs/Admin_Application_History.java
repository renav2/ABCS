package com.example.abcs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_Application_History extends AppCompatActivity {
     List<String> sname = new ArrayList<>();
     String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_application_history);

        ListView l;

        FirebaseFirestore fs= FirebaseFirestore.getInstance();
        FirebaseAuth fa= FirebaseAuth.getInstance();
        //String uid= fa.getUid();
        setContentView(R.layout.activity_previous_application);
        l = findViewById(R.id.list);
        fs.collection("Permission_Applications").addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent (QuerySnapshot value, FirebaseFirestoreException error){
                            sname.clear();
                            for (DocumentSnapshot snapshot : value) {
                                sname.add(snapshot.getString("Name"));
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_selectable_list_item, sname);
                            adapter.notifyDataSetChanged();
                            l.setAdapter(adapter);

                        }
                    });

        l.setOnItemClickListener(new AdapterView.OnItemClickListener()

                    {
                        @Override
                        public void onItemClick (AdapterView < ? > adapterView, View view,int i,
                        long l){
                        startActivity(new Intent(Admin_Application_History.this, Admin_View_Application.class));
                    }
                    });
      //  int p= l.;
       // uid = (String)l.getItemAtPosition();
                }
    }