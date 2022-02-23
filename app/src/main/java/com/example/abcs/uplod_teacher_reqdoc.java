package com.example.abcs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class uplod_teacher_reqdoc extends AppCompatActivity {
TextView tname,tdoc,tcom,support1211,vid,br,clas;
EditText  etstudcomm;
Button uplodcos;
FirebaseFirestore fstore;

FirebaseAuth auth;
    Uri imageuri = null;
    String uservid;
    String abcd,abc,ab,a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplod_teacher_reqdoc);
        tname=findViewById(R.id.tname);
        tcom=findViewById(R.id.textView124);
        tdoc=findViewById(R.id.tdoc);
        etstudcomm=findViewById(R.id.editTextTextMultiLine3);
        uplodcos=findViewById(R.id.uplodcos);
        support1211=findViewById(R.id.textView126);
        br=findViewById(R.id.bro);
        clas=findViewById(R.id.claa);
        vid=findViewById(R.id.vid);
    support1211.setText(getIntent().getStringExtra("uploddocto_specificuplod"));
    String ss=support1211.getText().toString();
    Toast.makeText(this, ss, Toast.LENGTH_SHORT).show();


    fstore=FirebaseFirestore.getInstance();
    auth=FirebaseAuth.getInstance();

        DocumentReference documentReference=fstore.collection("Teacher_required_docs").document(ss);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                tname.setText(value.getString("Email"));
                tdoc.setText(value.getString("reqdoc"));
                tcom.setText(value.getString("docdesc"));
                vid.setText(value.getString("Branch"));
                br.setText(value.getString("Branch"));
                clas.setText(value.getString("class"));
                uservid=vid.getText().toString();
                abcd=tname.getText().toString();
                abc=br.getText().toString();
                ab=clas.getText().toString();



            }
        });


//        f.collection("final_permision_status").whereEqualTo("Email",currrrem).get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot d:list)
//                        {
//                            up_model obj=d.toObject(up_model.class);
//                            datalist.add(obj);
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                });
        uplodcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                opengal();


            }
        });





    }

    private void opengal() {

        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

        galleryIntent.setType("application/pdf");
        startActivityForResult(galleryIntent, 1);
    }

    ProgressDialog dialog;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @com.google.firebase.database.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
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

            Toast.makeText(uplod_teacher_reqdoc.this, imageuri.toString(), Toast.LENGTH_SHORT).show();

            // Here we are uploading the pdf in firebase storage with the name of current time



            //--->patha
            final StorageReference filepath = storageReference.child("teacher Req doc /"+ "/"+support1211.getText().toString()+"/"+ etstudcomm.getText().toString()+ ".pdf");
            Toast.makeText(uplod_teacher_reqdoc.this, filepath.getName(), Toast.LENGTH_SHORT).show();
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
                       // String usid=vid.getText().toString();
                        myurl = uri.toString();
                        String pdf_sub="10th";



                        DocumentReference reference =   fstore.collection("shubham").document(auth.getCurrentUser().getUid());
                        Map<String, String> v1 = new HashMap<>();
                        v1.put("url10", myurl);
                        v1.put("uid",auth.getCurrentUser().getDisplayName());
                        v1.put("email",abcd);
                        v1.put("branch",abc);
                        v1.put("class",ab);


                        reference.set(v1).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(uplod_teacher_reqdoc.this, "file uploded on fstore", Toast.LENGTH_SHORT).show();


                                //delete current assign notification
                                fstore.collection("Teacher_required_docs").document(support1211.getText().toString())
                                        .delete()
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(uplod_teacher_reqdoc.this, "...............", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {

                                            }
                                        });







                            }
                        });




                        Toast.makeText(uplod_teacher_reqdoc.this, "Uploaded Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(uplod_teacher_reqdoc.this,uplod_documents.class);
                        startActivity(intent);

                        finish();



//                        startActivity(intent);
                    } else {
                        // dialog.dismiss();
                        Toast.makeText(uplod_teacher_reqdoc.this, "UploadedFailed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



}