package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_Support_paymentsection extends AppCompatActivity {

//    TextView bra,cl,nam,iss;
//    Button yes,no;

    RecyclerView recview;
    ArrayList<support_pay_data2> datalist;
    FirebaseFirestore db;
    support_pay_adpt adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_support_paymentsection);
//        bra=findViewById(R.id.textView142t);
//        cl=findViewById(R.id.textView142tt);
//        nam=findViewById(R.id.textView142);
//        iss=findViewById(R.id.textView139);
//        yes=findViewById(R.id.button39);
//        no=findViewById(R.id.button40);
        recview = (RecyclerView) findViewById(R.id.rv789);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist = new ArrayList<support_pay_data2>();
        adapter = new support_pay_adpt(datalist);
        recview.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();
        db.collection("Support_payment_issue").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            support_pay_data2 obj = d.toObject(support_pay_data2.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });


    }
}