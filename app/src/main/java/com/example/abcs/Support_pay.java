package com.example.abcs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
import java.util.Random;

public class Support_pay extends AppCompatActivity implements PaymentResultWithDataListener {

    EditText et1,enteramount;
    Button sub,paybutton;
    FirebaseFirestore fstore;
    FirebaseAuth auth;
    String name,email,unicid,branch,_class,aaaaa;
    Spinner installments;
TextView m,n,b,v,c;
//TextView aaaa;

   //installemets
    String samount;
    String thramo;
    String four;
    TextView f,s,t,fo;
    TextView a1,a2,a3,a4;
    TextView vvasdaas,chutya,gul;
    String pp;
TextView af2,af3;


TextView ttl;


    String l,p,i,c1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_pay);
       // aaaa=findViewById(R.id.textView4);


            af2=findViewById(R.id.atersecond);
            af3=findViewById(R.id.afterthird);
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
                ttl=findViewById(R.id.totalfees);
                a2=findViewById(R.id.amo2);
                a3=findViewById(R.id.amo3);
                a4=findViewById(R.id.amo4);


                m.setVisibility(View.INVISIBLE);
                n.setVisibility(View.INVISIBLE);
                b.setVisibility(View.INVISIBLE);
                v.setVisibility(View.INVISIBLE);
                c.setVisibility(View.INVISIBLE);
//        TextView f,s,t,fo;
//        TextView a1,a2,a3,a4;
        f.setVisibility(View.INVISIBLE);
        s.setVisibility(View.INVISIBLE);
        t.setVisibility(View.INVISIBLE);
        fo.setVisibility(View.INVISIBLE);
        a1.setVisibility(View.INVISIBLE);
        a2.setVisibility(View.INVISIBLE);
        a3.setVisibility(View.INVISIBLE);
        a4.setVisibility(View.INVISIBLE);
        af2.setVisibility(View.INVISIBLE);
        af3.setVisibility(View.INVISIBLE);
        ttl.setVisibility(View.INVISIBLE);


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
                                l=a1.getText().toString();
                                ttl.setText(d.getString("totalfees"));
                            }

                        }
                    });


            fstore.collection("financial_problem_student_paymentdata").whereEqualTo("Email",auth.getCurrentUser().getEmail()).whereEqualTo("installment","Fourth").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d:list)
                            {

                                a4.setText(d.getString("paidamount"));
                                a4.setVisibility(View.INVISIBLE);
                                p=a4.getText().toString();
                            }

                        }
                    });



            fstore.collection("financial_problem_student_paymentdata").whereEqualTo("Email",auth.getCurrentUser().getEmail()).whereEqualTo("installment","Third").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d:list)
                            {

                                a3.setText(d.getString("paidamount"));
                                i=a3.getText().toString();



                            }

                        }
                    });


            fstore.collection("financial_problem_student_paymentdata").whereEqualTo("Email",auth.getCurrentUser().getEmail()).whereEqualTo("installment","Second").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d:list)
                            {

                                a2.setText(d.getString("paidamount"));
                                c1=a2.getText().toString();

                            }

                        }
                    });












            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                                l=first
//                                p=four
//                                i=third
   //                 c1=second

                    try {

                        try{
                            //     f s t addition    a1,a2,a3,a4  paid amount,   ttl totle    ,, remain af2->after second  remain af3->3rd


                            int add1_of_1_2=  Integer.parseInt(a1.getText().toString())+Integer.parseInt(a2.getText().toString());
                            String txt1_2=Integer.toString(add1_of_1_2);
                            f.setText(txt1_2);
                         //   af2.setText(Integer.parseInt(ttl.getText().toString())-Integer.parseInt(f.getText().toString()));

                            int add1_of_1_2_3=  Integer.parseInt(a1.getText().toString())+Integer.parseInt(a2.getText().toString())+Integer.parseInt(a3.getText().toString());
                            String txt1_2_3=Integer.toString(add1_of_1_2_3);
                            s.setText(txt1_2_3);


                            int after2=Integer.parseInt(ttl.getText().toString())-Integer.parseInt(txt1_2);
                            String txtaf2=Integer.toString(after2);
                            af2.setText(txtaf2);


                            int after3=Integer.parseInt(ttl.getText().toString())-add1_of_1_2_3;
                            String txtaf3=Integer.toString(after3);
                            af3.setText(txtaf3);


                        }catch (Exception e){



                        }



                    }catch (Exception e){

                    }
                   // Toast.makeText(Support_pay.this, txt_f_s, Toast.LENGTH_SHORT).show();


                   // Toast.makeText(Support_pay.this, "plese print "+l, Toast.LENGTH_SHORT).show();
                }
            }, 1000);


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
                   // up(m,n,b,v,c);
                    fatke(pp);
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
if(installments.getSelectedItem().toString().equals("Fourth")){
    if(enteramount.getText().toString().equals(af3.getText().toString())){
        samount=enteramount.getText().toString();
        int amount = Math.round(Float.parseFloat(samount) * 100);
        makepay(amount);
    }else{
        Toast.makeText(Support_pay.this, "This is  your last installment you need to pay "+af3.getText().toString(), Toast.LENGTH_SHORT).show();
    }


}else{
    samount=enteramount.getText().toString();
    int amount = Math.round(Float.parseFloat(samount) * 100);
    makepay(amount);

}

        //        Toast.makeText(Support_pay.this, b.getText().toString(), Toast.LENGTH_SHORT).show();
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
             String    txtsam=Integer.toString(amount);
                uplodpayment(name, email, mobileno, branch, _class,txtsam);
            }

            private void uplodpayment(String name, String email, String mobileno, String branch, String _class,String amount) {
//                String txt_installment = pay_instllmen.getSelectedItem().toString();
//                String cc = totlef.getText().toString().replaceAll("[^0-9]", "");
//                int Student_totalfees = Integer.parseInt(cc);
//                int Student_currentpay = Integer.parseInt(samount);
//                int remain_fees = Student_totalfees - Student_currentpay;


                // String remainfeea = Integer.toString(remain_fees);
                Random random = new Random();
                int val = random.nextInt(1000000000);
                String val2 = Integer.toString(val);


                try{


                    DocumentReference reference = fstore.collection("financial_problem_student_paymentdata").document(val2);
                    Map<String, String> v = new HashMap<>();
                    //v.put("unicid_assignno", unicid);
                    v.put("Name", name);
                    v.put("mobile_no", mobileno);
                    v.put("Email", email);
                    v.put("branch", branch);
                    v.put("_class", _class);
                    v.put("installment",installments.getSelectedItem().toString());
                    if(installments.getSelectedItem().toString().equals("Second")){
                        v.put("secrem",af2.getText().toString());

                    }
                    if(installments.getSelectedItem().toString().equals("Third")){
                        v.put("secrem",af3.getText().toString());

                    }if(installments.getSelectedItem().toString().equals("Fourth")){
                        v.put("secrem","0");
                    }

                    v.put("Section", "supportpay");
                    v.put("paidamount", enteramount.getText().toString());
                    v.put("paymentid", val2);




                    reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Support_pay.this, "fail ho gaya vai", Toast.LENGTH_SHORT).show();
                        }
                    });


                }catch (Exception e){}


                Toast.makeText(Support_pay.this, "", Toast.LENGTH_SHORT).show();


            }
        });





    }
    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(this, "paymment fail ", Toast.LENGTH_SHORT).show();
    }
}