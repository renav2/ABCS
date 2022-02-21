package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Account_Home extends AppCompatActivity {

    Button profile,payment,document;
    TextView mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_home);

        mail=findViewById(R.id.textView154);

        profile=findViewById(R.id.pro);
        payment=findViewById(R.id.pay);
        document=findViewById(R.id.doc);

        mail.setText(getIntent().getStringExtra("Teacher_email"));

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,Admin_profile.class);
                intent.putExtra("Account",mail.getText().toString());
                startActivity(intent);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,Admin_paymentsection.class);
                startActivity(intent);
            }
        });

        document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,Admin_document_issued.class);
                startActivity(intent);
            }
        });

    }
}