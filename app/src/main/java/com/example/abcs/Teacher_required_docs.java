package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Teacher_required_docs extends AppCompatActivity {
    
    EditText tename,stroll,reqdoc,docdesc;
    Button sub;
    Spinner branch,clas;

    //FirebaseDatabase db;
    FirebaseAuth auth;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_required_docs);
        docdesc=findViewById(R.id.editTextTextMultiLine4);
        tename=findViewById(R.id.tname);
        stroll=findViewById(R.id.srollno);
        branch=findViewById(R.id.sbranch);
        clas=findViewById(R.id.sclass);
        sub=findViewById(R.id.docs);
        auth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        reqdoc=findViewById(R.id.editTextTextMultiLine2);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });


        
    }

    private void sendData() {
        String txt_name = tename.getText().toString();
        String txt_roll = stroll.getText().toString();
        String txt_branch = branch.getSelectedItem().toString();
        String txt_class = clas.getSelectedItem().toString();
        String txt_reqdoc=reqdoc.getText().toString();
String txt_docdesc=docdesc.getText().toString();

        DocumentReference reference=fstore.collection("Teacher_required_docs").document(txt_roll);
        Map<String, String> v=new HashMap<>();
        v.put("Teacher_Name",txt_name);
        v.put("Roll_No",txt_roll);
        v.put("Branch",txt_branch);
        v.put("class",txt_class);
        v.put("reqdoc",txt_reqdoc);
        v.put("docdesc",txt_docdesc);



        reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Teacher_required_docs.this, "Request send to the student.", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(Teacher_required_docs.this,Adminhome.class);
                startActivity(intent);
            }
        });


    }
}