package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class uplod_documents extends AppCompatActivity {
Button u10,d10,u12,d12,updip,downdip,upfe,downfe,upse,downse,upte,downte,upbe,ddownbe,upcustom,downcoston;
TextView tu10,td10,tu12,td12,tupdip,tdowndip,tupfe,tdownfe,tupse,tdownse,tupte,tdownte,tupbe,tddownbe,tupcustom,tdowncoston;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplod_documents);
        tu10 =findViewById(R.id.tenup);
        td10 =findViewById(R.id.tendown);
        tu12=findViewById(R.id.up12);
        td12 =findViewById(R.id.down12);
        tupdip =findViewById(R.id.updip);
        tdowndip=findViewById(R.id.downdip);
        tupfe=findViewById(R.id.upfe);
        tdownfe=findViewById(R.id.downdfe);
        tupse=findViewById(R.id.upse);
        tdownse=findViewById(R.id.downse);
        tupte =findViewById(R.id.upte);
        tdownte=findViewById(R.id.downte);
        tupbe  =findViewById(R.id.upbe);
        tddownbe=findViewById(R.id.downbe);
        tupcustom=findViewById(R.id.upcostom);
        tdowncoston=findViewById(R.id.downcustom);

        //buttons
        u10=findViewById(R.id.uplod10);
        d10=findViewById(R.id.downlod10);
        u12=findViewById(R.id.uplod12);
        d12=findViewById(R.id.downlod12);
        updip  =findViewById(R.id.uploddip);
        downdip=findViewById(R.id.downloddip);
        upfe =findViewById(R.id.uplodfe1);
        downfe =findViewById(R.id.downlodfe);
        upse =findViewById(R.id.uplodse);
        downse =findViewById(R.id.downlodse);
        upte=findViewById(R.id.uplodte);
        downte =findViewById(R.id.downlodte);
        upbe=findViewById(R.id.uplodbe);
        ddownbe =findViewById(R.id.downlodbe);
        upcustom=findViewById(R.id.button20);
        downcoston=findViewById(R.id.downlodecustom);

        //textview






    }
}