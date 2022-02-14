package com.example.abcs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Admin_asper_dept_class extends AppCompatActivity
{

    RecyclerView recview;
    ArrayList<model> datalist;
    FirebaseFirestore db;
    myadapter adapter;
    TextView _1;
            //_2,_3,_4;
String txt_yr,txt_dept;
    TextView comp, it,entc,cvil,mech;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_asper_dept_class);
        _1=findViewById(R.id._1);
//        _2=findViewById(R.id._2);
//        _3=findViewById(R.id._3);
//        _4=findViewById(R.id._4);


        comp  =findViewById(R.id.textView105);
        it=findViewById(R.id.textView106);
        entc =findViewById(R.id.textView107);
        cvil =findViewById(R.id.textView108);
        mech=findViewById(R.id.textView109);

//                _1.setVisibility(View.INVISIBLE);
//                _2.setVisibility(View.INVISIBLE);
//                _3.setVisibility(View.INVISIBLE);
//                 _4.setVisibility(View.INVISIBLE);


        recview=(RecyclerView)findViewById(R.id.rv999);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<model>();
        adapter=new myadapter(datalist);
        recview.setAdapter(adapter);
        db=FirebaseFirestore.getInstance();


        comp.setText(getIntent().getStringExtra("deco1"));
        it.setText(getIntent().getStringExtra("deco2"));
        entc.setText(getIntent().getStringExtra("deco3"));
        cvil.setText(getIntent().getStringExtra("deco4"));
        mech.setText(getIntent().getStringExtra("deco5"));



        _1.setText(getIntent().getStringExtra("class1"));



        db.collection("student_req_permision_data").whereEqualTo("class","BE").whereEqualTo("brnach","Comp").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            model obj=d.toObject(model.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

    }




}