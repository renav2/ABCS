package com.example.abcs;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PaymentAdpt extends RecyclerView.Adapter<PaymentAdpt.myviewholder> {
    ArrayList<PaymentData> datalist;
    FirebaseFirestore fstore;



    public PaymentAdpt(ArrayList<PaymentData> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paymentdata_singlerow, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.e1.setText(datalist.get(position).getName());
        holder.e2.setText(datalist.get(position).getEmail());
        holder.e3.setText(datalist.get(position).getSection());
        holder.e4.setText(datalist.get(position).getPaymentid());
        holder.e5.setText(datalist.get(position).getPaidamount());
        holder.e6.setText(datalist.get(position).getRemaning_fee());
        holder.e7.setText(datalist.get(position).getUnicid_assignno());


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        // add here
        TextView e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11;
        // Button b1p,b2f;
        Button delete;
        FirebaseFirestore fstore;
        TextView permision_Status;


        public myviewholder(@NonNull View itemView) {
            super(itemView);

            e1 = itemView.findViewById(R.id.t1);
            e2 = itemView.findViewById(R.id.u3);
            e3 = itemView.findViewById(R.id.u4);
            e4 = itemView.findViewById(R.id.u5);
            e5 = itemView.findViewById(R.id.u6);
            e6 = itemView.findViewById(R.id.u7);
            e7 = itemView.findViewById(R.id.u1);



            //delete=itemView.findViewById(R.id.btn_fail);
            fstore=FirebaseFirestore.getInstance();


//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //delete user
//                    fstore.collection("demo").document("4J17vMShwsYYFBTQbJpoEIc8Wvd2")
//                            .delete()
//                            .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//
//                                }
//                            })
//                            .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//
//                                }
//                            });
//                }
//            });




//
////for status
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    DocumentReference reference = fstore.collection("final_permision_status").document();
//                    reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            //basic profile things
//                            String pr_name= documentSnapshot.getString("Name");
//                            String pr_email=documentSnapshot.getString("Email");
//                            String pr_comments=documentSnapshot.getString("Comments");
//                            String pr_section=documentSnapshot.getString("Section");
//                            String pro_level=documentSnapshot.getString("Level");
//                            String pro_status=documentSnapshot.getString("status");
////                            permision_Status.setText("NOT granted");
//                            String sta1=permision_Status.getText().toString();
//                            /// his
//                            if(sta1.equals("granted")){
//
//                            }else if(sta1.equals("NOT granted")){
//
//                            }
//                        }
//                    });
//                }
//            }, 100);
////            b1p.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    uplod_permision_status_grant(t1,t2,t3,t,t6,id);
////                }
////            });
////            b2f.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    uplod_permision_status_fail(t1,t2,t3,t,t6,id);
////                }
////            });
//        }
//        private void uplod_permision_status_fail(TextView t1, TextView t2, TextView t3, TextView t, TextView t6,TextView id) {
//            String txtt1=t1.getText().toString();
//            String txtt2=t2.getText().toString();
//            String txtt3=t3.getText().toString();
//            String txtt=t.getText().toString();
//            String txtt6=t6.getText().toString();
//            String txid=id.getText().toString();
//
//
//            DocumentReference reference = fstore.collection("final_permision_status").document();
//            Map<String, String> v = new HashMap<>();
//            v.put("Name", txtt1);
//            v.put("Email", txtt2);
//            v.put("Comments", txtt);
//            v.put("Section", txtt6);
//            v.put("Level", txtt3);
//            v.put("perid", txid);
//            v.put("status","NOT granted");
//
//
//
//
//            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void unused) {
//
//                    permision_Status.setText("Permission NOT granted ");
//                }
//            });
//
//
//        }
//        private void uplod_permision_status_grant(TextView t1, TextView t2, TextView t3, TextView t, TextView t6,TextView id) {
//            String txtt1=t1.getText().toString();
//            String txtt2=t2.getText().toString();
//            String txtt3=t3.getText().toString();
//            String txtt=t.getText().toString();
//            String txtt6=t6.getText().toString();
//            String txid=id.getText().toString();
//            DocumentReference reference = fstore.collection("final_permision_status").document();
//            Map<String, String> v = new HashMap<>();
//            v.put("Name", txtt1);
//            v.put("Email", txtt2);
//            v.put("Comments", txtt);
//            v.put("Section", txtt6);
//            v.put("Level", txtt3);
//            v.put("status","granted");
//            v.put("perid", txid);
//
//
//
//            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void unused) {
//                    // Toast.makeText(test_user_permision_ask.this, "yor req is recorde", Toast.LENGTH_SHORT).show();
//
//                    permision_Status.setText("Permission granted ");
//
//                }
//            });
//
//        }


        }
    }
}