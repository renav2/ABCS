package com.example.abcs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

public class Payment_college_pay_page extends AppCompatActivity implements PaymentResultWithDataListener {
int  total,fin;
String inp;
    private Button pay;
     EditText amount;
     TextView unifee,medicfee,deptfee,tituionfee,totlef;
        FirebaseFirestore fstore;
        FirebaseAuth auth;
        String pro_userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentclg);

        Checkout.preload(getApplicationContext());
        //refreance
        pay=findViewById(R.id.paynow);
        amount=findViewById(R.id.txt_paynow);
        unifee=findViewById(R.id.tv_university_fees);
        medicfee=findViewById(R.id.tv_medical_fees);
        deptfee=findViewById(R.id.tv_deppartmentfees);
        tituionfee=findViewById(R.id.tv_totalfees);
        totlef=findViewById(R.id.tv_totalfees1);


        auth=FirebaseAuth.getInstance();


       // pro_userid = getIntent().getStringExtra("user_id_home");
         pro_userid=auth.getCurrentUser().getUid();
         fstore=FirebaseFirestore.getInstance();
         DocumentReference reference = fstore.collection("demo").document(pro_userid);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //fetching invoice related data from firestore
                String pro_dept=documentSnapshot.getString("Branch");
                String pro_collagename=documentSnapshot.getString("College_name");
                String pro_admisontype=documentSnapshot.getString("Admission_type");
                String pro_categary=documentSnapshot.getString("Category");
                String pro_class=documentSnapshot.getString("Class");




//comp BE & capround
                if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90000");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                  //comp   BE Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
               else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
               else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE comp
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //comp  Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //comp  Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //comp   BE Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                 else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //comp   BE Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//dept change




                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //IT   BE Managment
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE IT
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //IT  Managment
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //IT  Managment
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //IT   BE Managment
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //IT   BE Managment
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }


    //dept---->entc

                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //ENTC   BE Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE ENTC
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //ENTC  Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //ENTC  Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //ENTC   BE Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //ENTC   BE Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }

// DEPT CHANGE--->



                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Civil   BE Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE Civil
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //Civil  Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //Civil  Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Civil   BE Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Civil   BE Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }

//DEPT -->Mech


                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Mech   BE Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE Mech
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //Mech  Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //Mech  Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Mech   BE Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Mech   BE Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }







            }
        });

        //payment getway imp line





       pay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              String samount=amount.getText().toString();
               int amount = Math.round(Float.parseFloat(samount) * 100);

               String cc=totlef.getText().toString().replaceAll("[^0-9]", "");
             Intent intent=new Intent(Payment_college_pay_page.this, Payment_Collage_invoice.class);
             intent.putExtra("wiseamount",cc);
             intent.putExtra("orignalamount",amount);
             intent.putExtra("amo",samount);
             startActivity(intent);


            makepay(amount);

           }
       });




    }

    public void makepay(int a) {
        Checkout checkout = new Checkout();

        checkout.setKeyID("rzp_test_9nCAqrhuTfsGcZ");

        /**
         * Instantiate Checkout
         */


        /**
         * Set your logo here
         */


        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", "sinhagad");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount",a);//pass amount in currency subunits
            options.put("prefill.email"," ");
            options.put("prefill.contact"," ");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);


        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }

    }

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        Intent intent =new Intent(Payment_college_pay_page.this, Payment_Collage_invoice.class);
        startActivity(intent);

    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}