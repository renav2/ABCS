package com.example.abcs;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class profile_test extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,h;
    Button b1,changeProfile;
    ImageView pimage;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    FirebaseUser user;
    String userID;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_test);

        h=findViewById(R.id.label);
        t1=findViewById(R.id.pname);
        t2=findViewById(R.id.pemail);
        t3=findViewById(R.id.pcollege);
        t4=findViewById(R.id.pbranch);
        t5=findViewById(R.id.pyear);
        t6=findViewById(R.id.pid);

        b1=findViewById(R.id.back);
        changeProfile=findViewById(R.id.cimage);
        pimage=findViewById(R.id.profile);

        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        StorageReference profileRef= storageReference.child("Users/"+fAuth.getCurrentUser().getUid()+"/Profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                Picasso.get().load(uri).into(pimage);
            }
        });

        userID=fAuth.getCurrentUser().getUid();
        user=fAuth.getCurrentUser();
        DocumentReference documentReference=fstore.collection("demo").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                String s,s1;
                s=userID.toUpperCase();
                s1=userID.substring(1,7);

                t1.setText(value.getString("Name"));
                t2.setText(value.getString("Email"));
                t3.setText(value.getString("mobile no"));
                t4.setText(value.getString("Branch"));
                t5.setText(value.getString("Rollno"));
                t6.setText(s1);

            }
        });

        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open gallery
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            if (requestCode== Activity.RESULT_OK || pimage!= null){
                Uri imageUri = data.getData();
                pimage.setImageURI(imageUri);

                uploadImageFirebase(imageUri);
            }
        }
    }

    private void uploadImageFirebase(Uri imageUri) {
        //upload image to firebase firestore
        /*userID=fAuth.getCurrentUser().getUid();
        user=fAuth.getCurrentUser();
        userID = fAuth.getCurrentUser().getUid();
        DocumentReference documentReference =fstore.collection("Users").document(userID);
        Map<String,Object> user= new HashMap<>();
        user.*/


        //upload image to firebase storage
        StorageReference fileref = storageReference.child("Users/"+fAuth.getCurrentUser().getUid()+"/Profile.jpg");
        fileref.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(pimage);
                    }
                });
                //Toast.makeText(Home.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(profile_test.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}




// Profile code renav

/*import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class profile_test extends AppCompatActivity {
    TextView name, email,roll_no,phone_no,dept;


    String pro_userid;
    FirebaseFirestore fstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_test);

        //user id
        pro_userid = getIntent().getStringExtra("user_id_home");

        //declaration
        fstore = FirebaseFirestore.getInstance();
        name=findViewById(R.id.tv_pro_rollno);
        email=findViewById(R.id.tv_email);
        roll_no=findViewById(R.id.tv_pro_rollno1);
        phone_no=findViewById(R.id.tv_pro_phoneno);
        dept=findViewById(R.id.tv_pro_Department);


        //fetch data
        DocumentReference reference = fstore.collection("demo").document(pro_userid);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //basic profile things
                String pro_name= documentSnapshot.getString("Name");
                String pro_email=documentSnapshot.getString("Email");
                String pro_rollno=documentSnapshot.getString("Rollno");
                String pro_phoneno=documentSnapshot.getString("mobile no");
                String pro_dept=documentSnapshot.getString("Branch");

                //for invoice

                String pro_collagename=documentSnapshot.getString("College_name");
                String pro_admisontype=documentSnapshot.getString("Admission_type");
                String pro_categary=documentSnapshot.getString("Category");
                //branch--->line no 46 profile activity
                String pro_acadamicyear=documentSnapshot.getString("Academic_year");


                //cu->current user

//                Intent intent=new Intent(profile_test.this,Payment_college_pay_page.class);
//                intent.putExtra("cu_dept",pro_dept);
//                intent.putExtra("cu_collagename",pro_collagename);
//                intent.putExtra("cu_admisiontype",pro_admisontype);
//                intent.putExtra("cu_categary",pro_categary);

             //  startActivity(intent);




        //setdata

        name.setText(pro_name);
        email.setText(pro_email);
        roll_no.setText(pro_rollno);
        phone_no.setText(pro_phoneno);
        dept.setText(pro_dept);

            }
        });


    }
}*/