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

public class userwiser_permision_fetch extends AppCompatActivity
{
    
    
    RecyclerView recview;
    ArrayList<up_model> datalist;
    FirebaseFirestore db;
    up_adpt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userwiser_permision_fetch);

        recview=(RecyclerView)findViewById(R.id.rva1);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<up_model>();
        adapter=new up_adpt(datalist);
        recview.setAdapter(adapter);
String currrrem=getIntent().getStringExtra("currentuseremail");;
        db=FirebaseFirestore.getInstance();


        db.collection("final_permision_status").whereEqualTo("Email",currrrem).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            up_model obj=d.toObject(up_model.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });



    }

}