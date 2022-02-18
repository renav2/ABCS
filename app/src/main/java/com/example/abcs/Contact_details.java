package com.example.abcs;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.GoogleMap;

public class Contact_details extends AppCompatActivity {
    private Button call_acc,call_stu,send_email;

    GoogleMap gmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        call_acc = (Button) findViewById(R.id.button29);
        call_stu = (Button) findViewById(R.id.button30);
        send_email=findViewById(R.id.button28);

        send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailintent = new Intent(Intent.ACTION_SENDTO);
                mailintent.setData(Uri.parse("mailto: sits@sinhgad.edu"));
                startActivity(mailintent);
            }
        });
        call_acc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent1 = new Intent(Intent.ACTION_DIAL);
                callIntent1.setData(Uri.parse("tel:02172329566"));
                startActivity(callIntent1);
            }
        });
        call_stu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:02172329566"));
                startActivity(callIntent);
            }
        });

    }
}
