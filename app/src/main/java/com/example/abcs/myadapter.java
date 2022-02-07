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


public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{





    ArrayList<model> datalist;

    public myadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(datalist.get(position).getName());
        holder.t2.setText(datalist.get(position).getEmail());
     holder.t3.setText(datalist.get(position).getLevel());
       holder.t6.setText(datalist.get(position).getSection());
        holder.t.setText(datalist.get(position).getComments());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView t1,t2,t3,t6,t;
        Button b1p,b2f;
        FirebaseFirestore fstore;
        TextView permision_Status;



        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t6=itemView.findViewById(R.id.t6);
            t=itemView.findViewById(R.id.t);
            b1p=itemView.findViewById(R.id.btn_pass);
            b2f=itemView.findViewById(R.id.btn_fail);
            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            String permision_Status1;





            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    DocumentReference reference = fstore.collection("final_permision_status").document(t2.getText().toString());
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
                            permision_Status.setText(pro_status);
                            String sta1=permision_Status.getText().toString();
                           /// his
                            if(sta1.equals("granted")){
                                b1p.setVisibility(View.INVISIBLE);
                                b2f.setVisibility(View.INVISIBLE);
                            }else if(sta1.equals("NOT granted")){
                                b1p.setVisibility(View.INVISIBLE);
                                b2f.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }, 100);
            b1p.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uplod_permision_status_grant(t1,t2,t3,t,t6);
                }
            });
            b2f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uplod_permision_status_fail(t1,t2,t3,t,t6);
                }
            });
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
                    b1p.setVisibility(View.INVISIBLE);
                    b2f.setVisibility(View.INVISIBLE);
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
                    // Toast.makeText(test_user_permision_ask.this, "yor req is recorde", Toast.LENGTH_SHORT).show();
                    b1p.setVisibility(View.INVISIBLE);
                    b2f.setVisibility(View.INVISIBLE);
                    permision_Status.setText("Permission granted ");

                }
            });

        }
    }
}
