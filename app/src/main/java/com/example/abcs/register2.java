package com.example.abcs;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class register2 extends AppCompatActivity {
    TextView userid;
    EditText etRegEmail;
    EditText etRegPassword;
    Button btnRegister;
    FirebaseDatabase db;
    FirebaseAuth mAuth;

    private TextView title;
    private Button register;
    private FirebaseAuth auth;
    private FirebaseFirestore fstore;
    private EditText name, email, clgid, dob, password, mno,estate,rollno;
    private Spinner cgender, adtype, cname, cat, year, acd, br;
    DatePickerDialog picker;
    EditText eText;
FirebaseUser uu;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPassword = findViewById(R.id.etRegPass19);
        btnRegister = findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();

        //user id
        userid=findViewById(R.id.tv_userid);
//        String from_socialmedia_login_userid=getIntent().getStringExtra("userid");
//        userid.setText(from_socialmedia_login_userid);
//        String pass=userid.getText().toString();

        adtype=findViewById(R.id.Atype);
        cname=findViewById(R.id.college);
        cat=findViewById(R.id.Ctype);
        year=findViewById(R.id.Cyear);
        acd=findViewById(R.id.Ayear);
        br=findViewById(R.id.branch);
        estate=findViewById(R.id.state);
        rollno=findViewById(R.id.mno2);
        auth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        //lable
        title = findViewById(R.id.tv_title);
        cgender = findViewById(R.id.gender);
        //button
        register = findViewById(R.id.btnRegister);
        //edit text
        name = findViewById(R.id.et_name);
        email = findViewById(R.id.etRegEmail);
        //clgid = findViewById(R.id.et_clgid);
        mno = findViewById(R.id.mno);
        rollno.setVisibility(View.INVISIBLE);







        try {
            email.setText(auth.getCurrentUser().getEmail());
            mno.setText(auth.getCurrentUser().getPhoneNumber());
            if(!mno.getText().toString().equals("")){
                uu=auth.getCurrentUser();
                uu.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(register2.this, "dltuser", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }catch (Exception e){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
        password = findViewById(R.id.etRegPass19);
            //current user
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
        userid.setText(auth.getCurrentUser().getUid());

        String    pass=userid.getText().toString();

        //for only date
        eText = (EditText) findViewById(R.id.et_dob);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(register2.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }

        });

        btnRegister.setOnClickListener(view ->{

           // userid.setText(auth.getCurrentUser().getUid());


                   //uploddata();
            phonechak(mno.getText().toString());


                    // uploddatrealtime();


        });


    }

    private void phonechak(String toString) {

if(toString.length()<10){
    Toast.makeText(this, "phonelength is short", Toast.LENGTH_SHORT).show();
}else{

   chkvalid();


}
    }

    private void chkvalid() {

        String text_name=name.getText().toString();
        String text_email = email.getText().toString();
        String txt_dob= eText.getText().toString();
        String txt_gender=cgender.getSelectedItem().toString();

        String txt_mno=mno.getText().toString();
        String value=name.getText().toString()+eText.getText().toString();
        String txt_clgid=value.toString();
        String text_rollno=rollno.getText().toString();
        String txt_add=estate.getText().toString();
        String txt_clg=cname.getSelectedItem().toString();
        String txt_atyp=adtype.getSelectedItem().toString();

        //    private Spinner cgender, adtype, cname, cat, year, acd, br;

        String txt_cate=cat.getSelectedItem().toString();

        String txt_bran=br.getSelectedItem().toString();


        String txt_yearn=year.getSelectedItem().toString();

        String txt_acdy=acd.getSelectedItem().toString();

        String text_password = password.getText().toString();

        if(txt_gender.equals("Gender")||txt_cate.equals("Select Category")||txt_atyp.equals("Branch Name") ||  txt_yearn.equals("Select class")|| txt_atyp.equals("Academic year")  ){
            Toast.makeText(this, "Select currect spinner", Toast.LENGTH_SHORT).show();
        }
        else{
            pas();
        }


    }

    private void pas() {
        String    pass1=userid.getText().toString();
        uploddataa(pass1);
        createUser(email.getText().toString(),password.getText().toString());

    }


    private void createUser(String oString, String tString1) {
        auth.createUserWithEmailAndPassword(oString,tString1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            finish();
//                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }else{
                            //display some message here
//                            Toast.makeText(MainActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
//                        progressDialog.dismiss();
                    }
                });

    }




    private void uploddataa(String passss) {
        String text_name=name.getText().toString();
        String text_email = email.getText().toString();
        String txt_dob= eText.getText().toString();
        String txt_gender=cgender.getSelectedItem().toString();
        if(txt_gender.equals("Gender")){
            Toast.makeText(this, "Select gender", Toast.LENGTH_SHORT).show();
        }
        String txt_mno=mno.getText().toString();
        String value=name.getText().toString()+eText.getText().toString();
        String txt_clgid=value.toString();
        String text_rollno=rollno.getText().toString();
        String txt_add=estate.getText().toString();
        String txt_clg=cname.getSelectedItem().toString();
        String txt_atyp=adtype.getSelectedItem().toString();
        if(txt_atyp.equals("Admission Type")){
            Toast.makeText(this, "Select Admisiontype", Toast.LENGTH_SHORT).show();
        }

        //    private Spinner cgender, adtype, cname, cat, year, acd, br;

        String txt_cate=cat.getSelectedItem().toString();

        if(txt_cate.equals("Select Category")){
            Toast.makeText(this, "Select Admisiontype", Toast.LENGTH_SHORT).show();
        }
        String txt_bran=br.getSelectedItem().toString();

        if(txt_atyp.equals("Branch Name")){
            Toast.makeText(this, "Select Branch", Toast.LENGTH_SHORT).show();
        }
        String txt_yearn=year.getSelectedItem().toString();
        if(txt_yearn.equals("Select class")){
            Toast.makeText(this, "Select Class", Toast.LENGTH_SHORT).show();
        }
        String txt_acdy=acd.getSelectedItem().toString();
        if(txt_atyp.equals("Academic year")){
            Toast.makeText(this, "Select Acedemic Year", Toast.LENGTH_SHORT).show();
        }
        String text_password = password.getText().toString();


//        String pass_copy=passss;
DocumentReference reference=fstore.collection("demo").document(passss);
        Map<String, String> v=new HashMap<>();

        v.put("Name",text_name);
        v.put("mobile_no",txt_mno);
        v.put("Email",text_email);
        v.put("Unique_id",txt_clgid);
        v.put("DOB",txt_dob);
        v.put("Gender",txt_gender);
        v.put("Address",txt_add);
        v.put("College_name",txt_clg);
        v.put("Admission_type",txt_atyp);
        v.put("Category",txt_cate);
        v.put("Branch",txt_bran);
        v.put("_Class",txt_yearn);
        v.put("Academic_year",txt_acdy);
        v.put("Password",text_password);
        v.put("firebaseuid",auth.getCurrentUser().getUid());
        v.put("collagepayemtfees____","0");


        Random random=new Random();
        int val=random.nextInt(110);


        if(txt_bran.equals("Comp")){
            v.put("assignno","CO"+txt_yearn+val);
        }
        if(txt_bran.equals("IT")){
            v.put("assignno","M"+txt_yearn+val);
        }
        if(txt_bran.equals("ENTC")){
            v.put("assignno","E"+txt_yearn+val);
        }
        if(txt_bran.equals("Civil")){
            v.put("assignno","CI"+txt_yearn+val);
        }
        if(txt_bran.equals("Mech")){
            v.put("assignno","M"+txt_yearn+val);
        }




        reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(register2.this, "You Are Successfully Registered ", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(register2.this,MainActivity.class);
                startActivity(intent);
            }
        });







    }





}