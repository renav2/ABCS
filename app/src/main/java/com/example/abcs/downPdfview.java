package com.example.abcs;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class downPdfview extends RecyclerView.ViewHolder {

    TextView mName;
    TextView udid;
    TextView mLink;
    Button mDownload;

    public  downPdfview(@NonNull View itemView) {
        super(itemView);

        mName = itemView.findViewById(R.id.installment);
        mLink = itemView.findViewById(R.id.link);
        udid  =itemView.findViewById(R.id.vuid);
        mDownload = itemView.findViewById(R.id.down);


    }
}