package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Payment_home_page extends AppCompatActivity {
private Button  clgpayjump;
private  Button hostel_pay;
private Button exam_pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
clgpayjump=findViewById(R.id.btn_clg_jump);
hostel_pay=findViewById(R.id.btn_gohostel);
exam_pay=findViewById(R.id.btn_goexamfee);



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