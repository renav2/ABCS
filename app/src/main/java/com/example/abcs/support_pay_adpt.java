//package com.example.abcs;

//public class support_pay_adpt {
//}
package com.example.abcs;

import android.content.Context;
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

import java.util.ArrayList;


public class support_pay_adpt extends RecyclerView.Adapter<support_pay_adpt.myviewholder>
{
    String aa;
Context context;
String id;

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
        holder.studi.setText(datalist.get(position).getAssignno());
id=holder.studi.getText().toString();
//holder.yes.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(v.getContext(), id, Toast.LENGTH_SHORT).show();
//    }
//});

    }
    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here
        TextView bra,cl,nam,iss,game,studi;
        Button yes,no;
        FirebaseFirestore fstore;
        TextView permision_Status;
        EditText techeret;

        public myviewholder(@NonNull View itemView) {
            super(itemView);


            studi=itemView.findViewById(R.id.textView157);
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
            techeret=itemView.findViewById(R.id.tech_comments);


studi.setVisibility(View.INVISIBLE);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    DocumentReference reference = fstore.collection("Support_payment_issue").document(id);
                    reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            //basic profile things
                            String pro_status=documentSnapshot.getString("game");
                            game.setText(pro_status);
                            if(game.getText().toString().equals("YES")||game.getText().toString().equals("NO") ){
                                game.setText(pro_status+" Installment Given");

                                yes.setVisibility(View.INVISIBLE);
                                no.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }, 100);



//            fstore.collection("final_permision_status").whereEqualTo("Name",nam.getText().toString()).get()
//                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
//                            for(DocumentSnapshot d:list)
//                            {
//                                game.setText(d.getString("game"));
//
//                            }
//
//                        }
//                    });

//yes.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(v.getContext(), id, Toast.LENGTH_SHORT).show();
//    }
//});
//




            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    Toast.makeText(context, id, Toast.LENGTH_SHORT).show();

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



        }

    }
}
