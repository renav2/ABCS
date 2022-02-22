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

public class Admin_teacher_profile extends AppCompatActivity {

    //add qr code to profile

    TextView e1,e2,e3,e4,e5,e6,h;
    Button eb1,echangeProfile;
    ImageView epimage,eqr;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    FirebaseUser user;
    String a,s;
    String userID;
    String teuid;
    StorageReference storageReference;

    private String LOG_TAG = "GenerateQRCode";
    String all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_teacher_profile);
        h=findViewById(R.id.label);
        e1=findViewById(R.id.o_email);
        e2=findViewById(R.id.o_name);
        e3=findViewById(R.id.o_mno);
        e4=findViewById(R.id.o_desg);
        //t5=findViewById(R.id.pyear);
        e5=findViewById(R.id.o_br);
        e6=findViewById(R.id.o_uid);
        eb1=findViewById(R.id.logot);

        eqr=findViewById(R.id.qrcode);

        echangeProfile=findViewById(R.id.teimage);
        epimage=findViewById(R.id.teprofile);
        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();
        a=e6.getText().toString();

        s=getIntent().getStringExtra("TeacherID");


//        fstore .collection("tdemo").whereNotEqualTo("_1Student_remain_fees","0").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot d:list)
//                        {
//                            a_search_data obj=d.toObject(a_search_data.class);
//                            datalist.add(obj);
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                });






        StorageReference profileRef= storageReference.child("Teachers/"+s+"/"+"/Profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                Picasso.get().load(uri).into(epimage);
            }
        });



        DocumentReference documentReference=fstore.collection("tdemo").document(s);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {


                e1.setText(value.getString("Email"));
                e2.setText(value.getString("Name"));
                e3.setText(value.getString("Mobile_No"));
                e4.setText(value.getString("Designation"));
                //t5.setText(value.getString("Rollno"));
                e5.setText(value.getString("Department"));
                e6.setText(value.getString("Empolyee_No"));

                String a=e1.getText().toString();
                String b=e2.getText().toString();
                String c=e3.getText().toString();
                String d=e4.getText().toString();
                String e=e5.getText().toString();
                String f=e6.getText().toString();
                String g="Email\t\t-\t"+a+"\nName\t-\t"+b+"\nContact.No.\t-\t"+c+"\nDesignation\t-\t"
                        +d+"\nBranch\t-\t"+e+"\nID\t-\t"+f+"\t";

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
                    eqr.setImageBitmap(bitmap);

                } catch (WriterException w) {
                    w.printStackTrace();
                }


            }
        });





        echangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open gallery
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                Toast.makeText(Admin_teacher_profile.this, "Wait for 1 minute to set profile picture", Toast.LENGTH_SHORT).show();
                startActivityForResult(openGalleryIntent,100);
            }
        });


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            if (requestCode== Activity.RESULT_OK || epimage!= null){
                Uri imageUri = data.getData();
                epimage.setImageURI(imageUri);

                uploadImageFirebase(imageUri);
            }
        }
    }
    private void uploadImageFirebase(Uri imageUri) {
        //upload image to firebase storage
        StorageReference fileref = storageReference.child("Teachers/"+s+"/"+"/Profile.jpg");
        fileref.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //Picasso.get().load(uri).into(pimage);
                        Toast.makeText(Admin_teacher_profile.this, "profile uplode", Toast.LENGTH_SHORT).show();
                    }
                });
                //Toast.makeText(Home.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Admin_teacher_profile.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}
