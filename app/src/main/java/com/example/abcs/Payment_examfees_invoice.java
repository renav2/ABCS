package com.example.abcs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Payment_examfees_invoice extends AppCompatActivity {

    TextView na,roll,clas,bran,prn,forno,amo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_examfees_invoice);

        na=findViewById(R.id.tv_examname201);
        clas=findViewById(R.id.tv_exam_class202);
        bran=findViewById(R.id.tv_exam_branch203);

        roll=findViewById(R.id.tv_exam_rollno204);
prn=findViewById(R.id.tv_examprn206);
forno=findViewById(R.id.tv_examform_207);
amo

        //int
        String ex1_amountpass = getIntent().getStringExtra("examamountint");

        String ex1_string_amountpass = getIntent().getStringExtra("examamount");
        String ex1_prn = getIntent().getStringExtra("examprn");
        String ex1_formno = getIntent().getStringExtra("exform");








    }
}