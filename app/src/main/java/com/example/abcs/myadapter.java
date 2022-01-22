package com.example.abcs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
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
            b1p.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uplodpass(t1,t2);
                }

            });
            b2f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uplodfail(t1,t2);

                }
            });



        }

        private void uplodfail(TextView t1, TextView t2) {
            String user_name=t1.getText().toString();
            String user_email=t2.getText().toString();
            String grant="not granted";
            DocumentReference reference = fstore.collection("permision  not grantde").document(user_email);
            Map<String, String> v = new HashMap<>();
            v.put("name11",user_name);
            v.put("email11",user_email);
            v.put("granted",grant);






            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                  //  Toast.makeText(myadapter.this, "permision granted", Toast.LENGTH_SHORT).show();
                }
            });

        }

        private void uplodpass(TextView t1, TextView t2) {


            String user_name=t1.getText().toString();
            String user_email=t2.getText().toString();
            String grant="granted";
            DocumentReference reference = fstore.collection("permision granted").document(user_email);
            Map<String, String> v = new HashMap<>();
            v.put("name11",user_name);
            v.put("email11",user_email);
            v.put("granted",grant);






            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                   // Toast.makeText(myadapter.this, "permision granted", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
