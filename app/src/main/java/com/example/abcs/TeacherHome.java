package com.example.abcs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TeacherHome extends AppCompatActivity {

    Button eprofile,techerspecific_per,students,permission,payment,techredocs,techdocsshow,qr;
    TextView email,dept,desg;

FirebaseFirestore fstore;
FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);
fstore=FirebaseFirestore.getInstance();



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
                    Intent intent1=new Intent(TeacherHome.this,Teacher_required_download.class);
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
}