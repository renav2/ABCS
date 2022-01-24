package com.example.abcs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class test_user_permision_status extends AppCompatActivity {
TextView n,e,l,s,c,chnage,status;
    LottieAnimationView grant,not_granted;

    String curremail;
    FirebaseFirestore fstore;
FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_user_permision_status);
//id's
        grant=findViewById(R.id.ani_grant);
        not_granted=findViewById(R.id.ani_fail);


        n=findViewById(R.id.st_name);
        e=findViewById(R.id.st_email);
        l=findViewById(R.id.st_lvl);
        s=findViewById(R.id.st_section);
        c=findViewById(R.id.st_comments);
        //fecthstatus
        chnage=findViewById(R.id.st_permisonstatus);
        //orignal
        status=findViewById(R.id.tv_statuschange);
        //firebase
        fstore=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        curremail=auth.getCurrentUser().getEmail();


        grant.setVisibility(View.INVISIBLE);
        not_granted.setVisibility(View.INVISIBLE);

        DocumentReference reference = fstore.collection("final_permision_status").document(curremail);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //basic profile things
                String pro_name= documentSnapshot.getString("Name");
                String pro_email=documentSnapshot.getString("Email");
                String pro_levl=documentSnapshot.getString("Level");
                String pro_comm=documentSnapshot.getString("Comments");
                String pro_sec=documentSnapshot.getString("Section");
                String pro_stat=documentSnapshot.getString("status");
                n.setText(pro_name);
                e.setText(pro_email);
                l.setText(pro_levl);
                c.setText(pro_comm);
                s.setText(pro_sec);
                chnage.setText(pro_stat);
                chnage.setVisibility(View.INVISIBLE);
                animationon(grant,not_granted,chnage);
            }
        });











    }

    private void animationon(LottieAnimationView grant, LottieAnimationView not_granted, TextView chnage) {


        if(chnage.getText().toString().equals("NOT granted")){
            not_granted.setVisibility(View.VISIBLE);
           status.setText("NOT Granted");

        }else if(chnage.getText().toString().equals("granted")){
            // not_granted.setVisibility(View.INVISIBLE);
            grant.setVisibility(View.VISIBLE);
            status.setText("Granted");

        }


    }


}