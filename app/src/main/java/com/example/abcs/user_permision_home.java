package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class user_permision_home extends AppCompatActivity {
    FirebaseAuth auth;
private Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_permision_home);
        b1=findViewById(R.id.cbt);
        b2=findViewById(R.id.pbt);
        auth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(user_permision_home.this,test_user_permision_ask.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(user_permision_home.this,userwiser_permision_fetch.class);
                intent.putExtra("currentuseremail",auth.getCurrentUser().getEmail());
                startActivity(intent);
            }
        });

    }
}