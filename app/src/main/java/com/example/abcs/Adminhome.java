package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Adminhome extends AppCompatActivity {
Button apermission, btnpay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        btnpay=findViewById(R.id.btn_viewallpay);



        apermission = (Button) findViewById(R.id.adminper);
        apermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPermissiionActivity();
            }
        });


        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(Adminhome.this,Admin_payment_alldata.class);

               startActivity(intent);



            }
        });





    }

    private void openPermissiionActivity() {
        Intent intent = new Intent(this, AdminPermissionHome.class);
        startActivity(intent);
    }
}