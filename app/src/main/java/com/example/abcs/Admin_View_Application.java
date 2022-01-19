package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_View_Application extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_application);
        ListView l;
//  FirebaseAuth auth= FirebaseAuth.getInstance();
        FirebaseFirestore fs= FirebaseFirestore.getInstance();
        final List<String> sname = new ArrayList<>();

            setContentView(R.layout.activity_previous_application);
            l = findViewById(R.id.list);
            /*l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openApplicationAt();
                }
            });*/

            fs.collection("Permission_Applications").addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent( QuerySnapshot value, FirebaseFirestoreException error) {
                    sname.clear();
                    for(DocumentSnapshot snapshot : value){
                        sname.add(snapshot.getString("Name"));
                    }
                    ArrayAdapter<String> adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_selectable_list_item,sname);
                    adapter.notifyDataSetChanged();
                    l.setAdapter(adapter);
                }
            });
    }
}