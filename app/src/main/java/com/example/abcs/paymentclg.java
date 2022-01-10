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

public class paymentclg extends AppCompatActivity implements PaymentResultWithDataListener {
int  total,fin;
String inp;
    private Button pay;
     EditText amount;
     TextView unifee,medicfee,deptfee,tituionfee;

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
        tituionfee=findViewById(R.id.tv_tution_fees);
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

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//

                }
//comp   BE Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                }
//tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                }
 //--> inhouse cota


               else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//

                }
   //--> j and k
               else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k

                }





            }
        });
















        //payment getway imp line


       pay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              String samount=amount.getText().toString();
               int amount = Math.round(Float.parseFloat(samount) * 100);


             Intent intent=new Intent(paymentclg.this,payment_invoi.class);
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
        Intent intent =new Intent(paymentclg.this,payment_invoi.class);
        startActivity(intent);

    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}