package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class Adminhome extends AppCompatActivity {
Button apermission, btnpay,payhom,secondinsta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        btnpay=findViewById(R.id.btn_viewallpay);
        payhom=findViewById(R.id.button7);
secondinsta=findViewById(R.id.button9);
        apermission = (Button) findViewById(R.id.adminper);


secondinsta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(Adminhome.this, Admin_2nd_installment.class);
        startActivity(intent);
    }
});

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(Adminhome.this, Admin_all_user_permision_section.class);
               startActivity(intent);
            }
        });


        payhom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Adminhome.this,Admin_payment_home.class);
                startActivity(intent);
            }
        });
    }
}