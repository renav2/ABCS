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

public class Admin_delete_teacher extends AppCompatActivity
{


    RecyclerView recview;
    ArrayList<TeacherData> datalist;
    FirebaseFirestore db;
    TeacherDataAdpt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_teacher);

        recview = (RecyclerView) findViewById(R.id.rvte1);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist = new ArrayList<TeacherData>();
        adapter = new TeacherDataAdpt(datalist);
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
        db.collection("tdemo").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            TeacherData obj = d.toObject(TeacherData.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

}