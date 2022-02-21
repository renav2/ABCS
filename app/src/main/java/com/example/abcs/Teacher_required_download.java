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

public class Teacher_required_download extends AppCompatActivity {
    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<Teacherdowndata> downModelArrayList = new ArrayList<>();
    TeacherdownAdpt myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_required_download);


        setUpRV();
        setUpFB();
        dataFromFirebase();
    }


    private void dataFromFirebase() {
        if(downModelArrayList.size()>0)
            downModelArrayList.clear();

        //db=FirebaseFirestore.getInstance();

        db.collection("shubham")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot documentSnapshot: task.getResult()) {

                            Teacherdowndata downModel= new Teacherdowndata(documentSnapshot.getString("uid"),
                                    documentSnapshot.getString("url10"));
                            downModelArrayList.add(downModel);

                        }

                        myAdapter= new TeacherdownAdpt(Teacher_required_download.this,downModelArrayList);
                        mRecyclerView.setAdapter(myAdapter);
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Teacher_required_download.this, "Error ;-.-;", Toast.LENGTH_SHORT).show();
                    }
                })
        ;


    }

    private void setUpFB(){
        db=FirebaseFirestore.getInstance();
    }

    private void setUpRV(){
        mRecyclerView= findViewById(R.id.recdocd);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}
