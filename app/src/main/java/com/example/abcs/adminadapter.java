package com.example.abcs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class adminadapter  extends FirestoreRecyclerAdapter<modelpermission, adminadapter.myviewholder>
{


    public adminadapter(@NonNull FirestoreRecyclerOptions<modelpermission> options) {
        super(options);
    }

    @NonNull
    @Override
    public adminadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowpermission,parent, false);
        return new adminadapter.myviewholder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull adminadapter.myviewholder holder, int position, @NonNull modelpermission modelpermission) {
        holder.nametext.setText(modelpermission.getName());
        holder.emailtext.setText(modelpermission.getEmail());
        holder.prntext.setText(modelpermission.getPrn());
        holder.subtext.setText(modelpermission.getSubject());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.awrapper,
                        new adminsndfragment(modelpermission.getName(), modelpermission.getEmail(), modelpermission.getPrn(),
                                modelpermission.getSubject(), modelpermission.getDescription(), modelpermission.getFromD(),
                                modelpermission.getFromT(), modelpermission.getToD(), modelpermission.getToT(),
                                modelpermission.getStatus(),modelpermission.getUid(),modelpermission.getDocid(),modelpermission.getComment()))
                        .addToBackStack(null).commit();
            }
        });
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView nametext,emailtext,prntext,subtext;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            nametext=itemView.findViewById(R.id.nametext);
            emailtext=itemView.findViewById(R.id.emailtext);
            prntext =itemView.findViewById(R.id.prntext);
            subtext =itemView.findViewById(R.id.subtext);
        }
    }
}
