//package com.example.abcs;

//public class support_pay_adpt {
//}
package com.example.abcs;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class support_pay_adpt extends RecyclerView.Adapter<support_pay_adpt.myviewholder>
{
    String aa;

    ArrayList<support_pay_data2> datalist;

    public support_pay_adpt(ArrayList<support_pay_data2> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.support_pay_singlerow21,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.bra.setText(datalist.get(position).getBranch());
        holder.cl.setText(datalist.get(position).get_Class());
        holder.nam.setText(datalist.get(position).getName());
        holder.iss.setText(datalist.get(position).getStudent_issue());
            aa=datalist.get(position).getAssignno();




    }
    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView bra,cl,nam,iss,game;
        Button yes,no;

//        TextView t1,t2,t3,t6,t,id;
//        Button b1p,b2f;
        FirebaseFirestore fstore;
        TextView permision_Status;
        EditText techeret;



        public myviewholder(@NonNull View itemView) {
            super(itemView);


//            id=itemView.findViewById(R.id.textView57);
//            t1=itemView.findViewById(R.id.t1);
//            t2=itemView.findViewById(R.id.t2);
//            t3=itemView.findViewById(R.id.t3);
//            t6=itemView.findViewById(R.id.t6);
//            t=itemView.findViewById(R.id.t);
//            b1p=itemView.findViewById(R.id.btn_pass);
//            b2f=itemView.findViewById(R.id.btn_fail);


            bra=itemView.findViewById(R.id.textView142t);
            cl=itemView.findViewById(R.id.textView142tt);
            nam=itemView.findViewById(R.id.textView142);
            iss=itemView.findViewById(R.id.textView139);
            yes=itemView.findViewById(R.id.button39);
            no=itemView.findViewById(R.id.button40);
game=itemView.findViewById(R.id.textView143);




            fstore=FirebaseFirestore.getInstance();
            permision_Status=itemView.findViewById(R.id.textView50);
            String permision_Status1;
            techeret=itemView.findViewById(R.id.editTextTextMultiLine);



            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DocumentReference washingtonRef = fstore.collection("Support_payment_issue").document(aa);

// Set the "isCapital" field of the city 'DC'
                    washingtonRef
                            .update("game", "YES")
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    game.setText("installment given");
                                    yes.setVisibility(View.INVISIBLE);
                                    no.setVisibility(View.INVISIBLE);

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    game.setText("some thing went wrong");
                                }
                            });




                }
            });


            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DocumentReference washingtonRef = fstore.collection("Support_payment_issue").document(aa);

// Set the "isCapital" field of the city 'DC'
                    washingtonRef
                            .update("game", "NO")
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    game.setText("installment NOT given");

                                    yes.setVisibility(View.INVISIBLE);
                                    no.setVisibility(View.INVISIBLE);

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    game.setText("some thing went wrong");
                                }
                            });
                }
            });


//            b1p.setVisibility(View.VISIBLE);
//            b2f.setVisibility(View.VISIBLE);

//for status
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    DocumentReference reference = fstore.collection("final_permision_status").document(id.getText().toString());
//                    reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            //basic profile things
//
//                            String pro_status=documentSnapshot.getString("status");
//                            permision_Status.setText(pro_status);
//                            if(permision_Status.getText().toString().equals("granted")||permision_Status.getText().toString().equals("NOT granted") ){
////                                b1p.setVisibility(View.INVISIBLE);
////                                b2f.setVisibility(View.INVISIBLE);
//                            }
//
//                            /// his
//
//                        }
//                    });

//                    fstore.collection("final_permision_status").whereEqualTo("status","pending").get()
//                            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                                @Override
//                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                                    List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                                    for(DocumentSnapshot d:list)
//                                    {
//                                        model obj=d.toObject(model.class);
//                                        datalist.add(obj);
//
//                                        b1p.setVisibility(View.INVISIBLE);
//                                        b2f.setVisibility(View.INVISIBLE);
//
//                                    }
//
//                                }
//                            });

//                    fstore.collection("final_permision_status").whereNotEqualTo("status","NOT granted").get()
//                            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                                @Override
//                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                                    List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                                    for(DocumentSnapshot d:list)
//                                    {
//                                        model obj=d.toObject(model.class);
//                                        datalist.add(obj);
//
//                                        b1p.setVisibility(View.INVISIBLE);
//                                        b2f.setVisibility(View.INVISIBLE);
//
//                                    }
//
//                                }
//                            });

//                    DocumentReference reference = fstore.collection("final_permision_status").document();
//                    reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            //basic profile things
//
//                            String pro_status=documentSnapshot.getString("status");
//                           permision_Status.setText(pro_status);
//
//
//                           /// his
//                            if(permision_Status.getText().toString().equals("granted")){
////                                Admin_all_user_permision_section mm=new Admin_all_user_permision_section();
////                                mm.invisi(b1p,b2f);
//                                b1p.setVisibility(View.INVISIBLE);
//                                b2f.setVisibility(View.INVISIBLE);
//                            }else if(permision_Status.getText().toString().equals("NOT granted")){
//                                b1p.setVisibility(View.INVISIBLE);
//                                b2f.setVisibility(View.INVISIBLE);
//
////                                Admin_all_user_permision_section mm=new Admin_all_user_permision_section();
////                                mm.invisi(b1p,b2f);
//                            }
//                        }
//                    });
//                }
//            }, 100);


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


            DocumentReference reference = fstore.collection("final_permision_status").document(txid);
            Map<String, String> v = new HashMap<>();
            v.put("Name", txtt1);
            v.put("Email", txtt2);
            v.put("Comments", txtt);
            v.put("Section", txtt6);
            v.put("Level", txtt3);
            v.put("perid", txid);
            v.put("techersidecomment",techeret.getText().toString() );
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
        private void uplod_permision_status_grant(TextView t1, TextView t2, TextView t3, TextView t, TextView t6,TextView id) {
            String txtt1=t1.getText().toString();
            String txtt2=t2.getText().toString();
            String txtt3=t3.getText().toString();
            String txtt=t.getText().toString();
            String txtt6=t6.getText().toString();
            String txid=id.getText().toString();
            DocumentReference reference = fstore.collection("final_permision_status").document(txid);
            Map<String, String> v = new HashMap<>();
            v.put("Name", txtt1);
            v.put("Email", txtt2);
            v.put("Comments", txtt);
            v.put("Section", txtt6);
            v.put("Level", txtt3);
            v.put("status","granted");
            v.put("techersidecomment",techeret.getText().toString() );
            v.put("perid", txid);



            reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    // Toast.makeText(test_user_permision_ask.this, "yor req is recorde", Toast.LENGTH_SHORT).show();
//                    b1p.setVisibility(View.INVISIBLE);
//                    b2f.setVisibility(View.INVISIBLE);
                    permision_Status.setText("Permission granted ");

                }
            });

        }
    }
}
