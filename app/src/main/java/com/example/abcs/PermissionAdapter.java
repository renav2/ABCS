package com.example.abcs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PermissionAdapter extends RecyclerView.Adapter<PermissionAdapter.myView>{
    ArrayList<PermissionModel> datalist;

    public PermissionAdapter(ArrayList<PermissionModel> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.psinglerow,parent,false);
        return new myView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myView holder, int position) {
    holder.t1.setText(datalist.get(position).getName());
    holder.t2.setText(datalist.get(position).getPrn());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myView extends RecyclerView.ViewHolder {
        TextView t1,t2;
        public myView(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.tvv1);
            t2=itemView.findViewById(R.id.tvv2);
        }
    }
}
