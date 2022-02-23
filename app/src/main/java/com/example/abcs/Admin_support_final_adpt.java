package com.example.abcs;

//public class Admin_support_final_adpt {
//}



import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Admin_support_final_adpt extends RecyclerView.Adapter<Admin_support_final_adpt.myviewholder>
{

    ArrayList<Admin_support_final_data> datalist;

    public Admin_support_final_adpt(ArrayList<Admin_support_final_data> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.supportpay_singlerow_adminside,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
//       try{
        holder.name.setText(datalist.get(position).getName());
        holder.amount.setText(datalist.get(position).getPaidamount());
        holder.installmentsno.setText(datalist.get(position).getInstallment());
        holder.dept.setText(datalist.get(position).getBranch());
        holder.year.setText(datalist.get(position).get_class());
        holder.remainpay.setText(datalist.get(position).getSecrem());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
//        TextView t1,t2,t3,t6,t,id,techercomm;

        TextView invoice,name,amount,paymentid,dept,remainpay,installmentsno,year;

        // Button b1p,b2f;
        FirebaseFirestore fstore;
        TextView permision_Status;



        public myviewholder(@NonNull View itemView) {
            super(itemView);
            year=itemView.findViewById(R.id.year);
            name=itemView.findViewById(R.id.dept);
            amount=itemView.findViewById(R.id.t6);
            paymentid=itemView.findViewById(R.id.t3);
            dept=itemView.findViewById(R.id.deptaaaaa);
            remainpay=itemView.findViewById(R.id.remainpay__);
            installmentsno=itemView.findViewById(R.id.installment);



            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            String permision_Status1;




        }

    }
}
