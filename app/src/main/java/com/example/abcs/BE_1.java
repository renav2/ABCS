
package com.example.abcs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class BE_1 extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore fstore;
    Uri imageuri = null;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplod_documents);
        // upload = findViewById(R.id.uploadpdf);
        //  b=findViewById(R.id.btm);
        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        // We will be redirected to choose pdf
        galleryIntent.setType("application/pdf");
        startActivityForResult(galleryIntent, 1);
    }
    ProgressDialog dialog;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            // Here we are initialising the progress dialog box
            dialog = new ProgressDialog(this);
            dialog.setMessage("Uploading");

            // this will show message uploading
            // while pdf is uploading
            dialog.show();
            imageuri = data.getData();
            final String timestamp = "" + System.currentTimeMillis();
            StorageReference storageReference = FirebaseStorage.getInstance().getReference();
            //  final String messagePushID = getIntent().getStringExtra("pdf_sub");
            final String messagePushID = getIntent().getStringExtra("pdf_sub");

            Toast.makeText(BE_1.this, imageuri.toString(), Toast.LENGTH_SHORT).show();

            // Here we are uploading the pdf in firebase storage with the name of current time



            //--->patha
            final StorageReference filepath = storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/FE" + ".pdf");
            Toast.makeText(BE_1.this, filepath.getName(), Toast.LENGTH_SHORT).show();
            filepath.putFile(imageuri).continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return filepath.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        // After uploading is done it progress
                        // dialog box will be dismissed
                        dialog.dismiss();
                        Uri uri = task.getResult();
                        String myurl;
                        myurl = uri.toString();
                        //UPLOD FILE TO THE FIRE STORE
                        //String invo_userid1=auth.getCurrentUser().getUid();
                        String pdf_sub="FE";
//                        String pdf_date=getIntent().getStringExtra("pdf_date");
//                        String pdf_desc=getIntent().getStringExtra("pdf_desc");
//                        String pdf_highlight=getIntent().getStringExtra("pdf_highlight");
//                        String pdf_authrity=getIntent().getStringExtra("pdf_authrity");
//                        String pdf_time=getIntent().getStringExtra("pdf_time");


                        DocumentReference reference = fstore.collection("student_uplod_document").document(auth.getCurrentUser().getUid());
                        Map<String, String> v1 = new HashMap<>();
                        v1.put("urlFE", myurl);

                        reference.set(v1).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(BE_1.this, "file uploded on fstore", Toast.LENGTH_SHORT).show();

                            }
                        });




                        Toast.makeText(BE_1.this, "Uploaded Successfully", Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(doc_up_10_.this,AdminNotificationHome.class);


//                        String pdf_date=getIntent().getStringExtra("pdf_date");
//                        String pdf_desc=getIntent().getStringExtra("pdf_desc");
//                        String pdf_highlight=getIntent().getStringExtra("pdf_highlight");
//                        String pdf_authrity=getIntent().getStringExtra("pdf_authrity");
//                        String pdf_time=getIntent().getStringExtra("pdf_time");
//
//
//                        intent.putExtra("pdf_sub",pdf_sub);
//                        intent.putExtra("pdf_date",pdf_date);
//                        intent.putExtra("pdf_desc",pdf_desc);
//                        intent.putExtra("pdf_highlight",pdf_highlight);
//                        intent.putExtra("pdf_authrity",pdf_authrity);
//                        intent.putExtra("pdf_time",pdf_time);
//                        //url from test pdf
//                        intent.putExtra("pdfurl",myurl);
//
//
//                        // v1.put("url", myurl);


//                        startActivity(intent);
                    } else {
                        // dialog.dismiss();
                        Toast.makeText(BE_1.this, "UploadedFailed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}






