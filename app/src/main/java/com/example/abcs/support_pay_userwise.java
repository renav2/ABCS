package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class support_pay_userwise extends AppCompatActivity {
    RecyclerView recview;
    ArrayList<suport_data> datalist;
    FirebaseFirestore db;
    suport_adpt adapter;
FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_support_pay_userwise);
        recview=(RecyclerView)findViewById(R.id.rvmjn);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<suport_data>();
        adapter=new suport_adpt(datalist);
        recview.setAdapter(adapter);
        String currrrem=getIntent().getStringExtra("currentuseremail");;



        db=FirebaseFirestore.getInstance();
        db.collection("financial_problem_student_paymentdata").whereEqualTo("Email",auth.getCurrentUser().getEmail()).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            suport_data obj=d.toObject(suport_data.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });




    }
}