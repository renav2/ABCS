package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Collage_payrecod_deptwise extends AppCompatActivity {
    Button comp, it,entc,cvil,mech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_payrecod_deptwise);


        comp=findViewById(R.id.button8);
        it=findViewById(R.id.button3);
        entc=findViewById(R.id.button16);
        cvil=findViewById(R.id.button17);
        mech=findViewById(R.id.button6);

        comp .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_Collage_payrecod_deptwise.this,Admin_Collage_payrecod_classwise.class);
                intent.putExtra("deptcomp","Comp");
                startActivity(intent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_Collage_payrecod_deptwise.this,Admin_Collage_payrecod_classwise.class);
                intent.putExtra("deptit","IT");
                startActivity(intent);
            }
        });

        entc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_Collage_payrecod_deptwise.this,Admin_Collage_payrecod_classwise.class);
                intent.putExtra("deptentc","ENTC");
                startActivity(intent);
            }
        });


        cvil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_Collage_payrecod_deptwise.this,Admin_Collage_payrecod_classwise.class);
                intent.putExtra("deptcvil","Civil");
                startActivity(intent);
            }
        });


        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_Collage_payrecod_deptwise.this,Admin_Collage_payrecod_classwise.class);
                intent.putExtra("deptmech","Mech");
                startActivity(intent);
            }
        });

    }
}

