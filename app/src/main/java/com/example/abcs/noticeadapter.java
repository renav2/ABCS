package com.example.abcs;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import static android.os.Environment.DIRECTORY_DOWNLOADS;

import java.util.concurrent.Executor;

public class noticeadapter extends FirestoreRecyclerAdapter<noticemodel, noticeadapter.noticeviewholder> {
    FirebaseFirestore fstore;
    Context context;
    noticemodel noticemodel;
     TextView a_url;
     String a;

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
        String sub= holder.subtext.getText().toString();
        holder.authtext.setText(noticemodel.getAuthority());
        holder.a_url.setText(noticemodel.getPdfurl1());
        //String a_ur= holder.a_url.getText().toString();
            a=a_url.getText().toString();
        holder.subtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrappern, new noticesecndfragment(noticemodel.getNotice_Date(),noticemodel.getSubject(),noticemodel.getDescription(),noticemodel.getHighlight(),noticemodel.getAuthority())).addToBackStack(null).commit();
            }
        });

       /* holder.a_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(a));
                context.startActivity(intent);
            }
        });
        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent
            }
        });*/
    }

    public class noticeviewholder extends RecyclerView.ViewHolder
    {
        FirebaseFirestore fstore;

        TextView datetext,authtext,subtext,a_url;
Button b1;

        public noticeviewholder(@NonNull View itemView) {
            super(itemView);
            datetext=itemView.findViewById(R.id.datetext);
            subtext =itemView.findViewById(R.id.subtext);
            authtext =itemView.findViewById(R.id.issuedby);
            b1=itemView.findViewById(R.id.button15);
            a_url=itemView.findViewById(R.id.textView86);
            fstore=FirebaseFirestore.getInstance();
        


        }
    }
}
