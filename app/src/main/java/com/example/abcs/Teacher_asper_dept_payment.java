package com.example.abcs;

import android.os.Bundle;
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

public class Teacher_asper_dept_payment extends AppCompatActivity
{
    RecyclerView recview;
    ArrayList<PaymentData> datalist;
    FirebaseFirestore db;
    PaymentAdpt adapter;
    TextView _1;
    String txt_yr,txt_dept;
    TextView comp, it,entc,cvil,mech;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_asper_dept_payment);
        _1=findViewById(R.id._1);
        comp  =findViewById(R.id.textView105);
        it=findViewById(R.id.textView106);
        entc =findViewById(R.id.textView107);
        cvil =findViewById(R.id.textView108);
        mech=findViewById(R.id.textView109);
        recview=(RecyclerView)findViewById(R.id.tepay);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<PaymentData>();
        adapter=new PaymentAdpt(datalist);
        recview.setAdapter(adapter);
        db=FirebaseFirestore.getInstance();
        comp.setText(getIntent().getStringExtra("deco1"));
        it.setText(getIntent().getStringExtra("deco2"));
        entc.setText(getIntent().getStringExtra("deco3"));
        cvil.setText(getIntent().getStringExtra("deco4"));
        mech.setText(getIntent().getStringExtra("deco5"));
        _1.setText(getIntent().getStringExtra("class1"));

        //comp
        if(_1.getText().toString().equals("BE") && comp.getText().toString().equals("Comp")){
            txt_dept="Comp";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && comp.getText().toString().equals("Comp")){
            txt_dept="Comp";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && comp.getText().toString().equals("Comp")){
            txt_dept="Comp";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && comp.getText().toString().equals("Comp")){
            txt_dept="Comp";
            txt_yr="FE";
        }
//mech
        if(_1.getText().toString().equals("BE") && mech.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && mech.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && mech.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && mech.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="FE";
        }

//civil
        if(_1.getText().toString().equals("BE") && cvil.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && cvil.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && cvil.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && cvil.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="FE";
        }
        //entc
        if(_1.getText().toString().equals("BE") && entc.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && entc.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && entc.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && entc.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="FE";
        }
//it
        if(_1.getText().toString().equals("BE") && it.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && it.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && it.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && it.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="FE";
        }
        db.collection("Final_paymnet_data").whereEqualTo("_class",txt_yr).whereEqualTo("branch",txt_dept).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            PaymentData obj=d.toObject(PaymentData.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}