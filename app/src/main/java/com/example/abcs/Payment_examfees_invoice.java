package com.example.abcs;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Payment_examfees_invoice extends AppCompatActivity {
    Display mDisplay;
    String imagesUri;
    String path;
    Bitmap bitmap;

    int totalHeight;
    int totalWidth;


    public static final int READ_PHONE = 110;
    TextView na,roll,clas,bran,prn,forno,amo,invoicn;
    FirebaseAuth auth;
    String invo_userid;
    FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_examfees_invoice);

        na=findViewById(R.id.tv_examname201);
        clas=findViewById(R.id.tv_exam_class202);
        bran=findViewById(R.id.tv_exam_branch203);
        roll=findViewById(R.id.tv_exam_rollno204);
        prn=findViewById(R.id.tv_examprn206);
        forno=findViewById(R.id.tv_examform_207);
        amo=findViewById(R.id.textView42);
        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        invo_userid=auth.getCurrentUser().getUid();
        invoicn=findViewById(R.id.textView46);

        String ex1_amountpass = getIntent().getStringExtra("examamountint");
        String ex1_string_amountpass = getIntent().getStringExtra("examamount");
        String ex1_prn = getIntent().getStringExtra("examprn");
        String ex1_formno = getIntent().getStringExtra("exform");

        //data setting

        na.setText(getIntent().getStringExtra("examname"));
        clas.setText(getIntent().getStringExtra("examclass"));
        bran.setText(getIntent().getStringExtra("exambranch"));
        roll.setText(getIntent().getStringExtra("examrollno"));
        amo.setText(ex1_string_amountpass);
        forno.setText(ex1_formno);
        prn.setText(ex1_prn);
        invoice_no();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                String txt_na = na.getText().toString();
                String txt_class = clas.getText().toString();
                String txt_roll = roll.getText().toString();
                String txt_dept = bran.getText().toString();
               String txt_invoic = invoicn.getText().toString();
                String txt_invamount = amo.getText().toString();


                int to = 11000;
                int pay = Integer.parseInt(txt_invamount);
                // int curr=Integer.parseInt(pass);
                int rem = to -pay;
                String txt_rem = Integer.toString(rem);

                WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                mDisplay = wm.getDefaultDisplay();
                if(Build.VERSION.SDK_INT >= 23){
                    if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                            && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED){
                    }else{
                        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, READ_PHONE);
                    }
                }


                DocumentReference reference = fstore.collection("Hostel_fees_data").document(invo_userid);
                Map<String, String> v = new HashMap<>();
                v.put("1Student_roll_no", txt_roll);
                v.put("1Student_name", txt_na);
                v.put("1Student_class", txt_class);
                v.put("1Student_dept", txt_dept);
               // v.put("1Student_invoiceno", txt_invoic);
                //v.put("1Student_total_fees", pass);
                v.put("1Student_payed_amount", txt_invamount);
                v.put("1Student_remain_fees", txt_rem);

                reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                   //     Toast.makeText(Payment_host.this, "your payment record save", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        }, 100);






    }

    private void invoice_no() {

        Random random=new Random();
        int val=random.nextInt(1000000000);
        int val2=random.nextInt(1000000000);
        if(val ==val2){
            invoicn .setText("E0"+val);
        }

        invoicn.setText(Integer.toString(val));

    }
}