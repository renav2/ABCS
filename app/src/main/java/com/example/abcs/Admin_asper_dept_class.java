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
//        _2.setText(getIntent().getStringExtra("class2"));
//        _3.setText(getIntent().getStringExtra("class3"));
//        _4.setText(getIntent().getStringExtra("class4"));



//        deit.setText(getIntent().getStringExtra("deptit"));
//dpi.setText(getIntent().getStringExtra("deptnname"));
      //  dpi.setText(getIntent().getStringExtra("deptit"));

//
//        if(_2.getText().toString().equals("FE")){
//            gamechange="FE";
//        }
//        if(_2.getText().toString().equals("SE")){
//        gamechange="SE";
//    }
//        if(_2.getText().toString().equals("TE")){
//            gamechange="TE";
//        }
//        if(_2.getText().toString().equals("BE")){
//            gamechange="BE";
//        }


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
        if(_1.getText().toString().equals("BE") && comp.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && comp.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && comp.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && comp.getText().toString().equals("Mech")){
            txt_dept="Mech";
            txt_yr="FE";
        }

//civil
        if(_1.getText().toString().equals("BE") && comp.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && comp.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && comp.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && comp.getText().toString().equals("Civil")){
            txt_dept="Civil";
            txt_yr="FE";
        }




        //entc
        if(_1.getText().toString().equals("BE") && comp.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && comp.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && comp.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && comp.getText().toString().equals("ENTC")){
            txt_dept="ENTC";
            txt_yr="FE";
        }


//it
        if(_1.getText().toString().equals("BE") && comp.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="BE";
        }
        if (_1.getText().toString().equals("SE") && comp.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="SE";
        }
        if (_1.getText().toString().equals("TE") && comp.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="TE";
        }
        if (_1.getText().toString().equals("FE") && comp.getText().toString().equals("IT")){
            txt_dept="IT";
            txt_yr="FE";
        }







        db.collection("student_req_permision_data").whereEqualTo("class",txt_yr).whereEqualTo("brnach",txt_dept).get()
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