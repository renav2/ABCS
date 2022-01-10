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
                //basic profile things
                String pro_name= documentSnapshot.getString("Name");
                String pro_email=documentSnapshot.getString("Email");
                String pro_rollno=documentSnapshot.getString("Rollno");
                String pro_phoneno=documentSnapshot.getString("mobile no");
                String pro_dept=documentSnapshot.getString("Branch");

                //for invoice

                String pro_collagename=documentSnapshot.getString("College_name");
                String pro_admisontype=documentSnapshot.getString("Admission_type");
                String pro_categary=documentSnapshot.getString("Category");
                //branch--->line no 46 profile activity
                String pro_acadamicyear=documentSnapshot.getString("Academic_year");


                //cu->current user

//                Intent intent=new Intent(profile_test.this,paymentclg.class);
//                intent.putExtra("cu_dept",pro_dept);
//                intent.putExtra("cu_collagename",pro_collagename);
//                intent.putExtra("cu_admisiontype",pro_admisontype);
//                intent.putExtra("cu_categary",pro_categary);

             //  startActivity(intent);




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