package com.example.abcs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Payment_hostel extends AppCompatActivity implements PaymentResultWithDataListener {
private Button hos_pay;
private EditText hos_a;
TextView ii;
FirebaseFirestore fstore;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_hostel);
        hos_pay=findViewById(R.id.btn_hostelpay);
        hos_a=findViewById(R.id.txt_hostelpay_amount);
fstore=FirebaseFirestore.getInstance();
auth=FirebaseAuth.getInstance();

        ii=findViewById(R.id.textView52);
        ii.setText(getIntent().getStringExtra("unicid_for_Hostel"));


        hos_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String samount=hos_a.getText().toString();
                int amount = Math.round(Float.parseFloat(samount) * 100);
               if(samount.equals("41000")){
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


        Random random = new Random();
        int val = random.nextInt(1000000000);
        String val2 = Integer.toString(val);


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
             //   unicid = c_flag.getText().toString();
                uplodpayment(name, email, mobileno, branch, _class,samount3,val2);
            }

            private void uplodpayment(String name, String email, String mobileno, String branch, String _class,String amount,String va) {
//                String txt_installment = pay_instllmen.getSelectedItem().toString();
//                String cc = totlef.getText().toString().replaceAll("[^0-9]", "");
//                int Student_totalfees = Integer.parseInt(cc);
//                int Student_currentpay = Integer.parseInt(samount);
//                int remain_fees = Student_totalfees - Student_currentpay;


               // String remainfeea = Integer.toString(remain_fees);



                DocumentReference reference = fstore.collection("Final_paymnet_data").document(va);
                Map<String, String> v = new HashMap<>();
                //v.put("unicid_assignno", unicid);
                v.put("Name", name);
                v.put("mobile_no", mobileno);
                v.put("Email", email);
                v.put("branch", branch);
                v.put("_class", _class);
                v.put("Section", "Hostel");
               v.put("paidamount", amount);
                v.put("paymentid", va);
                v.put("remaining_fees","0");
                reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Payment_hostel.this, " tracnsaction Successfully ", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });




        // Intent intent=new Intent(Payment_college_pay_page.this, Payment_Collage_invoice.class);

        intent.putExtra("orignalamount3",amount3);
        intent.putExtra("amo3",samount3);
intent.putExtra("transactionid",val2);

        startActivity(intent);
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}