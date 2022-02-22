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

public class Admin_profile extends AppCompatActivity {

    //add qr code to profile

    TextView e21,e22,e23,e24,e25,e26,h;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        h=findViewById(R.id.label);
        e21=findViewById(R.id.o_email);
        e22=findViewById(R.id.o_name);
        e23=findViewById(R.id.o_mno);
        e24=findViewById(R.id.o_desg);
        //t5=findViewById(R.id.pyear);
        e25=findViewById(R.id.o_br);
        e26=findViewById(R.id.o_uid);
        eb1=findViewById(R.id.logot);

        eqr=findViewById(R.id.qrcode);

        echangeProfile=findViewById(R.id.teimage);
        epimage=findViewById(R.id.teprofile);
        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();
        a=e26.getText().toString();






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




          s=getIntent().getStringExtra("Account");

        StorageReference profileRefe= storageReference.child("Account/"+s+"/"+"/Profile.jpg");
        profileRefe.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                Picasso.get().load(uri).into(epimage);
            }
        });



        DocumentReference tReference=fstore.collection("Ademo").document(s);
         tReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {


                e21.setText(value.getString("Email"));
                e22.setText(value.getString("Name"));
                e23.setText(value.getString("Mobile_No"));
                e24.setText(value.getString("DOB"));
                //t5.setText(value.getString("Rollno"));
                e25.setText(value.getString("Gender"));
                e26.setText(value.getString("Empolyee_No"));

                String a=e21.getText().toString();
                String b=e22.getText().toString();
                String c=e23.getText().toString();
                String d=e24.getText().toString();
                String e=e25.getText().toString();
                String f=e26.getText().toString();
                String g="Email\t\t-\t"+a+"\nName\t-\t"+b+"\nContact.No.\t-\t"+c+"\nDOB\t-\t"
                        +d+"\nGender\t-\t"+e+"\nID\t-\t"+f+"\t";

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

        teuid=e21.getText().toString();


        echangeProfile.setOnClickListener(new View.OnClickListener() {
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
            if (requestCode== Activity.RESULT_OK || epimage!= null){
                Uri imageUri = data.getData();
                epimage.setImageURI(imageUri);

                uploadImageFirebase(imageUri);
            }
        }
    }
    private void uploadImageFirebase(Uri imageUri) {
        //upload image to firebase storage
        StorageReference filerefe = storageReference.child("Account/"+s+"/"+"/Profile.jpg");
        filerefe.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                filerefe.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //Picasso.get().load(uri).into(pimage);
                        Toast.makeText(Admin_profile.this, "profile uplode", Toast.LENGTH_SHORT).show();
                    }
                });
                //Toast.makeText(Home.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Admin_profile.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}
