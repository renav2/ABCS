package com.example.abcs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TeacherHome extends AppCompatActivity {

    Button eprofile,techerspecific_per;
    TextView eu;

FirebaseFirestore fstore;
FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);
fstore=FirebaseFirestore.getInstance();

        eu=findViewById(R.id.uite);
        eprofile=findViewById(R.id.tprofile);
        techerspecific_per=findViewById(R.id.button44);


        eu.setText(getIntent().getStringExtra("Teacher"));



        DocumentReference documentReference=fstore.collection("tdemo").document(eu.getText().toString());
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {


                String txt_name=value.getString("Name");
                String txt_email= value.getString("Email");
                String txt_mobno=value.getString("Mobile_No");
                String txt_desig=value.getString("Designation");
                //t5.setText(value.getString("Rollno"));
                String txt_dept =value.getString("Department");
                String txt_emp=value.getString("Empolyee_No");



            }
        });



        eprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherHome.this,Admin_teacher_profile.class);
                intent1.putExtra("TeacherID",eu.getText().toString());
                startActivity(intent1);
            }
        });

       // eprofile,techerspecific_per



    }
}