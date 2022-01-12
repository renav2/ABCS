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

public class Payment_remaining_fees_paypage extends AppCompatActivity implements PaymentResultWithDataListener {
TextView alredypaid,remain;
Button rempay;
EditText Rem_py;
    //firbase declaration part
    FirebaseAuth  auth;
    String invo_userid;
    FirebaseFirestore fstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_remaining_fees_paypage);
alredypaid=findViewById(R.id.tv_rem_alrdypay);
remain=findViewById(R.id.tv_rem_remain);
Rem_py=findViewById(R.id.txt_paynow2);
rempay=findViewById(R.id.paynow2);
//firbase instance
        auth= FirebaseAuth.getInstance();
        fstore= FirebaseFirestore.getInstance();
        invo_userid=auth.getCurrentUser().getUid();

        DocumentReference reference = fstore.collection("collage_fees_paymentdata").document(invo_userid);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //basic profile things
                String txt_studenrem= documentSnapshot.getString("Student_remain_fees");
                String txt_payalredymoun=documentSnapshot.getString("Student_payed_amount");






                //setdata

                alredypaid.setText(txt_payalredymoun);
                remain.setText(txt_studenrem);


            }
        });

        rempay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ssamount=Rem_py.getText().toString();
                int samount = Math.round(Float.parseFloat(ssamount) * 100);

                String cc=Rem_py.getText().toString().replaceAll("[^0-9]", "");
                Intent intent=new Intent(Payment_remaining_fees_paypage.this, Payment_remain_fees_invoicepage.class);
                intent.putExtra("wiseamountrem",cc);
                intent.putExtra("orignalamountrem",samount);
                intent.putExtra("amorem",ssamount);
                startActivity(intent);




                makepay(samount);
            }
        });



    }

    private void makepay(int amount) {
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
            options.put("amount",amount);//pass amount in currency subunits
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
        Intent intent=new Intent(Payment_remaining_fees_paypage.this,Payment_remain_fees_invoicepage.class);
        startActivity(intent);


    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}