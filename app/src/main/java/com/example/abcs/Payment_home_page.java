package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Payment_home_page extends AppCompatActivity {
private Button  clgpayjump;
private  Button hostel_pay;
private Button exam_pay;
//TextView  txt_hospen,hospen,txt_clgpen;


TextView studentf;
    FirebaseFirestore fstore;
    FirebaseAuth auth;
    String pro_userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
clgpayjump=findViewById(R.id.btn_clg_jump);
hostel_pay=findViewById(R.id.btn_gohostel);
exam_pay=findViewById(R.id.btn_goexamfee);
studentf=findViewById(R.id.textView7);


studentf.setText(getIntent().getStringExtra("unicid"));



        auth=FirebaseAuth.getInstance();

//txt_hospen=findViewById(R.id.textView16);
//txt_clgpen=findViewById(R.id.textView14);
//hospen=findViewById(R.id.tv_hostelpending);





        // pro_userid = getIntent().getStringExtra("user_id_home");
        pro_userid=auth.getCurrentUser().getUid();
        fstore=FirebaseFirestore.getInstance();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                DocumentReference reference = fstore.collection("collagefees_1_installment").document(pro_userid);
//                reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        //basic profile things
//                        String pay_yourfees1 = documentSnapshot.getString("_1Student_remain_fees");
//                        studentf.setText(pay_yourfees1 + "₹");
//                        if(studentf.getText().toString().equals("0₹")){
//                           // studentf.setVisibility(View.INVISIBLE);
//                          //  txt_clgpen.setVisibility(View.INVISIBLE);
//                            Toast.makeText(Payment_home_page.this, "rrrrrrrrrrr", Toast.LENGTH_SHORT).show();
//                        }else {
//                            studentf.setText(pay_yourfees1 + "₹");
//                        }
//                    }
//                });

//                DocumentReference reference2 = fstore.collection("collagefees_2_installment").document(pro_userid);
//                reference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        //basic profile things
//                        String pay_yourfees1 = documentSnapshot.getString("_1Student_remain_fees");
//                        studentf.setText(pay_yourfees1 + "₹");
//
//
//                        if(studentf.getText().toString().equals("0₹")){
//                            studentf.setVisibility(View.INVISIBLE);
////                            txt_clgpen.setVisibility(View.INVISIBLE);
//
//                        }else {
//                            studentf.setText(pay_yourfees1 + "₹");
//                        }
//
//                    }
//                });
            }
        }, 400);
//
//        DocumentReference reference = fstore.collection("collagefees_2_installment").document(pro_userid);
//        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                //basic profile things
//                String pay_yourfees1 = documentSnapshot.getString("_1Student_remain_fees");
//
//
//              //  hospen.setText(pay_yourfees1 + "₹");
//
//
//
//
//
//            }
//        });
//





//1 st data base result




//hostal payment fees status
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                DocumentReference reference = fstore.collection("Hostel_fees_data").document(pro_userid);
                reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        //basic profile things
                        String pay_yourfees1= documentSnapshot.getString("_1Student_remain_fees");



//
//                        hospen.setText(pay_yourfees1+"₹");
//
//
//                        if(hospen.getText().toString().equals("0₹")||hospen.getText().toString().equals("null₹")){
//                            txt_hospen.setVisibility(View.INVISIBLE);
//                            hospen.setVisibility(View.INVISIBLE);
//                        }else{
//                            txt_hospen.setVisibility(View.VISIBLE);
//                            hospen.setVisibility(View.VISIBLE);
//                        }


                    }
                });






            }
        }, 400);












        clgpayjump.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Payment_home_page.this, Payment_collage_fullfee_or_remainfee.class);
//       String mm= studentf.getText().toString();
//        intent.putExtra("rempasstorempay",mm);

        intent.putExtra("unicid1",studentf.getText().toString());



        startActivity(intent);
    }
});


hostel_pay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Payment_home_page.this,Payment_hostel.class);
        intent.putExtra("unicid_for_Hostel",studentf.getText().toString());
        startActivity(intent);
    }
});

exam_pay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(Payment_home_page.this,payment_exam_fees.class);
        intent.putExtra("unicid_for_exampay",studentf.getText().toString());

        startActivity(intent);
    }
});




    }
}