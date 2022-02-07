package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_clg_paymentrecod extends AppCompatActivity {
    Button apermission, btnpay,secondinsta,firstinsta,admin_payhome,only_feeeremsing_studet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_clg_paymentrecod);
        firstinsta=findViewById(R.id.button7);
        secondinsta=findViewById(R.id.button10);
        only_feeeremsing_studet=findViewById(R.id.button11);


        firstinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Admin_clg_paymentrecod.this, Admin_1st_installment.class);
                startActivity(intent);
            }
        });


only_feeeremsing_studet.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(Admin_clg_paymentrecod.this, Admin_remainpay.class);
        startActivity(intent);
    }
});
        secondinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Admin_clg_paymentrecod.this, Admin_2nd_installment.class);
                startActivity(intent);
            }
        });



    }
}