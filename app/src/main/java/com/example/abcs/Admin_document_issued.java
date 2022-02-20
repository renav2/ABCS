package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_document_issued extends AppCompatActivity {
Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_document_issued);
        b1=findViewById(R.id.button47);
        b2=findViewById(R.id.button48);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_document_issued.this,Admin_student_issued_doc.class);
                intent.putExtra("docname","Bonafide");

                startActivity(intent);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_document_issued.this,Admin_student_issued_doc.class);
                intent.putExtra("docname2","feestucture");

                startActivity(intent);
            }
        });



    }
}