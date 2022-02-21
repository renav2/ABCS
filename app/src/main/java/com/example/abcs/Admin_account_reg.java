package com.example.abcs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Admin_account_reg extends AppCompatActivity {

    EditText tname,temail,tmno,tdob,tadd,tpass;
    TextView tempno;
    Spinner tgen ;
    Button treg;
    ImageView timage;
    //TextView tempno;
    DatePickerDialog picker;
    FirebaseFirestore fstore;
    FirebaseAuth auth;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_teachers_reg);

        fstore=FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        tname=findViewById(R.id.te_name);
        temail=findViewById(R.id.te_email);
        tmno=findViewById(R.id.te_mno);
        tempno=findViewById(R.id.te_empno);
        tdob=findViewById(R.id.te_dob);
        tadd=findViewById(R.id.te_add);
        tpass=findViewById(R.id.te_pass);

        tgen=findViewById(R.id.te_gender);


        treg=findViewById(R.id.te_reg);

        //timage=findViewById(R.id.te_image);


        tdob.setInputType(InputType.TYPE_NULL);
        tdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Admin_account_reg.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tdob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }

        });


        treg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String t_name=tname.getText().toString();
                String t_email =temail.getText().toString();
                String t_mno=tmno.getText().toString();
                String a=t_mno.substring(6,10);
                String t_emp =tempno.getText().toString();
                String t_add=tadd.getText().toString();
                String t_dob =tdob.getText().toString();
                String t_pass=tpass.getText().toString();
                String b=t_dob.substring(1,3);
                String t_gen=tgen.getSelectedItem().toString();
                String t_gn=t_gen.substring(1,3);
                String tuid=a+b+t_gn;
                DocumentReference treference=fstore.collection("Ademo").document(t_email);
                Map<String, String> ve=new HashMap<>();
                ve.put("Name",t_name);
                ve.put("Email",t_email);
                ve.put("Mobile_No",t_mno);
                ve.put("Empolyee_No",tuid);
                ve.put("Address",t_add);
                ve.put("DOB",t_dob);
                ve.put("Gender",t_gen);
                ve.put("Password",t_pass);


                treference.set(ve).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Admin_account_reg.this, "Account_User Successfully Registered ", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(Admin_account_reg.this,Admin_tool_home.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Admin_account_reg.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

//        timage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //open gallery
//                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(openGalleryIntent,100);
//            }
//        });
//
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==100){
//            if (requestCode== Activity.RESULT_OK || timage!= null){
//                Uri imageUri = data.getData();
//                timage.setImageURI(imageUri);
//
//                uploadImageFirebase(imageUri);
//            }
//        }
//    }
//    private void uploadImageFirebase(Uri imageUri) {
//        //upload image to firebase storage
//
//
//        StorageReference fileref = storageReference.child("Teachers/"+temail.getText().toString()+"/"+"/Profile.jpg");
//        fileref.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                fileref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                    @Override
//                    public void onSuccess(Uri uri) {
//                        //Picasso.get().load(uri).into(pimage);
//                        Toast.makeText(Admin_teachers_reg.this, "profile uplode", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                //Toast.makeText(Home.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Admin_teachers_reg.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}