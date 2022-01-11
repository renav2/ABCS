package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Payment_home_page extends AppCompatActivity {
private Button  clgpayjump;
private  Button hostel_pay;
private Button exam_pay;

TextView studentf;
    FirebaseFirestore fstore;
    FirebaseAuth auth;
    String pro_userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
clgpayjump=findViewById(R.id.btn_clg_jump);
hostel_pay=findViewById(R.id.btn_gohostel);
exam_pay=findViewById(R.id.btn_goexamfee);
studentf=findViewById(R.id.tv_yourfees);
        auth=FirebaseAuth.getInstance();


        // pro_userid = getIntent().getStringExtra("user_id_home");
        pro_userid=auth.getCurrentUser().getUid();
        fstore=FirebaseFirestore.getInstance();
        DocumentReference reference = fstore.collection("collage_fees_paymentdata").document(pro_userid);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //basic profile things
                String pay_yourfees= documentSnapshot.getString("Student_total_fees");




                studentf.setText(pay_yourfees);


            }
        });








clgpayjump.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Payment_home_page.this, Payment_college_pay_page.class);
        startActivity(intent);
    }
});


hostel_pay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Payment_home_page.this,Payment_hostel.class);
        startActivity(intent);
    }
});

exam_pay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(Payment_home_page.this,payment_exam_fees.class);
        startActivity(intent);
    }
});




    }
}