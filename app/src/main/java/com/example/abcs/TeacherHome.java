package com.example.abcs;

import androidx.annotation.Nullable;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class TeacherHome extends AppCompatActivity {

    Button eprofile,techerspecific_per,students,permission,payment,techredocs,techdocsshow,qr,upload,view;
    TextView email,dept,desg;
    StorageReference storageReference;
FirebaseFirestore fstore;
FirebaseAuth auth;
ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);
fstore=FirebaseFirestore.getInstance();

        upload=findViewById(R.id.notupload);
        view=findViewById(R.id.notview);

        img=findViewById(R.id.imagete);
        email=findViewById(R.id.textView89);
        dept=findViewById(R.id.textView123);
        desg=findViewById(R.id.textView92);
        eprofile=findViewById(R.id.tprofile);
        students=findViewById(R.id.button44);
        permission=findViewById(R.id.button43);
        payment=findViewById(R.id.button45);
        techredocs=findViewById(R.id.button49);
        techdocsshow=findViewById(R.id.button50);

        email.setText(getIntent().getStringExtra("Teacher"));

        //profile pic
        storageReference= FirebaseStorage.getInstance().getReference();
        //currunt user id store in r  & for sring purpose
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
        StorageReference profileRef= storageReference.child("Teachers/"+email.getText().toString()+"/Profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(img);
            }
        });



        DocumentReference documentReference=fstore.collection("tdemo").document(email.getText().toString());
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

//                String txt_name=value.getString("Name");
//                String txt_email= value.getString("Email");
//                String txt_mobno=value.getString("Mobile_No");
//                String txt_desig=value.getString("Designation");
//                //t5.setText(value.getString("Rollno"));
//                String txt_dept =value.getString("Department");
//                String txt_emp=value.getString("Empolyee_No");

                desg.setText(value.getString("Designation"));
                dept.setText(value.getString("Department"));
                email.setText(value.getString("Email"));
            }
        });

//        qr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1=new Intent(TeacherHome.this,GenerateQRCodeActivity.class);
//                startActivity(intent1);
//            }
//        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherHome.this,AdminNotificationHome.class);
                startActivity(intent1);

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherHome.this,Admin_tool_noticedelete.class);
                startActivity(intent1);

            }
        });
        try{
            techredocs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(TeacherHome.this,Teacher_required_docs.class);
                    startActivity(intent1);
                }
            });

            techdocsshow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(TeacherHome.this,Teacher_Doc_wise_sort.class);
                    intent1.putExtra("Email",email.getText().toString());
                    intent1.putExtra("Designation",desg.getText().toString());
                    intent1.putExtra("Department",dept.getText().toString());
                    startActivity(intent1);
                }
            });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherHome.this,Teacher_payment_wise_sort.class);
                intent1.putExtra("Email",email.getText().toString());
                intent1.putExtra("Designation",desg.getText().toString());
                intent1.putExtra("Department",dept.getText().toString());

                startActivity(intent1);
            }
        });}catch (Exception e){
            Toast.makeText(TeacherHome.this, "Error" +e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherHome.this,Teacher_permission_wise_sort.class);
                intent1.putExtra("Email",email.getText().toString());
                intent1.putExtra("Designation",desg.getText().toString());
                intent1.putExtra("Department",dept.getText().toString());
                startActivity(intent1);
            }
        });

        eprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherHome.this,Admin_teacher_profile.class);
                intent1.putExtra("TeacherID",email.getText().toString());
                startActivity(intent1);
            }
        });

       // eprofile,techerspecific_per
        students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TeacherHome.this,Teacher_class_wise_sort.class);
                intent1.putExtra("Email",email.getText().toString());
                intent1.putExtra("Designation",desg.getText().toString());
                intent1.putExtra("Department",dept.getText().toString());
                startActivity(intent1);
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
        Toast.makeText(TeacherHome.this, "Logout Succesfully", Toast.LENGTH_SHORT).show();
        finish();
    }



}