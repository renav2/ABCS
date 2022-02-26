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
public class A_hos_adpt extends RecyclerView.Adapter<A_hos_adpt.myviewholder>
{
    ArrayList<A_hos_data> datalist;
    public A_hos_adpt(ArrayList<A_hos_data> datalist) {
        this.datalist = datalist;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.hostelrecod_singlerow,parent,false);
        return new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(datalist.get(position).get_class());
        holder.t2.setText(datalist.get(position).getBranch());
        holder.t3.setText(datalist.get(position).getPaymentid());
        holder.t6.setText(datalist.get(position).getPaidamount());

        holder.rollno.setText(datalist.get(position).getUnicid_assignno());
        holder.name.setText(datalist.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView t1,t2,t3,t6,t,name,rollno;
        FirebaseFirestore fstore;
        TextView permision_Status;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.year);
            t2=itemView.findViewById(R.id.dept);
            t3=itemView.findViewById(R.id.t3);
            t6=itemView.findViewById(R.id.t6);
            t=itemView.findViewById(R.id.t);
            name=itemView.findViewById(R.id.installment);
            rollno=itemView.findViewById(R.id.deptaaaaa);
            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            String permision_Status1;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    DocumentReference reference = fstore.collection("collagefees_2_installment").document(t2.getText().toString());
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
