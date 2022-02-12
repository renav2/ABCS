package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPermissionHome extends AppCompatActivity {
    private Button ap1, ap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_permission_home);
        ap1= (Button)findViewById(R.id.aproveact);
        ap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextApp1();
            }
        });
        ap2= (Button)findViewById(R.id.viewact);
        ap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextApp2();
            }
        });
    }

    private void openNextApp1() {
        Intent intent = new Intent(this, AdminApproveApplications.class);
        startActivity(intent);
    }

    private void openNextApp2() {
        Intent intent = new Intent(this, AdminViewApplication.class);
        startActivity(intent);
    }
    
    }
