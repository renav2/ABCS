package com.example.abcs;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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


public class up_adpt extends RecyclerView.Adapter<up_adpt.myviewholder>
{





    ArrayList<up_model> datalist;

    public up_adpt(ArrayList<up_model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_userviserper,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(datalist.get(position).getName());
        holder.t2.setText(datalist.get(position).getEmail());
        holder.t3.setText(datalist.get(position).getLevel());
        holder.t6.setText(datalist.get(position).getSection());
        holder.t.setText(datalist.get(position).getComments());
        holder.id.setText(datalist.get(position).getPermissionid());
        holder.permision_Status.setText(datalist.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView t1,t2,t3,t6,t,id;
       // Button b1p,b2f;
        FirebaseFirestore fstore;
        TextView permision_Status;



        public myviewholder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.textView57);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t6=itemView.findViewById(R.id.t6);
            t=itemView.findViewById(R.id.t);

            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            String permision_Status1;





//for status
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    DocumentReference reference = fstore.collection("final_permision_status").document();
                    reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            //basic profile things
                            String pr_name= documentSnapshot.getString("Name");
                            String pr_email=documentSnapshot.getString("Email");
                            String pr_comments=documentSnapshot.getString("Comments");
                            String pr_section=documentSnapshot.getString("Section");
                            String pro_level=documentSnapshot.getString("Level");
                            String pro_status=documentSnapshot.getString("status");
//                            permision_Status.setText("NOT granted");
                            String sta1=permision_Status.getText().toString();
                            /// his
                            if(sta1.equals("granted")){

                            }else if(sta1.equals("NOT granted")){

                            }
                        }
                    });
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
