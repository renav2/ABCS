package com.example.abcs;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class test_user_permision_ask extends AppCompatActivity {
FirebaseFirestore fstore;
FirebaseAuth auth;
    TextView name;
    TextView email,cls,brh;
    Button req;
    EditText comments;
    Spinner sec,clg,dept,hostel;
    String invo_userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_user_permision_ask);
        cls=findViewById(R.id.textView85);
        brh=findViewById(R.id.textView97);

auth=FirebaseAuth.getInstance();
fstore=FirebaseFirestore.getInstance();
comments=findViewById(R.id.permi_data);
name=findViewById(R.id.tv_perminame);
email=findViewById(R.id.permi_email);
req=findViewById(R.id.permi_btn);
sec=findViewById(R.id.permi_firstspin);
clg=findViewById(R.id.spi_Permiosonforcollage);
//dept=findViewById(R.id.spi_Permiosonfordept);
//hostel=findViewById(R.id.spi_PermiosonforHostel);

        invo_userid=auth.getCurrentUser().getUid();
//        clg.setVisibility(View.INVISIBLE);
//        dept.setVisibility(View.INVISIBLE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //database fetch
                DocumentReference reference = fstore.collection("demo").document(invo_userid);
                reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        //basic profile things


                        String pro_name= documentSnapshot.getString("Name");
                        String pro_class=documentSnapshot.getString("Email");
                        String branch=documentSnapshot.getString("Branch");
                        String pr_class=documentSnapshot.getString("_Class");

                     cls.setText(pr_class);
                     brh.setText(branch);
                        //setdata
                        name.setText(pro_name);
                        email.setText(pro_class);

                    }
                });
//database end

            }
        }, 10);

req.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //add all field

        // Spinner sec,clg,dept,hostel;


      if(sec.getSelectedItem().toString().equals("Select section "))  {
            Toast.makeText(test_user_permision_ask.this, "Select Correct Section ", Toast.LENGTH_SHORT).show();

        }else  if(clg.getSelectedItem().toString().equals("⭐Permioson for dept⭐")||clg.getSelectedItem().toString().equals("⭐Permioson for Hostel⭐")||clg.getSelectedItem().toString().equals("⭐Permioson for collage⭐")) {

          Toast.makeText(test_user_permision_ask.this, "Select Correct spinner", Toast.LENGTH_SHORT).show();
      }else if(comments.getText().toString().equals("")){
          Toast.makeText(test_user_permision_ask.this, "Enter some description ", Toast.LENGTH_SHORT).show();
      }


      else{
        uplodreq(name,email,comments,sec,clg);
    }
    }


});





    }

    private void uplodreq(TextView name, TextView email, EditText comments, Spinner sec, Spinner clg) {

                String tx_na=name.getText().toString();
                String tx_em=email.getText().toString();
                String tx_comm= comments.getText().toString();
                String tx_se=sec.getSelectedItem().toString();
                String tx_clg=clg.getSelectedItem().toString();
        Random random=new Random();
        int val=random.nextInt(1000000000);
        String val2=Integer.toString(val);

       //add data to the firebase
        DocumentReference reference = fstore.collection("student_req_permision_data").document(val2);
        Map<String, String> v = new HashMap<>();
        v.put("Name", tx_na);
        v.put("Email", tx_em);
        v.put("brnach", brh.getText().toString());
        v.put("class", cls.getText().toString());
        v.put("Comments", tx_comm);
        v.put("Section", tx_se);
        v.put("Level", tx_clg);
        v.put("status","pending");


        v.put("permissionid",val2);




        reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(test_user_permision_ask.this, "yor req is recorde", Toast.LENGTH_SHORT).show();
            }
        });



    }
}