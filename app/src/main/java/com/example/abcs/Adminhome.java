package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Adminhome extends AppCompatActivity {
Button apermission, btnpay,admin_payhome,notification,tests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        btnpay=findViewById(R.id.btn_viewallpay);
tests=findViewById(R.id.button18);

        admin_payhome=findViewById(R.id.button12);
        apermission =  findViewById(R.id.adminper);
        notification=findViewById(R.id.button13);

        tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,Admin_dept_wise_sort.class);
                startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,AdminNotificationHome.class);
                startActivity(intent);
            }
        });

        admin_payhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,Admin_paymentsection.class);
                startActivity(intent);
            }
        });

        apermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,AdminPermissionHome.class);
                startActivity(intent);
            }
        });




        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(Adminhome.this, Admin_all_user_permision_section.class);
               startActivity(intent);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     MenuInflater inflater=getMenuInflater();
     inflater.inflate(R.menu.main_menu,menu);
     return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {



            case R.id.logO:
                signout();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void signout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        Toast.makeText(Adminhome.this, "Logout Succesfully", Toast.LENGTH_SHORT).show();

        finish();
    }

}