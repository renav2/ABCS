package com.example.abcs;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnFailureListener;
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

    EditText et1,enteramount;
    Button sub,paybutton;
    FirebaseFirestore fstore;
    FirebaseAuth auth;
    String name,email,unicid,branch,_class,aaaaa;
    Spinner installments;
TextView m,n,b,v,c;

   //installemets
    String samount;
    String thramo;
    String four;
    TextView f,s,t,fo;
    TextView a1,a2,a3,a4;
    TextView vvasdaas,chutya,gul;
    String pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_pay);
                m=findViewById(R.id.m);
                n=findViewById(R.id.n);
                b=findViewById(R.id.b);
                v=findViewById(R.id.v);
                c=findViewById(R.id.c);
                f=findViewById(R.id.insta1);
                s=findViewById(R.id.insta2);
                t=findViewById(R.id.insta3);
                fo=findViewById(R.id.insta4);
                a1=findViewById(R.id.amo1);
                a2=findViewById(R.id.amo2);
                a3=findViewById(R.id.amo3);
                a4=findViewById(R.id.amo4);
                m.setVisibility(View.INVISIBLE);
                n.setVisibility(View.INVISIBLE);
                b.setVisibility(View.INVISIBLE);
                v.setVisibility(View.INVISIBLE);
                c.setVisibility(View.INVISIBLE);
                et1=findViewById(R.id.editTextTextMultiLine5);
                enteramount=findViewById(R.id.editTextTextPersonName);
                sub=findViewById(R.id.button18);
                fstore=FirebaseFirestore.getInstance();
                auth=FirebaseAuth.getInstance();
                paybutton=findViewById(R.id.button32);
                installments=findViewById(R.id.pay_in2);
                vvasdaas=findViewById(R.id.l12);
                chutya=findViewById(R.id.textView77);
                gul=findViewById(R.id.textView133);
                //support
                installments.setVisibility(View.INVISIBLE);
                enteramount.setVisibility(View.INVISIBLE);
                paybutton.setVisibility(View.INVISIBLE);
                chutya.setVisibility(View.INVISIBLE);
                vvasdaas.setVisibility(View.INVISIBLE);
//BASIC HANDLER

        try{
//data for  1st  installment
            fstore.collection("Final_paymnet_data").whereEqualTo("Email",auth.getCurrentUser().getEmail()).whereEqualTo("installment","First").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d:list)
                            {
                                f.setText(d.getString("installment"));
                                a1.setText(d.getString("paidamount"));
                            }

                        }
                    });


            DocumentReference documentReference=fstore.collection("demo").document(auth.getCurrentUser().getUid());
            documentReference.addSnapshotListener(Support_pay.this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                    String s,s1;
                    name=value.getString("Name");
                    email=value.getString("Email");
                    branch =value.getString("Branch");
                    _class=value.getString("_Class");
                    vvasdaas.setText(value.getString("assignno"));
                    pp=vvasdaas.getText().toString();
                    m.setText(name);
                    n.setText(email);
                    b.setText(branch);
                    v.setText(_class);
                    c.setText(pp);
                    up(m,n,b,v,c);
                    fatke(pp);
                }

                private void up(TextView m, TextView n, TextView b, TextView v, TextView c) {
                    DocumentReference d3=fstore.collection("financial_problem_student_paymentdata").document(auth.getCurrentUser().getUid());
                    Map<String, String> vv=new HashMap<>();
                    vv.put("Name",m.getText().toString());
                    vv.put("assignno",c.getText().toString());
                    vv.put("Email",n.getText().toString());
                    vv.put("Branch",b.getText().toString());
                    vv.put("Class",v.getText().toString());
                    vv.put("amountpaidsecond","0");
                    vv.put("amountpaythird","0");
                    vv.put("amountfour","0");
                    d3.set(vv).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Support_pay.this, "Your request is send  ", Toast.LENGTH_SHORT).show();

                        }
                    });

                }

                private void fatke(String pp) {
                    Toast.makeText(Support_pay.this, pp, Toast.LENGTH_SHORT).show();
                    DocumentReference documentReference1= fstore.collection("Support_payment_issue").document(pp);
                    documentReference1.addSnapshotListener(Support_pay.this, new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                            String s,s1;
                            chutya.setText(value.getString("game"));
                            if (chutya.getText().toString().equals("YES")){
                                installments.setVisibility(View.VISIBLE);
                                enteramount.setVisibility(View.VISIBLE);
                                paybutton.setVisibility(View.VISIBLE);
                                sub.setVisibility(View.INVISIBLE);
                                et1.setVisibility(View.INVISIBLE);
                                vvasdaas.setVisibility(View.INVISIBLE);
                                gul.setVisibility(View.INVISIBLE);
                            }else{
                                installments.setVisibility(View.INVISIBLE);
                                enteramount.setVisibility(View.INVISIBLE);
                                paybutton.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            });
        }catch (Exception e){ Toast.makeText(Support_pay.this, "something went wrong", Toast.LENGTH_SHORT).show(); }
        paybutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        samount=enteramount.getText().toString();
                        int amount = Math.round(Float.parseFloat(samount) * 100);
                        makepay(amount);
                }
            });

//uplod data on new data set

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().equals("")) {
                    Toast.makeText(Support_pay.this, "Enter Discription ", Toast.LENGTH_SHORT).show();
                } else {
                    DocumentReference d2 = fstore.collection("Support_payment_issue").document(vvasdaas.getText().toString());
                    Map<String, String> vv = new HashMap<>();
                    String gg = vvasdaas.getText().toString();
                    String no = "no";
                    vv.put("Name", name);
                    vv.put("game", "no");
                    vv.put("assignno", gg);
                    vv.put("Email", email);
                    vv.put("Branch", branch);
                    vv.put("_Class", _class);
                    vv.put("student_issue", et1.getText().toString());
                    d2.set(vv).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Support_pay.this, "Your request is send  ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Support_pay.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
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
        Intent intent =new Intent(Support_pay.this, Payment_Collage_invoice.class);
        int amount = Math.round(Float.parseFloat(samount) * 100);
        String sec=samount;
        String thir=samount;
        String four=samount;
        if(installments.getSelectedItem().toString().equals("Second")){
            DocumentReference washingtonRef = fstore.collection("financial_problem_student_paymentdata").document(auth.getCurrentUser().getUid());
            washingtonRef
                    .update("amountpaidsecond", samount)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Support_pay.this, "Second installment payment  successful ", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
        }

         if(installments.getSelectedItem().toString().equals("Third")){
            DocumentReference washingtonRef = fstore.collection("financial_problem_student_paymentdata").document(auth.getCurrentUser().getUid());
            washingtonRef
                    .update("amountpaythird", thir)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Support_pay.this, "Third installment payment  successful ", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
        }
         if(installments.getSelectedItem().toString().equals("Fourth")){
            DocumentReference washingtonRef = fstore.collection("financial_problem_student_paymentdata").document(auth.getCurrentUser().getUid());
            washingtonRef
                    .update("amountfour", four)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Support_pay.this, "Fourth installment payment  successful ", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
        }
    }
    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(this, "paymment fail ", Toast.LENGTH_SHORT).show();
    }
}