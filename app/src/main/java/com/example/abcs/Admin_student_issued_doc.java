package com.example.abcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_student_issued_doc extends AppCompatActivity {
TextView d1,d2;
    RecyclerView recview;
    ArrayList<issuedoc_data> datalist;
    FirebaseFirestore db;
    issue_doc_adpt adapter;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_issued_doc);
        recview=(RecyclerView)findViewById(R.id.lmllmmllml);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<issuedoc_data>();
        adapter=new issue_doc_adpt(datalist);
        recview.setAdapter(adapter);
        d1=findViewById(R.id.doc2);
        d2=findViewById(R.id.doc1);
        d1.setText(getIntent().getStringExtra("docname"));//bonafide
        d2.setText(getIntent().getStringExtra("docname2"));//fee

        if(d1.getText().toString().equals("Bonafide")){
            a="bonafide";
        }
        if(d2.getText().toString().equals("feestucture")){
            a="feestucture";
        }

        db=FirebaseFirestore.getInstance();
        db.collection("document_issue_by_clg").whereEqualTo("documentname",a).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            issuedoc_data obj=d.toObject(issuedoc_data.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }
    }