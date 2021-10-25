package com.example.abcs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
private Button  clgpayjump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
clgpayjump=findViewById(R.id.btn_clg_jump);

clgpayjump.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Intent intent=new Intent(PaymentActivity.this,collage_fees_paymentActivity.class);
       // startActivity(intent);
    }
});



    }
}