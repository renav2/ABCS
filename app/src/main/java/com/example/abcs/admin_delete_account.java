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

public class admin_delete_account extends AppCompatActivity
{


    RecyclerView recview;
    ArrayList<AccountData> datalist;
    FirebaseFirestore db;
    AccountAdpt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_account);

        recview = (RecyclerView) findViewById(R.id.rvda);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist = new ArrayList<AccountData>();
        adapter = new AccountAdpt(datalist);
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
        db.collection("Ademo").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            AccountData obj = d.toObject(AccountData.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

}