package com.example.abcs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

public class paymentclg extends AppCompatActivity implements PaymentResultWithDataListener {
int  total,fin;
String inp;
    private Button pay;
     EditText amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentclg);
        //refreance
        pay=findViewById(R.id.paynow);
        amount=findViewById(R.id.txt_paynow);
//total=Integer.parseInt(amount.getText().toString());



        //payment getway imp line
        Checkout.preload(getApplicationContext());

       pay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              String samount=amount.getText().toString();
               int amount = Math.round(Float.parseFloat(samount) * 100);
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