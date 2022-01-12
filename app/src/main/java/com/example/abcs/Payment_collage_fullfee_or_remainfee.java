package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Payment_collage_fullfee_or_remainfee extends AppCompatActivity {

    Button jumpfullpay,jumpremainpay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_collage_fullfee_or_remainfee);
        jumpfullpay=findViewById(R.id.btn_jump_fullpaymet);
        jumpremainpay=findViewById(R.id.btn_remain_fees);

        jumpfullpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Payment_collage_fullfee_or_remainfee.this,Payment_college_pay_page.class);
                startActivity(intent);
            }
        });


        jumpremainpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Payment_collage_fullfee_or_remainfee.this,Payment_remaining_fees_paypage.class);
                startActivity(intent);
            }
        });




    }
}