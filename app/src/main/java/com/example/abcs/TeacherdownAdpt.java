package com.example.abcs;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

import android.util.Log;
import android.util.LogPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherdownAdpt extends RecyclerView.Adapter<downPdfview> {

    Teacher_required_download mainActivity;
    ArrayList<Teacherdowndata> downModels;
    String bb;
    String abc;
    Context context;

    public TeacherdownAdpt(Teacher_required_download mainActivity, ArrayList<Teacherdowndata> downModels) {
        this.mainActivity = mainActivity;
        this.downModels = downModels;
    }

    @NonNull
    @Override
    public downPdfview onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(mainActivity.getBaseContext());
        View view = layoutInflater.inflate(R.layout.downelements, null, false);

        return new downPdfview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final downPdfview myViewHolder, @SuppressLint("RecyclerView") final int i) {

        myViewHolder.mName.setText(downModels.get(i).getUid());
        myViewHolder.mLink.setText(downModels.get(i).getUrl10());
        myViewHolder.udid.setText(downModels.get(i).getEmail());
        bb=myViewHolder.mName.getText().toString();
        abc=myViewHolder.mLink.getText().toString();
        myViewHolder.mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), abc, Toast.LENGTH_SHORT).show();
                downloadFile(myViewHolder.mName.getContext(),downModels.get(i).getUid(),".pdf",DIRECTORY_DOWNLOADS,abc.trim());

                //Toast.makeText(mainActivity,myViewHolder.mName.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });


    }

//    private void downloadFile(Context context,String fileName, String fileExtension, String destinationDirectory, String pdfurl1) {
//        DownloadManager downloadmanager = (DownloadManager) context.
//                getSystemService(Context.DOWNLOAD_SERVICE);
//        Uri uri = Uri.parse(pdfurl1);
//        DownloadManager.Request request = new DownloadManager.Request(uri);
//
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
//
//        downloadmanager.enqueue(request);
//
//
//    }

    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url10) {

        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url10);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadmanager.enqueue(request);
    }


    @Override
    public int getItemCount() {
        return downModels.size();
    }

}
