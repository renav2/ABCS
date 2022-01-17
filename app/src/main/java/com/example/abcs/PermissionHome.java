package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PermissionHome extends AppCompatActivity {
    Button c_button, a_button; //create and approve button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_home);

    c_button= (Button) findViewById(R.id.create_apli);
        c_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openNextActivityCreateAppli();
        }


    });
    a_button = (Button) findViewById(R.id.approve_apli);
        a_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openNextActivityApproveAppli();
        }


    });
}
    private void openNextActivityCreateAppli() {

        Intent intent1 = new Intent(this, CreateApplication.class);
        startActivity(intent1);
    }
    private void openNextActivityApproveAppli() {
        Intent intent2 = new Intent(this, PreviousApplication.class);
        startActivity(intent2);
    }
}