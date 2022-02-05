package com.example.abcs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

public class Payment_hostel extends AppCompatActivity implements PaymentResultWithDataListener {
private Button hos_pay;
private EditText hos_a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_hostel);
        hos_pay=findViewById(R.id.btn_hostelpay);
        hos_a=findViewById(R.id.txt_hostelpay_amount);


        hos_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String samount=hos_a.getText().toString();
                int amount = Math.round(Float.parseFloat(samount) * 100);
               if(samount.equals("61500")){
                   makepay(amount);

               }else{
                   Toast.makeText(Payment_hostel.this, "you nee to pay full fees", Toast.LENGTH_SHORT).show();
               }
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
        Intent intent =new Intent(Payment_hostel.this, Payment_hostel_fees_invoice.class);
        String samount3=hos_a.getText().toString();
        int amount3 = Math.round(Float.parseFloat(samount3) * 100);




        // Intent intent=new Intent(Payment_college_pay_page.this, Payment_Collage_invoice.class);

        intent.putExtra("orignalamount3",amount3);
        intent.putExtra("amo3",samount3);


        startActivity(intent);
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}