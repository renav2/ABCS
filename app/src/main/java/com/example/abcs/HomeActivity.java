package com.example.abcs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {
private Button  paymentpage, profile, permission, uplod ;
//TextView useremailid;
ImageView profilepic;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
TextView r;
    StorageReference storageReference;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        paymentpage=findViewById(R.id.btn_payment);
        profile=findViewById(R.id.profile);
        permission=findViewById(R.id.peract);
        profilepic=findViewById(R.id.imageView);
        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();
        //currunt user id store in r  & for sring purpose
        r=findViewById(R.id.tp);
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
        r.setText(user1.getUid());
        String User_ID=r.getText().toString();
        uplod=findViewById(R.id.uplod);


        StorageReference profileRef= storageReference.child("Users/"+fAuth.getCurrentUser().getUid()+"/Profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                Picasso.get().load(uri).into(profilepic);
            }
        });




uplod.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),test_uplodpdf.class));
        finish();
    }
});


        paymentpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this, Payment_home_page.class);
                startActivity(intent);
                finish();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,profile_test.class);
              //  intent.putExtra("pro_email",pass);
                intent.putExtra("user_id_home",User_ID);
                startActivity(intent);
                finish();
            }
        });

        permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, user_permision_home.class);
                startActivity(intent);

                finish();
            }
        });

    }

    private void fetchdata() {
        String user=getIntent().getStringExtra("amo");

    }
}