package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class Adminhome extends AppCompatActivity {
Button apermission, btnpay,secondinsta,firstinsta,admin_payhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        btnpay=findViewById(R.id.btn_viewallpay);

        admin_payhome=findViewById(R.id.admin_payhome);
        apermission =  findViewById(R.id.adminper);




        admin_payhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,Admin_paymentsection.class);
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



    }
}