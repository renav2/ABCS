package com.example.abcs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class payment_exam_fees extends AppCompatActivity {
private Button btn_exampay;
private EditText txt_examamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_exam_fees);

        btn_exampay=findViewById(R.id.btn_examfees);
        txt_examamount=findViewById(R.id.txt_examamount);


    }
}