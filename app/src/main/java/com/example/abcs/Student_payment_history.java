package com.example.abcs;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Student_payment_history extends AppCompatActivity
{


    RecyclerView recview;
    ArrayList<S_his_data> datalist;
    FirebaseFirestore db;

    FirebaseAuth auth;

    S_his_adpt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_payment_history);

        recview=(RecyclerView)findViewById(R.id.zxzx);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<S_his_data>();
        adapter=new S_his_adpt(datalist);
        recview.setAdapter(adapter);
        String currrrem=getIntent().getStringExtra("unicid_payhistory");;
        db=FirebaseFirestore.getInstance();
auth=FirebaseAuth.getInstance();


        db.collection("Final_paymnet_data").whereEqualTo("Email",auth.getCurrentUser().getEmail()).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            S_his_data obj=d.toObject(S_his_data.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });



    }

}