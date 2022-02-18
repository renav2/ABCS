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

public class A_exam_adpt extends RecyclerView.Adapter<A_exam_adpt.myviewholder>
{
    ArrayList<A_exam_data> datalist;
    public A_exam_adpt(ArrayList<A_exam_data> datalist) {
        this.datalist = datalist;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_exampay_singleline,parent,false);
        return new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(datalist.get(position).get_1Student_class());
        holder.t2.setText(datalist.get(position).get_1Student_dept());
        holder.t3.setText(datalist.get(position).get_1Student_invoiceno());
        holder.t6.setText(datalist.get(position).get_1Student_payed_amount());
        holder.rollno.setText(datalist.get(position).get_1Student_roll_no());
//        holder.t.setText(datalist.get(position).get_1Student_remain_fees());
        holder.name.setText(datalist.get(position).get_1Student_name());

        holder.examform.setText(datalist.get(position).get_1Student_formno());
        holder.backlog.setText(datalist.get(position).get_1Student_back_formno());
    }
    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView t1,t2,t3,t6,t,name,rollno,examform,backlog;
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
           examform=itemView.findViewById(R.id.tv_ad_examformno);
            backlog=itemView.findViewById(R.id.tv_ad_backlog);


            String permision_Status1;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    DocumentReference reference = fstore.collection("Exam_fees_data").document(t2.getText().toString());
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

    }
}
