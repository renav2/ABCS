package com.example.abcs;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AdminNotificationHome extends AppCompatActivity {
    EditText date1,sub,high,descn;
    Switch sw1;
    Spinner timelog,sauth;
    String txt_time;
    TextView tt,url;

    Calendar myCalendar= Calendar.getInstance();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();
    // FirebaseAuth fa= FirebaseAuth.getInstance();
    //  String upid=fs.getCurrentUser().getUid();
    Button n, uploddoc;
    String abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_notification_home);
        date1 = findViewById(R.id.ndt);
            sub= findViewById(R.id.nsub);
            descn= findViewById(R.id.ndesc);
            high=  findViewById(R.id.hi);
            sauth= findViewById(R.id.aut);
            n=findViewById(R.id.nb);
url=findViewById(R.id.textView81);

            uploddoc=findViewById(R.id.button14);



        url.setText(getIntent().getStringExtra("pdfurl"));
            sub.setText(getIntent().getStringExtra("pdf_sub"));
        date1.setText(getIntent().getStringExtra("pdf_date"));
        descn.setText(getIntent().getStringExtra("pdf_desc"));
        high.setText(getIntent().getStringExtra("pdf_highlight"));
        //sauth.setText(getIntent().getStringExtra("pdf_authrity"));

        abc=sauth.getSelectedItem().toString();

        //sauth.setSelected(getIntent().getStringExtra("abc"));

        //tt.setText(getIntent().getStringExtra("pdf_time"));









            uploddoc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(AdminNotificationHome.this,test_uplodpdf.class);
                   // intent.putExtra("pdf_time",tt.getText().toString());
                    intent.putExtra("pdf_sub",sub.getText().toString());
                    intent.putExtra("pdf_desc",descn.getText().toString());
                    intent.putExtra("pdf_highlight",high.getText().toString());
                    intent.putExtra("pdf_authrity",abc.toString());
                    //intent.putExtra("home_pass",_pass);
                    intent.putExtra("pdf_date",date1.getText().toString());
                    startActivity(intent);
                }
            });






            n.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String s_dt= date1.getText().toString();
                    String s_sub= sub.getText().toString();
                    String s_desc= descn.getText().toString();
                    String s_hi= high.getText().toString();
                    String au = sauth.getSelectedItem().toString();
                    String pdfurl=url.getText().toString();
                    if(TextUtils.isEmpty(s_sub) || TextUtils.isEmpty(s_desc)|| TextUtils.isEmpty(s_dt)|| TextUtils.isEmpty(s_hi) || TextUtils.isEmpty(au))
                    {
                        Toast.makeText(AdminNotificationHome.this, "Please fill All the fields", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                       // saveNotice(s_dt,s_sub,s_desc,s_hi,au);
                        saveNotice1(pdfurl,s_dt,s_sub,s_desc,s_hi,au);
                    }
                }
            });
            //set calender for end date
            DatePickerDialog.OnDateSetListener datee =new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH,month);
                    myCalendar.set(Calendar.DAY_OF_MONTH,day);
                    updateLabel1();

                }
            };
            //to select date
            date1.setOnClickListener(new  View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new DatePickerDialog(AdminNotificationHome.this,datee,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });
        }

    private void saveNotice1(String pdfurl, String s_dt, String s_sub, String s_desc, String s_hi, String au) {
        Map<String, String> application1 = new HashMap<>();
        application1.put("Notice_Date", s_dt);
        application1.put("Subject", s_sub);
        application1.put("Description", s_desc);
        application1.put("Highlight", s_hi);
        application1.put("Authority", au);
        application1.put("pdfurl1",pdfurl);
        fs.collection("Notices").document(s_sub).set(application1)
                //fs.collection("Permission").document(uuid).set(application1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AdminNotificationHome.this, " Notified Successfully", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AdminNotificationHome.this, " Notification failed Failed", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void saveNotice(String s_dt, String s_sub, String s_desc, String s_hi, String au) {

        }
        private void updateLabel1() {
            String myFormat="MM/dd/yy";
            SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
            date1.setText(dateFormat.format(myCalendar.getTime()));
        }
    }
