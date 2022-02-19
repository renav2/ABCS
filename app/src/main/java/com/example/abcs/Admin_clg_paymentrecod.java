package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_clg_paymentrecod extends AppCompatActivity {
    Button firstinsta,zeropaytudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_clg_paymentrecod);
        firstinsta=findViewById(R.id.button7);
        zeropaytudent=findViewById(R.id.button9);



            zeropaytudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(Admin_clg_paymentrecod.this, Admin_Zero_pay_student.class);
                    startActivity(intent);
                }
            });


        firstinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Admin_clg_paymentrecod.this, Admin_Collage_payrecod_deptwise.class);
                startActivity(intent);
            }
        });




    }
}