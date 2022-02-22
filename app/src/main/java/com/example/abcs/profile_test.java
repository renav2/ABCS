package com.example.abcs;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.squareup.picasso.Picasso;

public class profile_test extends AppCompatActivity {

    //add qr code to profile

    TextView t1,t2,t3,t4,t5,t6,h;
    Button b1,changeProfile;
    ImageView pimage,qr;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    FirebaseUser user;
    String userID;
    StorageReference storageReference;
    private String LOG_TAG = "GenerateQRCode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_test);
        h=findViewById(R.id.label);
        t1=findViewById(R.id.pname);
        t2=findViewById(R.id.pemail);
        t3=findViewById(R.id.pcollege);
        t4=findViewById(R.id.pbranch);
        //t5=findViewById(R.id.pyear);
        t5=findViewById(R.id.pclass);
        t6=findViewById(R.id.pid);
        b1=findViewById(R.id.back);

        qr=findViewById(R.id.qrcode);

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
                t3.setText(value.getString("mobile_no"));
                t4.setText(value.getString("Branch"));
   //             t5.setText(value.getString("Rollno"));
                t5.setText(value.getString("_Class"));
                t6.setText(s1);

                String a=t1.getText().toString();
                String b=t2.getText().toString();
                String c=t3.getText().toString();
                String d=t4.getText().toString();
                String e=t5.getText().toString();
                String f=t6.getText().toString();
                String g="Email\t\t-\t"+a+"\nName\t-\t"+b+"\nContact.No.\t-\t"+c+"\nBranch\t-\t"
                        +d+"\nYear\t-\t"+e+"\nID\t-\t"+f+"\t";

                Log.v(LOG_TAG,   g);

                //Find screen size
                WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                Point point = new Point();
                display.getSize(point);
                int width = point.x;
                int height = point.y;
                int smallerDimension = width < height ? width : height;
                smallerDimension = smallerDimension * 1/4;

                //Encode with a QR Code image
                QRCodeEncoder qrCodeEncoder = new QRCodeEncoder( g,
                        null,
                        Contents.Type.TEXT,
                        BarcodeFormat.QR_CODE.toString(),
                        smallerDimension);
                try {
                    Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
                    //ImageView myImage = (ImageView) findViewById(R.id.qrcode);
                    qr.setImageBitmap(bitmap);

                } catch (WriterException w) {
                    w.printStackTrace();
                }




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
        //upload image to firebase storage
        StorageReference fileref = storageReference.child("Users/"+fAuth.getCurrentUser().getUid()+"/Profile.jpg");
        fileref.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //Picasso.get().load(uri).into(pimage);
                        Toast.makeText(profile_test.this, "profile uplode", Toast.LENGTH_SHORT).show();
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




