package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeacherHome extends AppCompatActivity {

    Button eprofile;
    TextView eu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        eu=findViewById(R.id.uite);
        eprofile=findViewById(R.id.tprofile);
        String s=getIntent().getStringExtra("Teacher");

        eu.setText(s);
        eprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherHome.this,Admin_teacher_profile.class);
                intent1.putExtra("TeacherID",eu.getText().toString());
                startActivity(intent1);
            }
        });
    }
}