package com.example.abcs;


import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_exam_payrecord extends AppCompatActivity
{
    RecyclerView recview;
    ArrayList<A_exam_data> datalist;
    FirebaseFirestore db;
    A_exam_adpt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_exam_payrecord);

        recview=(RecyclerView)findViewById(R.id.rv1000);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<A_exam_data>();
        adapter=new A_exam_adpt(datalist);
        recview.setAdapter(adapter);

        db=FirebaseFirestore.getInstance();


        db.collection("Final_paymnet_data").whereEqualTo("Section","Examsection").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            A_exam_data obj=d.toObject(A_exam_data.class);

                            datalist.add(obj);
                            String name=d.getString("Email");
                            //     Toast.makeText(Admin_hostel_payrecord.this, name +d.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Admin_exam_payrecord.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



//        db.collection("Final_paymnet_data").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot d:list)
//                        {
//                            A_exam_data obj=d.toObject(A_exam_data.class);
//                            datalist.add(obj);
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                });
    }
}