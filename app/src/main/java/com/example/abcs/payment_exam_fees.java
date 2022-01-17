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

public class payment_exam_fees extends AppCompatActivity  implements PaymentResultWithDataListener {
private Button btn_exampay;
private EditText txt_examamount;
    TextView ex_name,ex_class,ex_branch,ex_rollno,ex_status;
    EditText ex_prn,ex_form;

    FirebaseAuth auth;
    String invo_userid;
    FirebaseFirestore fstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_exam_fees);

        btn_exampay=findViewById(R.id.btn_examfees);
        txt_examamount=findViewById(R.id.txt_examamount);
        ex_name =findViewById(R.id.tv_examname);
        ex_class  =findViewById(R.id.tv_exam_class);
        ex_branch  =findViewById(R.id.tv_exam_branch);
        ex_rollno  =findViewById(R.id.tv_exam_rollno);
        ex_status  =findViewById(R.id.tv_exam_feestatus);
        ex_prn  =findViewById(R.id.et_exam_prn);
        ex_form =findViewById(R.id.et_exam_formno);
        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        invo_userid=auth.getCurrentUser().getUid();


        DocumentReference reference = fstore.collection("demo").document(invo_userid);
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //basic profile things
                String pro_name= documentSnapshot.getString("Name");
                String pro_rollno=documentSnapshot.getString("Rollno");
                String pro_dept=documentSnapshot.getString("Branch");
                String pro_class=documentSnapshot.getString("Class");
                String pro_phone=documentSnapshot.getString("mobile no");

                //setdata
                ex_name.setText(pro_name);
                ex_rollno.setText(pro_rollno);
                ex_branch.setText(pro_dept);
                ex_class.setText(pro_class);

            }
        });
        DocumentReference reference2 = fstore.collection("collagefees_1_installment").document(invo_userid);
        reference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //basic profile things
                String pro_name= documentSnapshot.getString("fag");

                //setdata
                ex_status.setText(pro_name);


            }
        });


        btn_exampay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eamount=txt_examamount.getText().toString();
                int amount = Math.round(Float.parseFloat(eamount) * 100);

                if(ex_status.getText().toString().equals("NOT Eligible")){
                    Toast.makeText(payment_exam_fees.this, "You need to pay at least half college fee  ", Toast.LENGTH_LONG).show();
            }else{
                    makepay(amount);
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
        String samount=txt_examamount.getText().toString();
        int amount = Math.round(Float.parseFloat(samount) * 100);
String tx_pr=ex_prn.getText().toString();
String tx_forno=ex_form.getText().toString();


       // String cc=totlef.getText().toString().replaceAll("[^0-9]", "");
        Intent intent=new Intent(payment_exam_fees.this, Payment_examfees_invoice.class);

        intent.putExtra("examamountint",amount);
        intent.putExtra("examamount",samount);
        intent.putExtra("examprn",tx_pr);
        intent.putExtra("exform",tx_forno);

        startActivity(intent);
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }
}