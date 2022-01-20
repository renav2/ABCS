package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Admin_View_Specific_User extends AppCompatActivity {
    FirebaseFirestore fs;
    String uid;
   // FirebaseAuth auth;
    Admin_Application_History ah;
    TextView tnm,tsub,d1,d2,t1,t2,tdesc,tprn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_specific_user);

        tnm= findViewById(R.id.name);
        tprn= findViewById(R.id.prn);
        tsub= findViewById(R.id.subapp);
        tdesc= findViewById(R.id.desc);
        d1=findViewById(R.id.frmdt);
        d2=findViewById(R.id.todt);
        t1=findViewById(R.id.frmtm);
        t2=findViewById(R.id.totm);

        fs= FirebaseFirestore.getInstance();
       // auth= FirebaseAuth.getInstance();

        DocumentReference docRef = fs.collection("Permission_Applications").document(uid);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String f1= documentSnapshot.getString("Name");
                String f2= documentSnapshot.getString("Prn");
                String f3= documentSnapshot.getString("Subject");
                String f4= documentSnapshot.getString("Description");
                String f5= documentSnapshot.getString("FromD");
                String f6= documentSnapshot.getString("ToD");
                String f7= documentSnapshot.getString("FromT");
                String f8= documentSnapshot.getString("ToT");

                tnm.setText(f1);
                tprn.setText(f2);
                tsub.setText(f3);
                tdesc.setText(f4);
                d1.setText(f5);
                d2.setText(f6);
                t1.setText(f7);
                t2.setText(f8);

            }
        });

    }
}