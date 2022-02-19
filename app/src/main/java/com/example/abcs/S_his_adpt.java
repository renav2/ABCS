//package com.example.abcs;
//
//public class S_his_adpt {
//
//
//}
package com.example.abcs;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class S_his_adpt extends RecyclerView.Adapter<S_his_adpt.myviewholder>
{





    ArrayList<S_his_data> datalist;

    public S_his_adpt(ArrayList<S_his_data> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.student_payment_history_singleline,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(datalist.get(position).getSection());
        holder.section.setText(datalist.get(position).getName());
        holder.t3.setText(datalist.get(position).getPaymentid());
        holder.t6.setText(datalist.get(position).getPaidamount());
        holder.rem.setText(datalist.get(position).getRemaining_fees());
        holder.dep.setText(datalist.get(position).getBranch());
        holder.roll.setText(datalist.get(position).getInstallment());
    //    holder.roll.setText(datalist.get(position).get);


       // holder.t.setText(datalist.get(position).get_class());

       // holder.id.setText(datalist.get(position).getBranch());
     //   holder.permision_Status.setText(datalist.get(position));
       // holder.techercomm.setText(datalist.get(position).getTechersidecomment());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView t1,section,t3,t6,t,id,techercomm,rem,dep,roll;
        // Button b1p,b2f;
        FirebaseFirestore fstore;
        TextView permision_Status;
        View instalment;




        public myviewholder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.textView57);
            t1=itemView.findViewById(R.id.year);
            section=itemView.findViewById(R.id.dept);
            t3=itemView.findViewById(R.id.t3);
            t6=itemView.findViewById(R.id.t6);
            t=itemView.findViewById(R.id.t);
instalment=itemView.findViewById(R.id.ins);

            rem=itemView.findViewById(R.id.tv_remainpay211);
            dep=itemView.findViewById(R.id.mobile);
            roll=itemView.findViewById(R.id.name);


            techercomm=itemView.findViewById(R.id.tech_comments);
            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            String permision_Status1;




//for status
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                }
            }, 100);
//            b1p.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    uplod_permision_status_grant(t1,t2,t3,t,t6,id);
//                }
//            });
//            b2f.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    uplod_permision_status_fail(t1,t2,t3,t,t6,id);
//                }
//            });
        }
        private void uplod_permision_status_fail(TextView t1, TextView t2, TextView t3, TextView t, TextView t6,TextView id) {
            String txtt1=t1.getText().toString();
            String txtt2=t2.getText().toString();
            String txtt3=t3.getText().toString();
            String txtt=t.getText().toString();
            String txtt6=t6.getText().toString();
            String txid=id.getText().toString();


            DocumentReference reference = fstore.collection("final_permision_status").document();
            Map<String, String> v = new HashMap<>();
            v.put("Name", txtt1);
            v.put("Email", txtt2);
            v.put("Comments", txtt);
            v.put("Section", txtt6);
            v.put("Level", txtt3);
            v.put("perid", txid);
            v.put("status","NOT granted");




            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                    permision_Status.setText("Permission NOT granted ");
                }
            });


        }
        private void uplod_permision_status_grant(TextView t1, TextView t2, TextView t3, TextView t, TextView t6,TextView id) {
            String txtt1=t1.getText().toString();
            String txtt2=t2.getText().toString();
            String txtt3=t3.getText().toString();
            String txtt=t.getText().toString();
            String txtt6=t6.getText().toString();
            String txid=id.getText().toString();
            DocumentReference reference = fstore.collection("final_permision_status").document();
            Map<String, String> v = new HashMap<>();
            v.put("Name", txtt1);
            v.put("Email", txtt2);
            v.put("Comments", txtt);
            v.put("Section", txtt6);
            v.put("Level", txtt3);
            v.put("status","granted");
            v.put("perid", txid);



            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    // Toast.makeText(test_user_permision_ask.this, "yor req is recorde", Toast.LENGTH_SHORT).show();

                    permision_Status.setText("Permission granted ");

                }
            });

        }
    }
}
