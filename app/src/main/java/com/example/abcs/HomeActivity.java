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
private Button  paymentpage, profile
        ;
TextView useremailid;

TextView r;

    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        paymentpage=findViewById(R.id.btn_payment);
        profile=findViewById(R.id.profile);
        useremailid=findViewById(R.id.home_current_user_emailid);
        r=findViewById(R.id.tp);
        //reciver id
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
r.setText(user1.getUid());


        String user=getIntent().getStringExtra("home_email");
        useremailid.setText(user);

        String pass=useremailid.getText().toString();

       // fetchdata();



        paymentpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,profile_test.class);
                intent.putExtra("pro_email",pass);

                startActivity(intent);
            }
        });

    }

    private void fetchdata() {
        String user=getIntent().getStringExtra("amo");

    }
}