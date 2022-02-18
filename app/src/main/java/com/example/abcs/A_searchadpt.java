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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class A_searchadpt extends RecyclerView.Adapter<A_searchadpt.myviewholder>
{
    ArrayList<a_search_data> datalist;
    public A_searchadpt(ArrayList<a_search_data> datalist) {
        this.datalist = datalist;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_search_,parent,false);
        return new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(datalist.get(position).get_1Student_class());
        holder.t2.setText(datalist.get(position).get_1Student_dept());
        holder.t3.setText(datalist.get(position).get_1Student_invoiceno());
        holder.t6.setText(datalist.get(position).get_1Student_payed_amount());
        holder.rollno.setText(datalist.get(position).get_1Student_roll_no());
        holder.remain_.setText(datalist.get(position).get_1Student_remain_fees());
        holder.name.setText(datalist.get(position).get_1Student_name());
    }
    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView t1,t2,t3,t6,t,name,rollno, remain_;
        FirebaseFirestore fstore;
        TextView permision_Status;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t6=itemView.findViewById(R.id.t6);
            t=itemView.findViewById(R.id.t);
            name=itemView.findViewById(R.id.tv_arol);
            rollno=itemView.findViewById(R.id.tv_de);
            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            remain_=itemView.findViewById(R.id.tv_remainpay211);
            String permision_Status1;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    DocumentReference reference = fstore.collection("_1Student_remain_fees").document(t2.getText().toString());
                    reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            //basic profile things
                            String pr_name= documentSnapshot.getString("_1Student_class");
                            String pr_email=documentSnapshot.getString("_1Student_dept");
                            String pr_comments=documentSnapshot.getString("_1Student_invoiceno");
                            String pr_section=documentSnapshot.getString("_1Student_name");
                            String pro_level=documentSnapshot.getString("_1Student_payed_amount");
                            String pro_status=documentSnapshot.getString("status");
                        }
                    });
                }
            }, 100);
        }
        private void uplod_permision_status_fail(TextView t1, TextView t2, TextView t3, TextView t, TextView t6) {
            String txtt1=t1.getText().toString();
            String txtt2=t2.getText().toString();
            String txtt3=t3.getText().toString();
            String txtt=t.getText().toString();
            String txtt6=t6.getText().toString();
            DocumentReference reference = fstore.collection("final_permision_status").document(txtt2);
            Map<String, String> v = new HashMap<>();
            v.put("Name", txtt1);
            v.put("Email", txtt2);
            v.put("Comments", txtt);
            v.put("Section", txtt6);
            v.put("Level", txtt3);
            v.put("status","NOT granted");
            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
//                    b1p.setVisibility(View.INVISIBLE);
//                    b2f.setVisibility(View.INVISIBLE);
                    permision_Status.setText("Permission NOT granted ");
                }
            });
        }
        private void uplod_permision_status_grant(TextView t1, TextView t2, TextView t3, TextView t, TextView t6) {
            String txtt1=t1.getText().toString();
            String txtt2=t2.getText().toString();
            String txtt3=t3.getText().toString();
            String txtt=t.getText().toString();
            String txtt6=t6.getText().toString();
            DocumentReference reference = fstore.collection("final_permision_status").document(t2.getText().toString());
            Map<String, String> v = new HashMap<>();
            v.put("Name", txtt1);
            v.put("Email", txtt2);
            v.put("Comments", txtt);
            v.put("Section", txtt6);
            v.put("Level", txtt3);
            v.put("status","granted");
            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    permision_Status.setText("Permission granted ");
                }
            });
        }
    }
}