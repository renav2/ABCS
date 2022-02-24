package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_tool_noticedelete extends AppCompatActivity {

    RecyclerView recview;
    ArrayList<notice_dlt_data> datalist;
    FirebaseFirestore db;
    notic_dlt_Adpt adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tool_noticedelete);
        recview = (RecyclerView) findViewById(R.id.rvzxc);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist = new ArrayList<notice_dlt_data>();
        adapter = new notic_dlt_Adpt(datalist);
        recview.setAdapter(adapter);
        String currrrem = getIntent().getStringExtra("currentuseremail");

        db = FirebaseFirestore.getInstance();



        db = FirebaseFirestore.getInstance();
        db.collection("Notices").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            notice_dlt_data obj = d.toObject(notice_dlt_data.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });


    }
}