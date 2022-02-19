package com.example.abcs;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class zero_pay_adpt extends RecyclerView.Adapter<zero_pay_adpt.myviewholder>
{
    Context context;
String aa;

    public zero_pay_adpt(Context context) {
        this.context = context;
    }



    ArrayList<zero_pay_data> datalist;
    public zero_pay_adpt(ArrayList<zero_pay_data> datalist) {
        this.datalist = datalist;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.zero_pay_single_row,parent,false);
        return new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        try{

//            t1=itemView.findViewById(R.id.year);
//            t2=itemView.findViewById(R.id.dept);
//            name=itemView.findViewById(R.id.name);
//            installment=itemView.findViewById(R.id.mobile);
//            fstore=FirebaseFirestore.getInstance();
//            assignno=itemView.findViewById(R.id.assignno);
//            callnow=itemView.findViewById(R.id.button10);


            holder.t1.setText(datalist.get(position).get_Class());
            holder.t2.setText(datalist.get(position).getBranch());
            holder.mobileno.setText(datalist.get(position).getMobile_no());
            holder.name.setText(datalist.get(position).getName());
            holder.assignno.setText(datalist.get(position).getAssignno());
            aa=holder.mobileno.getText().toString();
            holder.callnow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), aa, Toast.LENGTH_SHORT).show();
                    Intent call = new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:"+aa));  //String phone
                    v.getContext().startActivity(call);

                }
            });


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
        TextView t1,t2,t3,t6,t,name,rollno,remainpay,mobileno,assignno;
        Button callnow;

  

        FirebaseFirestore fstore;
        TextView permision_Status;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.year);
            t2=itemView.findViewById(R.id.dept);
            name=itemView.findViewById(R.id.name);
            mobileno=itemView.findViewById(R.id.mobile);
            fstore=FirebaseFirestore.getInstance();
            assignno=itemView.findViewById(R.id.assignno);
            callnow=itemView.findViewById(R.id.button10);



//            callnow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
////                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
////                    callIntent.setData(Uri.parse("123231"));
////                    context.startActivity(callIntent);
////                    String phoneNumber = mobileno.getText().toString();
////                    String uri = phoneNumber.trim();
////                    Uri call = Uri.parse("tel:" + uri);
////
////                   Intent intent = new Intent(Intent.ACTION_CALL);
////                    intent.setData(call);
////                    context.startActivity(intent);
//
//
//
//         
//
//
//                }
//            });

        }

    }

    
}
