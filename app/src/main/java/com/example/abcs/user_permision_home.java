package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class user_permision_home extends AppCompatActivity {
private Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_permision_home);
        b1=findViewById(R.id.cbt);
        b2=findViewById(R.id.pbt);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(user_permision_home.this,CreateApplication.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(user_permision_home.this,PreviousApplications.class);
                startActivity(intent);
            }
        });

    }
}