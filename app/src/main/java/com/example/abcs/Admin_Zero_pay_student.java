package com.example.abcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_Zero_pay_student extends AppCompatActivity {

    RecyclerView recview;
    ArrayList<zero_pay_data> datalist;
    FirebaseFirestore db;
    zero_pay_adpt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_zero_pay_student);

        recview=(RecyclerView)findViewById(R.id.a1a2);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<zero_pay_data>();
        adapter=new zero_pay_adpt(datalist);
        recview.setAdapter(adapter);
db=FirebaseFirestore.getInstance();
        db.collection("demo").whereEqualTo("collagepayemtfees____","0").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            zero_pay_data obj=d.toObject(zero_pay_data.class);

                            datalist.add(obj);
                          //  String name=d.getString("Email");
                            //     Toast.makeText(Admin_hostel_payrecord.this, name +d.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Admin_Zero_pay_student.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


}