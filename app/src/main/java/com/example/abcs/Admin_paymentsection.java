package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_paymentsection extends AppCompatActivity {
Button clgpayrecord, examrecord,hostelrecord,supportpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_paymentsection);
        clgpayrecord=findViewById(R.id.Admin_clg_record);
        examrecord=findViewById(R.id.admin_examrecord);
        hostelrecord=findViewById(R.id.admin_hostel_record);



clgpayrecord.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Admin_paymentsection.this,Admin_clg_paymentrecod.class);
        startActivity(intent);
    }
});


hostelrecord.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        Intent intent=new Intent(Admin_paymentsection.this,Admin_hostel_payrecord.class);
//        startActivity(intent);
        Intent intent=new Intent(Admin_paymentsection.this,hotel_record_dept_wise.class);
        startActivity(intent);

    }
});

        examrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_paymentsection.this,Admin_exam_payrecord.class);
                startActivity(intent);
            }
        });


    }
}