package com.example.abcs;

import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class downlodpdf extends AppCompatActivity {
    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<downlodpdf_data> downModelArrayList = new ArrayList<>();
    downlodpdf_adpt myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downlodpdf);



        setUpRV();
        setUpFB();
        dataFromFirebase();
    }


    private void dataFromFirebase() {
        if(downModelArrayList.size()>0)
            downModelArrayList.clear();

        //db=FirebaseFirestore.getInstance();

        db.collection("Notices")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot documentSnapshot: task.getResult()) {

                            downlodpdf_data downModel= new downlodpdf_data(documentSnapshot.getString("Subject"),
                                    documentSnapshot.getString("pdfurl1"));
                            downModelArrayList.add(downModel);

                        }

                        myAdapter= new downlodpdf_adpt(downlodpdf.this,downModelArrayList);
                        mRecyclerView.setAdapter(myAdapter);
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(downlodpdf.this, "Error ;-.-;", Toast.LENGTH_SHORT).show();
                    }
                })
        ;


    }

    private void setUpFB(){
        db=FirebaseFirestore.getInstance();
    }

    private void setUpRV(){
        mRecyclerView= findViewById(R.id.recycle101);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}
