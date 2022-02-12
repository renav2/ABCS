package com.example.abcs;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CreateApplication extends AppCompatActivity {
    EditText name, prn, subject, desc, sdt, edt,email;
    Button b1;
    Spinner tm1,tm2; //combobox for time
    Calendar myCalendar= Calendar.getInstance();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();
    FirebaseAuth fa= FirebaseAuth.getInstance();
    String upid=fa.getCurrentUser().getUid();
    String status="Pending";
    String Cmm="";
    String id= fs.collection("Permission").document().getId();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_application);

        name= findViewById(R.id.editName);
        prn= findViewById(R.id.editPRN);
        subject = findViewById(R.id.editSubject);
        desc = findViewById(R.id.editdescribe);
        sdt = findViewById(R.id.Sdate);
        edt = findViewById(R.id.Edate);
        tm1 = findViewById(R.id.Stime);
        tm2 = findViewById(R.id.Etime);
        b1= findViewById(R.id.sbutton);
        email=findViewById(R.id.email);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //database fetch
                DocumentReference reference = fs.collection("demo").document(upid);
                reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        //basic profile things


                        String pro_name= documentSnapshot.getString("Name");
                        String pro_class=documentSnapshot.getString("Email");
                        //setdata
                        name.setText(pro_name);
                        email.setText(pro_class);

                    }
                });
//database end

            }
        }, 5);
//to get data from user
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_name= name.getText().toString();
                String s_prn= prn.getText().toString();
                String s_subject= subject.getText().toString();
                String s_desc= desc.getText().toString();
                String s_sdt= sdt.getText().toString();
                String s_edt= edt.getText().toString();
                String s_tm1= tm1.getSelectedItem().toString();
                String s_tm2= tm2.getSelectedItem().toString();
                String s_em= email.getText().toString();
                String u =upid;
                String did=id;
                if(TextUtils.isEmpty(s_name) || TextUtils.isEmpty(s_prn) || TextUtils.isEmpty(s_subject)|| TextUtils.isEmpty(s_desc)|| TextUtils.isEmpty(s_sdt)|| TextUtils.isEmpty(s_edt) || TextUtils.isEmpty(s_tm1) || TextUtils.isEmpty(s_tm2)||TextUtils.isEmpty(s_em))
                {
                    Toast.makeText(CreateApplication.this, "Please fill All the fields", Toast.LENGTH_SHORT).show();
                }
              /*  if(s_prn.matches("\\d{8}\\A{1}") ){
                    Toast.makeText(CreateApplication.this, "Wrong PRN ", Toast.LENGTH_SHORT).show();

                }*/
                else
                {
                    saveApplication(s_name,s_prn,s_subject,s_desc,s_sdt,s_edt,s_tm1,s_tm2,s_em,u,status,did,Cmm);
                }
            }
        });
        //FOR COMBOBOX
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.Time_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        tm1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.Time_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        tm2.setAdapter(adapter2);


        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener(){
            //set calender start date
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();

            }
        };
        //set calender for end date
        DatePickerDialog.OnDateSetListener date1 =new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel1();

            }
        };
        //to select date
        sdt.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CreateApplication.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        edt.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CreateApplication.this,date1,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



    }

    private void saveApplication(String sname, String sprn, String ssubject, String sdesc, String ssdt, String sedt, String stm1,
                                 String stm2, String em,String uuid,String s,String did, String cmm)
    {
        Map<String, String> application1 = new HashMap<>();
        application1.put("Name", sname);
        application1.put("Prn", sprn);
        application1.put("Subject", ssubject);
        application1.put("Description", sdesc);
        application1.put("FromD", ssdt);
        application1.put("ToD", sedt);
        application1.put("FromT", stm1);
        application1.put("ToT", stm2);
        application1.put("Email",em);
        application1.put("Status",s);
        application1.put("Uid",uuid);
        application1.put("Docid",did);
        application1.put("Comment",cmm);
        fs.collection("Permission").document(uuid).collection("Applications").document(did).set(application1)
                //fs.collection("Permission").document(uuid).set(application1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(CreateApplication.this, " Applied Successfully", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CreateApplication.this, " Application Failed", Toast.LENGTH_SHORT).show();

                    }
                });


    }

    //functions to set date
    private void updateLabel1() {
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        edt.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateLabel() {
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        sdt.setText(dateFormat.format(myCalendar.getTime()));
    }
}