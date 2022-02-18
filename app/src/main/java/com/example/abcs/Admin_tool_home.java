package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_tool_home extends AppCompatActivity {

    Button teacher_add,teacher_delete,teacher_remove,teacher_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tool_home);

        teacher_add=findViewById(R.id.button38);
        teacher_delete=findViewById(R.id.button42);
        teacher_remove=findViewById(R.id.button41);
        teacher_log=findViewById(R.id.login);

        teacher_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Admin_tool_home.this,Admin_teachers_reg.class);
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