package com.example.abcs;

import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Teacher_required_download extends AppCompatActivity {
    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<Teacherdowndata> downModelArrayList = new ArrayList<>();
    TeacherdownAdpt myAdapter;
    String s;
    TextView t;TextView _1;
    String txt_yr,txt_dept;
    TextView comp, it,entc,cvil,mech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_required_download);

        _1=findViewById(R.id._1);
        comp  =findViewById(R.id.textView105);
        it=findViewById(R.id.textView106);
        entc =findViewById(R.id.textView107);
        cvil =findViewById(R.id.textView108);
        mech=findViewById(R.id.textView109);

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



            if(downModelArrayList.size()>0)
                downModelArrayList.clear();

            //db=FirebaseFirestore.getInstance();
//        db.collection("Final_paymnet_data").whereEqualTo("_class",txt_yr).whereEqualTo("branch",txt_dept).get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot d:list)
//                        {
//                            PaymentData obj=d.toObject(PaymentData.class);
//                            datalist.add(obj);
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                });

        db.collection("shubham").whereEqualTo("class",txt_yr).whereEqualTo("branch",txt_dept).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            for(DocumentSnapshot documentSnapshot: task.getResult()) {

                                Teacherdowndata downModel= new Teacherdowndata(documentSnapshot.getString("uid"),
                                        documentSnapshot.getString("url10"),documentSnapshot.getString("email"));
                                downModelArrayList.add(downModel);

                            }

                            myAdapter= new TeacherdownAdpt(Teacher_required_download.this,downModelArrayList);
                            mRecyclerView.setAdapter(myAdapter);
                        }
                    })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Teacher_required_download.this, "Error ;-.-;", Toast.LENGTH_SHORT).show();
                        }
                    });


        setUpRV();
        setUpFB();

    }



    private void setUpFB(){
        db=FirebaseFirestore.getInstance();
    }

    private void setUpRV(){
        mRecyclerView= findViewById(R.id.recdocd);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}
