package com.example.abcs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

public class Support_pay extends AppCompatActivity implements PaymentResultWithDataListener {
    String samount;
    EditText et1,enteramount;
    Button sub,paybutton;
    FirebaseFirestore fstore;
    FirebaseAuth auth;
    String name,email,unicid,branch,_class,aaaaa;
    Spinner installments;

TextView vvasdaas,chutya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_pay);

            et1=findViewById(R.id.editTextTextMultiLine5);
            enteramount=findViewById(R.id.editTextTextPersonName);
            sub=findViewById(R.id.button18);
            fstore=FirebaseFirestore.getInstance();
            auth=FirebaseAuth.getInstance();
            paybutton=findViewById(R.id.button32);
            installments=findViewById(R.id.pay_in2);

            vvasdaas=findViewById(R.id.l12);
chutya=findViewById(R.id.textView77);
            installments.setVisibility(View.INVISIBLE);
            enteramount.setVisibility(View.INVISIBLE);
            paybutton.setVisibility(View.INVISIBLE);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        }, 1000);








        paybutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
             samount=enteramount.getText().toString();
                    int amount = Math.round(Float.parseFloat(samount) * 100);
                    makepay(amount);
                }
            });

        DocumentReference documentReference=fstore.collection("demo").document(auth.getCurrentUser().getUid());
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                String s,s1;

                name=value.getString("Name");
                email=value.getString("Email");
               // unicid=value.getString("assignno");
                branch =value.getString("Branch");
                _class=value.getString("Class");


                vvasdaas.setText(value.getString("assignno"));

              //  vv.setText(unicid);

            }
        });

        //taking teacher side responce


//        fstore.collection("Support_payment_issue").whereEqualTo("assignno",vvasdaas.getText().toString()).get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot d:list)
//                        {
//
//                            chutya.setText(d.getString("game"));
////                            a_search_data obj=d.toObject(a_search_data.class);
////                            datalist.add(obj);
//                        }
//
//                    }
//                });


//        DocumentReference pp=fstore.collection("Support_payment_issue").document(vvasdaas.getText().toString());
//        pp.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                String s;
//
//                chutya.setText(value.getString("game"));
//                //  vv.setText(unicid);
//
//            }
//        });




//uplod data on new data set

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference d2=fstore.collection("Support_payment_issue").document(vvasdaas.getText().toString());
                Map<String, String> vv=new HashMap<>();
String gg=vvasdaas.getText().toString();
                String no="no";
                vv.put("Name",name);
                vv.put("game","no");
                vv.put("assignno",gg);
                vv.put("Email",email);
                vv.put("Branch",branch);
                vv.put("_Class",_class);
                vv.put("student_issue",et1.getText().toString());



                d2.set(vv).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Support_pay.this, "Your request is send  ", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(Support_pay.this,MainActivity.class);
                        startActivity(intent);
                    }
                });


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
        Intent intent =new Intent(Support_pay.this, Payment_Collage_invoice.class);

        int amount = Math.round(Float.parseFloat(samount) * 100);
        Toast.makeText(this, "paymentsuccesfull", Toast.LENGTH_SHORT).show();

        DocumentReference d3=fstore.collection("financial_problem_student_paymentdata").document();
        Map<String, String> vv=new HashMap<>();

        vv.put("Name",name);
        vv.put("assignno",unicid);
        vv.put("Email",email);
        vv.put("Branch",branch);
        vv.put("Class",_class);
        vv.put("installemt",installments.getSelectedItem().toString());
        vv.put("amountpaid",samount);


        d3.set(vv).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Support_pay.this, "Your request is send  ", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(Support_pay.this,MainActivity.class);
                startActivity(intent);
            }
        });




//        String txt_installment=pay_instllmen.getSelectedItem().toString();
//
//        String cc=totlef.getText().toString().replaceAll("[^0-9]", "");
//        // Intent intent=new Intent(Payment_college_pay_page.this, Payment_Collage_invoice.class);
//        intent.putExtra("wiseamount",cc);
//        intent.putExtra("orignalamount",amount);
//        intent.putExtra("amo",samount);
//        intent.putExtra("installmenttype",txt_installment);
//
//        startActivity(intent);

    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(this, "paymment fail ", Toast.LENGTH_SHORT).show();
    }
}