package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_tool_home extends AppCompatActivity {

    Button teacher_add,teacher_delete,teacher_remove,acc_log,issuedoc,acc_del,dlt_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tool_home);
issuedoc=findViewById(R.id.button41);
acc_del=findViewById(R.id.button26);
        teacher_add=findViewById(R.id.button38);

        dlt_notice=findViewById(R.id.button51);

        teacher_delete=findViewById(R.id.button42);

        acc_log=findViewById(R.id.login);



        dlt_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Admin_tool_home.this,Admin_tool_noticedelete.class);
                startActivity(intent);
            }
        });



        acc_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Admin_tool_home.this,admin_delete_account.class);
                startActivity(intent);
            }
        });

        acc_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Admin_tool_home.this,Admin_account_reg.class);
                startActivity(intent);
            }
        });

        teacher_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Admin_tool_home.this,Admin_teachers_reg.class);
                startActivity(intent);
            }
        });


        issuedoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Admin_tool_home.this,Admin_document_issued.class);
                startActivity(intent);
            }
        });
        teacher_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Admin_tool_home.this,Admin_delete_teacher.class);
                startActivity(intent);
            }
        });


    }
}