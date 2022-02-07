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

public class noticeadapter extends FirestoreRecyclerAdapter<noticemodel, noticeadapter.noticeviewholder> {
        public noticeadapter(@NonNull FirestoreRecyclerOptions< noticemodel > options){
        super(options);
    }

    @NonNull
    @Override
    public noticeviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerownotice,parent, false);
        return new noticeadapter.noticeviewholder(view);
    }


        @Override
        protected void onBindViewHolder(@NonNull noticeadapter.noticeviewholder holder, int position, @NonNull noticemodel noticemodel) {
        holder.datetext.setText(noticemodel.getNotice_Date());
        holder.subtext.setText(noticemodel.getSubject());
        holder.authtext.setText(noticemodel.getAuthority());
        holder.subtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrappern, new noticesecndfragment(noticemodel.getNotice_Date(),noticemodel.getSubject(),noticemodel.getDescription(),noticemodel.getHighlight(),noticemodel.getAuthority())).addToBackStack(null).commit();
            }
        });
    }

    public class noticeviewholder extends RecyclerView.ViewHolder
    {
        TextView datetext,authtext,subtext;

        public noticeviewholder(@NonNull View itemView) {
            super(itemView);
            datetext=itemView.findViewById(R.id.datetext);
            subtext =itemView.findViewById(R.id.subtext);
            authtext =itemView.findViewById(R.id.issuedby);

        }
    }
}
