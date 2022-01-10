package com.example.abcs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile_test extends AppCompatActivity {
    LottieAnimationView loa;
    TextView useremail,pro_name;
   FirebaseUser users;
   DatabaseReference reference;
   FirebaseAuth auth;
    String receiver_user_email;
   String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_test);

        useremail = findViewById(R.id.user_email);
        pro_name =findViewById(R.id.profile_name);

        receiver_user_email=getIntent().getExtras().get("pro_email").toString();


        String user=getIntent().getStringExtra("pro_email");
        useremail.setText(user);

   //get current user
    users= FirebaseAuth.getInstance().getCurrentUser();

    auth=FirebaseAuth.getInstance();
    reference= FirebaseDatabase.getInstance().getReference("personal data");
   // userID=users.getUid();


        fetchdata();
    }

    private void fetchdata() {
        reference.child("26o1Z51AF4yWAgaQIQjL").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userName=dataSnapshot.child("Name").getValue().toString();
//                String userStatus=dataSnapshot.child("status").getValue().toString();
//                String userImage=dataSnapshot.child("image").getValue().toString();

                pro_name.setText(userName);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }




}