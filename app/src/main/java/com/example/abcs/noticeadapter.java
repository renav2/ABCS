package com.example.abcs;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class noticeadapter extends  FirestoreRecyclerAdapter<noticemodel, noticeadapter.noticeviewholder> {
    FirebaseFirestore fstore;
//    Context context;
    noticemodel noticemodel;
     TextView a_url;
     String a;


        public noticeadapter(@NonNull FirestoreRecyclerOptions< noticemodel > options){
        super(options);
    }
    @NonNull
    @Override
    public noticeviewholder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerownotice,parent, false);
        return new noticeadapter.noticeviewholder(view);
    }
        @Override
        protected void onBindViewHolder(@NonNull noticeadapter.noticeviewholder holder, int position, @NonNull noticemodel noticemodel) {
        holder.datetext.setText(noticemodel.getNotice_Date());
        holder.subtext.setText(noticemodel.getSubject());

        holder.authtext.setText(noticemodel.getAuthority());
        holder.a_url.setText(noticemodel.getPdfurl1());
 String aa=holder.a_url.getText().toString();
            a=aa;
            holder.b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 //a -->url
                 //  holder.urlcpy.setText(a);

//               ViewNotifications vv=new ViewNotifications();
//             vv.seturl(a);
//                    DownloadManager.Request request=new DownloadManager.Request(Uri.parse(a));
//                    String title= URLUtil.guessFileName(a,null,null);
//                    request.setTitle(title);
//                    request.setDescription("downloding");
//                    String cookie= CookieManager.getInstance().getCookie(a);
//                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                    request.setDestinationInExternalPublicDir(DIRECTORY_DOWNLOADS,title);
//                    //  DownloadManager downloadManager=(DownloadManager);
//                    DownloadManager downloadManager=(DownloadManager).getSystemService(Context.DOWNLOAD_SERVICE);
//                    downloadManager.enqueue(request);
                }
            });
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
        FirebaseFirestore fstore;

        TextView datetext,authtext,subtext,a_url, urlcpy;
Button b1;

        public noticeviewholder(@NonNull View itemView) {
            super(itemView);
            datetext=itemView.findViewById(R.id.datetext);
            subtext =itemView.findViewById(R.id.subtext);
            authtext =itemView.findViewById(R.id.issuedby);
            b1=itemView.findViewById(R.id.button15);
            a_url=itemView.findViewById(R.id.textView86);
            fstore=FirebaseFirestore.getInstance();
            urlcpy=itemView.findViewById(R.id.textView56);
            FirebaseStorage storage = FirebaseStorage.getInstance();


        }


    }

    public long downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {


        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        return downloadmanager.enqueue(request);
    }

}
