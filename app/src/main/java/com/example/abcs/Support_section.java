package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Support_section extends AppCompatActivity {

    TextView t1,t2;
    Button sreg,spay,sdoc,scon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_section);

        sreg=findViewById(R.id.button2);
        spay=findViewById(R.id.button24);

        sdoc=findViewById(R.id.button25);
        scon=findViewById(R.id.button27);

        sreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Support_section.this, register2.class);
                startActivity(intent);

            }
        });

        spay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Support_section.this, Support_pay.class);
                startActivity(intent);
                finish();
            }
        });

        sdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Support_section.this, Document_support.class);
                startActivity(intent);
            }
        });


        scon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Support_section.this, Contact_details.class);
                startActivity(intent);
            }
        });

    }
}