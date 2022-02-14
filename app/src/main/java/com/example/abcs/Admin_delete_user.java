package com.example.abcs;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_delete_user extends AppCompatActivity
{


    RecyclerView recview;
    ArrayList<UserData> datalist;
    FirebaseFirestore db;
    UserDataAdpt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userwiser_permision_fetch);

        recview = (RecyclerView) findViewById(R.id.rva1);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist = new ArrayList<UserData>();
        adapter = new UserDataAdpt(datalist);
        recview.setAdapter(adapter);
        String currrrem = getIntent().getStringExtra("currentuseremail");
        ;
        db = FirebaseFirestore.getInstance();


//        db.collection("demo").whereEqualTo("Email",currrrem).get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot d:list)
//                        {
//                            UserData obj=d.toObject(UserData.class);
//                            datalist.add(obj);
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                });
//
        db = FirebaseFirestore.getInstance();
        db.collection("demo").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            UserData obj = d.toObject(UserData.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

}