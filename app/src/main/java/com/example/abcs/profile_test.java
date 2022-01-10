package com.example.abcs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class profile_test extends AppCompatActivity {
    TextView name, email,roll_no,phone_no,dept;
    String pro_userid;
    FirebaseFirestore fstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_test);

        //user id
        pro_userid = getIntent().getStringExtra("user_id_home");

        //declaration
        fstore = FirebaseFirestore.getInstance();
        name=findViewById(R.id.tv_pro_rollno);
        email=findViewById(R.id.tv_email);
        roll_no=findViewById(R.id.tv_pro_rollno1);
        phone_no=findViewById(R.id.tv_pro_phoneno);
        dept=findViewById(R.id.tv_pro_Department);


        //fetch data
        DocumentReference reference = fstore.collection("demo").document(pro_userid);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
        String pro_name= documentSnapshot.getString("Name");
        String pro_email=documentSnapshot.getString("Email");
        String pro_rollno=documentSnapshot.getString("Rollno");
        String pro_phoneno=documentSnapshot.getString("mobile no");
        String pro_dept=documentSnapshot.getString("Branch");

        //setdata

        name.setText(pro_name);
        email.setText(pro_email);
        roll_no.setText(pro_rollno);
        phone_no.setText(pro_phoneno);
        dept.setText(pro_dept);

            }
        });


    }
}