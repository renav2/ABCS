package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
private Button  clgpayjump;
private  Button hostel_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
clgpayjump=findViewById(R.id.btn_clg_jump);
hostel_pay=findViewById(R.id.btn_gohostel);




clgpayjump.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(PaymentActivity.this,paymentclg.class);
        startActivity(intent);
    }
});


hostel_pay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(PaymentActivity.this,Payment_hostel.class);
        startActivity(intent);
    }
});




    }
}