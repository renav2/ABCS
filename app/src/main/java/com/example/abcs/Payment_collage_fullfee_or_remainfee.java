package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Payment_collage_fullfee_or_remainfee extends AppCompatActivity {

    Button jumpfullpay,jumpremainpay;
String passtorempay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_collage_fullfee_or_remainfee);



        passtorempay=getIntent().getStringExtra("rempasstorempay");



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Payment_collage_fullfee_or_remainfee.this,Payment_college_pay_page.class);
                startActivity(intent);



            }
        }, 2000);



//        jumpfullpay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Payment_collage_fullfee_or_remainfee.this,Payment_college_pay_page.class);
//                startActivity(intent);
//            }
//        });
//
//
//        jumpremainpay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Payment_collage_fullfee_or_remainfee.this,Payment_remaining_fees_paypage.class);
//                String secondpass=passtorempay;
//                intent.putExtra("rempasstorempay2",secondpass);
//
//                startActivity(intent);
//            }
//        });




    }
}