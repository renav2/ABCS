package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Adminhome extends AppCompatActivity {
Button apermission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        apermission=(Button) findViewById(R.id.adminper);
        apermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPermissiionActivity();
            }

            private void openPermissiionActivity() {
                Intent intent= new Intent(Adminhome.this , AdminPermissionHome.class);
                startActivity(intent);
            }
        });
    }
}