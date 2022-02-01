package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_payment_home extends AppCompatActivity {
Button allrempay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_payment_home);
allrempay=findViewById(R.id.button13);


allrempay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(Admin_payment_home.this,Admin_allrempay.class);
        startActivity(intent);
    }
});





    }
}