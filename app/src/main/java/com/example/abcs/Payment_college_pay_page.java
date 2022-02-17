package com.example.abcs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Payment_college_pay_page extends AppCompatActivity implements PaymentResultWithDataListener {
int  total,fin;
String inp;

    private Button pay;
        EditText amount;
        TextView unifee,medicfee,deptfee,tituionfee,totlef;
        TextView c_flag;
        FirebaseFirestore fstore;
        FirebaseAuth auth;
        String pro_userid;
        Spinner pay_instllmen;
        String txt_secondinstallmentm;
    String txt_installment,newroll;
    String samount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentclg);

        Checkout.preload(getApplicationContext());
        //refreance
        pay=findViewById(R.id.paynow);
        amount=findViewById(R.id.txt_paynow);
        unifee=findViewById(R.id.tv_rem_alrdypay);
        medicfee=findViewById(R.id.tv_rem_remain);
        deptfee=findViewById(R.id.tv_deppartmentfees);
        tituionfee=findViewById(R.id.tv_totalfees);
        totlef=findViewById(R.id.tv_totalfees1);
        c_flag=findViewById(R.id.textView11);
        pay_instllmen=findViewById(R.id.pay_in);
        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        pro_userid=auth.getCurrentUser().getUid();
        fstore=FirebaseFirestore.getInstance();
        c_flag.setText(getIntent().getStringExtra("unid2"));





//cast dept etc wise payment stucture
        DocumentReference reference = fstore.collection("demo").document(auth.getCurrentUser().getUid());
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //fetching invoice related data from firestore
                String pro_dept=documentSnapshot.getString("Branch");
                String pro_collagename=documentSnapshot.getString("College_name");
                String pro_admisontype=documentSnapshot.getString("Admission_type");
                String pro_categary=documentSnapshot.getString("Category");
                String pro_class=documentSnapshot.getString("_Class");

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

        txt_installment=pay_instllmen.getSelectedItem().toString();

        try{




//            DocumentReference documentReference=fstore.collection("Final_paymnet_data").document(c_flag.getText().toString());
//            documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//                @Override
//                public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                    String s,s1;
//                    s=userID.toUpperCase();
//                    s1=userID.substring(1,7);
//                    t1.setText(value.getString("Name"));
//                    t2.setText(value.getString("Email"));
//                    t3.setText(value.getString("mobile no"));
//                    t4.setText(value.getString("Branch"));
//                    //             t5.setText(value.getString("Rollno"));
//                    t5.setText(value.getString("_Class"));
//                    t6.setText(s1);
//
//                }
//            });


        }
        catch (Exception e){

        }




       // Toast.makeText(Payment_college_pay_page.this, c_flag.getText().toString(), Toast.LENGTH_SHORT).show();



        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_installment=pay_instllmen.getSelectedItem().toString();
                String samount=amount.getText().toString();
                int amount = Math.round(Float.parseFloat(samount) * 100);

                if(txt_installment.equals("First")) {
                    makepay(amount);
                }else if(txt_installment.equals("Second")){


                    fstore.collection("Final_paymnet_data").whereEqualTo("Email",auth.getCurrentUser().getEmail()).get()
                            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                    List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                                    for(DocumentSnapshot d:list)
                                    {
                                        String totalfee=d.getString("totalfees");
                                        String alreadypay=d.getString("paidamount");
                                        String year=d.getString("_class");
                                          String branch=d.getString("branch");
                                          String name=d.getString("Name");
                                            String no=d.getString("mobile_no");
                                            String uid=d.getString("unicid_assignno");


                                       String remainfees=d.getString("remaining_fees");



                                       // Toast.makeText(Payment_college_pay_page.this,"you need to pay" +remainfees, Toast.LENGTH_SHORT).show();
                                    cheksecondinstallment(remainfees,totalfee,alreadypay,year,branch,name,no,uid);

                                    }
                                }
                            });





                }
            }
        });

        //payment getway imp line

    }

    private void cheksecondinstallment(String remainfees, String totalfee, String alreadypay, String year, String branch, String name, String no, String uid) {
if(!amount.getText().toString().equals(remainfees))
        {
            Toast.makeText(this, "you need to pay "+remainfees, Toast.LENGTH_SHORT).show();
        }
else{
    String txt_installment=pay_instllmen.getSelectedItem().toString();
    String samount=amount.getText().toString();
    int amount = Math.round(Float.parseFloat(samount) * 100);
    makepay(amount);

}







        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
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
         samount=amount.getText().toString();
        int amount = Math.round(Float.parseFloat(samount) * 100);

       String in= pay_instllmen.getSelectedItem().toString();

//unifee,medicfee,deptfee,tituionfee,totlef;
                Intent intent=new Intent(Payment_college_pay_page.this,Payment_Collage_invoice.class);




                if(pay_instllmen.getSelectedItem().toString().equals("First")) {
                    DocumentReference documentReference = fstore.collection("demo").document(auth.getCurrentUser().getUid());
                    documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                            String name, email, mobileno, branch, _class, unicid;
                            name = value.getString("Name");
                            email = value.getString("Email");
                            _class = value.getString("_Class");
                            mobileno = value.getString("mobile_no");
                            branch = value.getString("Branch");
                            unicid = c_flag.getText().toString();
                            uplodpayment(name, email, mobileno, branch, _class, unicid);
                        }

                        private void uplodpayment(String name, String email, String mobileno, String branch, String _class, String unicid) {
                            String txt_installment = pay_instllmen.getSelectedItem().toString();
                            String cc = totlef.getText().toString().replaceAll("[^0-9]", "");
                            int Student_totalfees = Integer.parseInt(cc);
                            int Student_currentpay = Integer.parseInt(samount);
                            int remain_fees = Student_totalfees - Student_currentpay;


                            String remainfeea = Integer.toString(remain_fees);


                            Random random = new Random();
                            int val = random.nextInt(1000000000);
                            String val2 = Integer.toString(val);
                            DocumentReference reference = fstore.collection("Final_paymnet_data").document(val2);
                            Map<String, String> v = new HashMap<>();
                            v.put("unicid_assignno", unicid);
                            v.put("Name", name);
                            v.put("mobile_no", mobileno);
                            v.put("Email", email);
                            v.put("branch", branch);
                            v.put("_class", _class);
                            v.put("totalfees", cc);
                            v.put("Section", "collagesection");
                            v.put("installment", txt_installment);
                            v.put("paidamount", samount);
                            v.put("remaining_fees", remainfeea);
                            v.put("paymentid", val2);
                            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(Payment_college_pay_page.this, "You Are Successfully Registered ", Toast.LENGTH_SHORT).show();
                                }
                            });



                        }
                    });


                }
                else
                {
                    fstore.collection("Final_paymnet_data").whereEqualTo("Email",auth.getCurrentUser().getEmail()).get()
                            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                    List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                                    for(DocumentSnapshot d:list)
                                    {
                                        String totalfee=d.getString("totalfees");
                                        String alreadypay=d.getString("paidamount");
                                        String year=d.getString("_class");
                                        String branch=d.getString("branch");
                                        String name=d.getString("Name");
                                        String no=d.getString("mobile_no");
                                        String uid=d.getString("unicid_assignno");
                                        String remainfees_after1st_insatllment=d.getString("remaining_fees");


                                        uplodseconinstallmentdata(totalfee,alreadypay,year,branch,name,no,uid,remainfees_after1st_insatllment);


                                        // Toast.makeText(Payment_college_pay_page.this,"you need to pay" +remainfees, Toast.LENGTH_SHORT).show();
                                       // cheksecondinstallment(remainfees,totalfee,alreadypay,year,branch,name,no,uid);

                                    }
                                }
                            });
                }

                intent.putExtra("amount",samount);
                intent.putExtra("instal",in);



                startActivity(intent);

    }

    private void uplodseconinstallmentdata(String totalfee, String alreadypay, String year, String branch, String name, String no, String uid, String remainfees_after1st_insatllment) {
        samount=amount.getText().toString();
        int amount = Math.round(Float.parseFloat(samount) * 100);
        int Student_totalfees = Integer.parseInt(totalfee);
        int alreadypayaaa=Integer.parseInt(alreadypay);
        int Student_currentpay = Integer.parseInt(samount);
        int remain_fees = Student_totalfees - (alreadypayaaa+Student_currentpay);


        String remainfeea = Integer.toString(remain_fees);

        Random random = new Random();
        int val = random.nextInt(1000000000);
        String val2 = Integer.toString(val);
        DocumentReference reference = fstore.collection("Final_paymnet_data").document(val2);
        Map<String, String> v = new HashMap<>();
        v.put("unicid_assignno", uid);
        v.put("Name", name);
        v.put("mobile_no", no);

        v.put("branch", branch);
        v.put("_class", year);
        v.put("totalfees", totalfee);
        v.put("Section", "collagesection");
        v.put("installment", txt_installment);
        v.put("paidamount", samount);
        v.put("remaining_fees", remainfeea);
        v.put("paymentid", val2);
        reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Payment_college_pay_page.this, "You Are Successfully Registered ", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
finish();
    }
}