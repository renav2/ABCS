package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_support_solver extends AppCompatActivity {
Button paymentissuesolve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_support_solver);


        paymentissuesolve=findViewById(R.id.button36);



        paymentissuesolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_support_solver.this,Admin_Support_paymentsection.class);
                startActivity(intent);
            }
        });




    }
}