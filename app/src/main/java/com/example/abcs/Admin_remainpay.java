package com.example.abcs;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class Admin_remainpay extends AppCompatActivity
{
    RecyclerView recview;
    ArrayList<a_search_data> datalist;
    FirebaseFirestore db;
    A_searchadpt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_search_remainpay);
        recview=(RecyclerView)findViewById(R.id.rv1);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<a_search_data>();
        adapter=new A_searchadpt(datalist);
        recview.setAdapter(adapter);
        db=FirebaseFirestore.getInstance();

        db.collection("collagefees_1_installment").whereNotEqualTo("_1Student_remain_fees","0").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            a_search_data obj=d.toObject(a_search_data.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}