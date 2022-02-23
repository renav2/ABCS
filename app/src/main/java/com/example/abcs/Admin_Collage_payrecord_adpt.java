package com.example.abcs;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Admin_Collage_payrecord_adpt extends RecyclerView.Adapter<Admin_Collage_payrecord_adpt.myviewholder>
{
    ArrayList<Admin_Collage_payrecord_data> datalist;
    public Admin_Collage_payrecord_adpt(ArrayList<Admin_Collage_payrecord_data> datalist) {
        this.datalist = datalist;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.clg_payment_record_single_line,parent,false);
        return new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        try{

            holder.t1.setText(datalist.get(position).get_class());
            holder.t2.setText(datalist.get(position).getBranch());
            holder.t3.setText(datalist.get(position).getPaymentid());
            holder.t6.setText(datalist.get(position).getPaidamount());
            holder.remainpay.setText(datalist.get(position).getRemaining_fees());
            holder.installment.setText(datalist.get(position).getInstallment());
            holder.name.setText(datalist.get(position).getName());
            holder.assignno.setText(datalist.get(position).getUnicid_assignno());

        }catch (Exception e){

        }


    }
    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView t1,t2,t3,t6,t,name,rollno,remainpay,installment,assignno;
        FirebaseFirestore fstore;
        TextView permision_Status;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.year);
            t2=itemView.findViewById(R.id.dept);
            t3=itemView.findViewById(R.id.t3);
            t6=itemView.findViewById(R.id.t6);
            name=itemView.findViewById(R.id.installment);
            remainpay=itemView.findViewById(R.id.remainpay__);
            installment=itemView.findViewById(R.id.deptaaaaa);
            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            assignno=itemView.findViewById(R.id.assignno);



        }

    }
}
