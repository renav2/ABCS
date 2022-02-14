package com.example.abcs;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.List;

//import com.squareup.picass.Picasso;

public class HomeActivity extends AppCompatActivity {
private Button  paymentpage, profile, permission, uplod,logout,collagenotoi,studentdoc,vereifyemail;
    TextView logO,verifymsg,support, notificationtext,welcomename,unicid;
//TextView useremailid;
ImageView profilepic;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
TextView r;
    StorageReference storageReference;
    String user;

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;


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
        logO=findViewById(R.id.logO);
        notificationtext=findViewById(R.id.textView2);
        welcomename=findViewById(R.id.textView115);
        unicid=findViewById(R.id.textView116);
        logO=findViewById(R.id.log1);
        studentdoc=findViewById(R.id.button4);
        collagenotoi=findViewById(R.id.button5);
        vereifyemail=findViewById(R.id.resend_code);
        verifymsg=findViewById(R.id.VerifyMsg);
        String userID = fAuth.getCurrentUser().getUid();
        FirebaseUser firebaseUser = fAuth.getCurrentUser();
        welcomename.setText("Welcome "+fAuth.getCurrentUser().getDisplayName());
        notificationtext.setVisibility(View.INVISIBLE);

//fetchunic id
        DocumentReference documentReference=fstore.collection("demo").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {


                unicid.setText(value.getString("assignno"));

            }
        });



        // notifications fetch





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                DocumentReference documentReference=fstore.collection("Teacher_required_docs").document(unicid.getText().toString());
                documentReference.addSnapshotListener(HomeActivity.this, new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                        String s,s1;

                        notificationtext.setText(value.getString("reqdoc"));

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                NotificationChannel channel = new NotificationChannel("myCh", "My channel", NotificationManager.IMPORTANCE_DEFAULT);
                                NotificationManager manager = getSystemService(NotificationManager.class);
                                manager.createNotificationChannel(channel);
                            }
                            NotificationCompat.Builder builder = new NotificationCompat.Builder(HomeActivity.this, "myCh")
                                    .setSmallIcon(android.R.drawable.stat_notify_sync)

                                    .setContentTitle("documnet uplod")
                                    .setContentText("document name :-" + notificationtext.getText().toString());
                            notification = builder.build();
                            notificationManagerCompat = NotificationManagerCompat.from(HomeActivity.this);

                                        //String  bb=notificationtext.getText().toString();

            if(notificationtext.getText().toString().equals("")){
                Toast.makeText(HomeActivity.this, "no notifications", Toast.LENGTH_SHORT).show();
            }else{
                notificationManagerCompat.notify(0, notification);
            }
                                    //   notificationManagerCompat.notify(0, notification);

                                }
                            });
                        }
                    }, 1000);




        //Start Email verification link sent
        if (!firebaseUser.isEmailVerified()){
                vereifyemail.setVisibility(View.VISIBLE);
                verifymsg.setVisibility(View.VISIBLE);

                vereifyemail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseUser firebaseUser = fAuth.getCurrentUser();
                        firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(HomeActivity.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                             }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(HomeActivity.this, "Email not Sent."+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
        }
        //End Email verification link sent

studentdoc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(HomeActivity.this, uplod_documents.class);
        startActivity(intent);
    }
});


collagenotoi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(HomeActivity.this, downlodpdf.class);
        startActivity(intent);
    }
});


//profile pic
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
                startActivity(new Intent(getApplicationContext(),ViewNotifications.class));
                finish();
            }
        });
//uplod.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        startActivity(new Intent(getApplicationContext(),test_uplodpdf.class));
//        finish();
//    }
//});
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

           case R.id.log1:
             //  signout();
               return true;

           default:
               return super.onOptionsItemSelected(item);
       }
    }

    private void signout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        Toast.makeText(HomeActivity.this, "Logout Succesfully", Toast.LENGTH_SHORT).show();
        finish();
    }


    private void fetchdata() {
        String user=getIntent().getStringExtra("amo");
    }
}