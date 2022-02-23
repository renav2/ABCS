//package com.example.abcs;
//
//public class suport_adpt {
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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class suport_adpt extends RecyclerView.Adapter<suport_adpt.myviewholder>
{

    ArrayList<suport_data> datalist;

    public suport_adpt(ArrayList<suport_data> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.supportpay_single_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
//       try{
           holder.name.setText(datalist.get(position).getName());
//        holder.t2.setText(datalist.get(position).getName());
       //    holder.paymentid.setText(datalist.get(position).getPaymentid());
           holder.amount.setText(datalist.get(position).getPaidamount());
           holder.installmentsno.setText(datalist.get(position).getInstallment());
           holder.dept.setText(datalist.get(position).getBranch());
           holder.year.setText(datalist.get(position).get_class());
        holder.remainpay.setText(datalist.get(position).getSecrem());
   //     holder.paymentid.setText(datalist.get(position).getPaymentid());
//       }catch (Exception e){}


//        holder.t.setText(datalist.get(position).getComments());
//        holder.id.setText(datalist.get(position).getPermissionid());
//        holder.permision_Status.setText(datalist.get(position).getStatus());
//        holder.techercomm.setText(datalist.get(position).getTechersidecomment());

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


//            id=itemView.findViewById(R.id.textView57);
//            t1=itemView.findViewById(R.id.year);
//            t2=itemView.findViewById(R.id.dept);
//            t3=itemView.findViewById(R.id.t3);
//            t6=itemView.findViewById(R.id.t6);
//
//            t=itemView.findViewById(R.id.t);
//            techercomm=itemView.findViewById(R.id.tech_comments);
            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            String permision_Status1;




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
