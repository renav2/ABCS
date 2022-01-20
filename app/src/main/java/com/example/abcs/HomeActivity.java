package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
private Button  paymentpage, profile, permission, uplod;
//TextView useremailid;

TextView r;

    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        paymentpage=findViewById(R.id.btn_payment);
        profile=findViewById(R.id.profile);
        permission=findViewById(R.id.peract);

        //currunt user id store in r  & for sring purpose
        r=findViewById(R.id.tp);
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
        r.setText(user1.getUid());
String User_ID=r.getText().toString();
uplod=findViewById(R.id.uplod);



uplod.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),test_uplodpdf.class));
    }
});


        paymentpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this, Payment_home_page.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,profile_test.class);
              //  intent.putExtra("pro_email",pass);
                intent.putExtra("user_id_home",User_ID);
                startActivity(intent);
            }
        });

        permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, PermissionHome.class);
                startActivity(intent);
            }
        });

    }

    private void fetchdata() {
        String user=getIntent().getStringExtra("amo");

    }
}