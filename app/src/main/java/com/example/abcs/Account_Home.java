package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Account_Home extends AppCompatActivity {

    Button profile,payment,document,del,up,FEE;
    TextView mail;
    ImageView img;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_home);

        mail=findViewById(R.id.textView154);

        FEE=findViewById(R.id.fee);
        del=findViewById(R.id.donot);
        up=findViewById(R.id.upnot);
        profile=findViewById(R.id.pro);
        payment=findViewById(R.id.pay);
        document=findViewById(R.id.doc);

        img=findViewById(R.id.acimage);

        mail.setText(getIntent().getStringExtra("Teacher_email"));


        //profile pic
        storageReference= FirebaseStorage.getInstance().getReference();
        //currunt user id store in r  & for sring purpose
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
        StorageReference profileRef= storageReference.child("Account/"+mail.getText().toString()+"/"+"/Profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(img);
            }
        });




        FEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,College_pay.class);
                intent.putExtra("Account",mail.getText().toString());
                startActivity(intent);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,AdminNotificationHome.class);
                intent.putExtra("Account",mail.getText().toString());
                startActivity(intent);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,Admin_tool_noticedelete.class);
                intent.putExtra("Account",mail.getText().toString());
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,Admin_profile.class);
                intent.putExtra("Account",mail.getText().toString());
                startActivity(intent);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,Admin_paymentsection.class);
                startActivity(intent);
            }
        });

        document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account_Home.this,Admin_document_issued.class);
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
        Toast.makeText(Account_Home.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}