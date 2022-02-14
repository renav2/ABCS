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

        password = findViewById(R.id.etRegPass19);

            //current user
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();



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

userid.setText(auth.getCurrentUser().getUid());
            String    pass=userid.getText().toString();
                   uploddataa(pass);
                   //uploddata();
                    // createUser();
                    // uploddatrealtime();
        });


    }

    private void uploddataa(String passss) {
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
        String txt_cate=cat.getSelectedItem().toString();
        String txt_bran=br.getSelectedItem().toString();
        String txt_yearn=year.getSelectedItem().toString();
        String txt_acdy=acd.getSelectedItem().toString();
        String text_password = password.getText().toString();


//        String pass_copy=passss;
DocumentReference reference=fstore.collection("demo").document(passss);
        Map<String, String> v=new HashMap<>();
        v.put("Rollno",text_rollno);
        v.put("Name",text_name);
        v.put("mobile no",txt_mno);
        v.put("Email",text_email);
        v.put("Unique_id",txt_clgid);
        v.put("DOB",txt_dob);
        v.put("Gender",txt_gender);
        v.put("Address",txt_add);
        v.put("College_name",txt_clg);
        v.put("Admission_type",txt_atyp);
        v.put("Category",txt_cate);
        v.put("Branch",txt_bran);
        v.put("Class",txt_yearn);
        v.put("Academic_year",txt_acdy);
        v.put("Password",text_password);


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