package com.example.abcs;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class uplod_documents extends AppCompatActivity {
Button u10,d10,u12,d12,updip,downdip,upfe,downfe,upse,downse,upte,downte,upbe,ddownbe,upcustom,downcoston;
//TextView tu10,td10,tu12,td12,tupdip,tdowndip,tupfe,tdownfe,tupse,tdownse,tupte,tdownte,tupbe,tddownbe,tupcustom,tdowncoston;
TextView supportui;
String s;


Button  domesile;
Button feesturct;




    FirebaseAuth auth;
    FirebaseFirestore fstore;
    StorageReference storageReference;
    String  _10,_12,_dip,_1,_2,_3,_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplod_documents);
        //textview
        supportui=findViewById(R.id.textView121);
        feesturct=findViewById(R.id.button43);
       // tu10 =findViewById(R.id.tenup);
       // td10 =findViewById(R.id.tendown);
       // tu12=findViewById(R.id.up12);
       // td12 =findViewById(R.id.down12);
      //  tupdip =findViewById(R.id.updip);
      //  tdowndip=findViewById(R.id.downdip);
       // tupfe=findViewById(R.id.upfe);
      //  tdownfe=findViewById(R.id.downdfe);
     //   tupse=findViewById(R.id.upse);
       // tdownse=findViewById(R.id.downse);
        //tupte =findViewById(R.id.upte);
        //tdownte=findViewById(R.id.downte);
        //tupbe  =findViewById(R.id.upbe);
        //tddownbe=findViewById(R.id.downbe);
        //tupcustom=findViewById(R.id.upcostom);
       // tdowncoston=findViewById(R.id.downcustom);

        //buttons
        u10=findViewById(R.id.uplod10);
        d10=findViewById(R.id.downlod10);
        u12=findViewById(R.id.uplod12);
        d12=findViewById(R.id.downlod12);
        updip  =findViewById(R.id.uploddip);
        downdip=findViewById(R.id.downloddip);
        upfe =findViewById(R.id.uplodfe1);
        downfe =findViewById(R.id.downlodfe);
        upse =findViewById(R.id.uplodse);
        downse =findViewById(R.id.downlodse);
        upte=findViewById(R.id.uplodte);
        downte =findViewById(R.id.downlodte);
        upbe=findViewById(R.id.uplodbe);
        ddownbe =findViewById(R.id.downlodbe);
        upcustom=findViewById(R.id.button20);
        downcoston=findViewById(R.id.button20);
        domesile=findViewById(R.id.button11);


      //  Button u10,d10,u12,d12,updip,downdip,upfe,downfe,upse,downse,upte,downte,upbe,ddownbe,upcustom,downcoston;
       //TextView tu10,td10,tu12,td12,tupdip,tdowndip,tupfe,tdownfe,tupse,tdownse,tupte,tdownte,tupbe,tddownbe,tupcustom,tdowncoston;

    /*   td10.setVisibility(View.INVISIBLE);
        td12.setVisibility(View.INVISIBLE);
        tdowndip.setVisibility(View.INVISIBLE);
        tdownfe.setVisibility(View.INVISIBLE);
        tdownse.setVisibility(View.INVISIBLE);
        tdownte.setVisibility(View.INVISIBLE);
        tddownbe.setVisibility(View.INVISIBLE);
       // tdowncoston.setVisibility(View.INVISIBLE);*/
        d10.setVisibility(View.INVISIBLE);
        d12.setVisibility(View.INVISIBLE);
        downdip.setVisibility(View.INVISIBLE);
        downfe.setVisibility(View.INVISIBLE);
        downse.setVisibility(View.INVISIBLE);
        downte.setVisibility(View.INVISIBLE);
        ddownbe.setVisibility(View.INVISIBLE);
     //   downcoston.setVisibility(View.INVISIBLE);

        supportui.setText(getIntent().getStringExtra("assignno1"));



domesile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(uplod_documents.this,Bonafide_issue_.class);
        startActivity(intent);
    }
});



//firebase
        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        downcoston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(uplod_documents.this,uplod_teacher_reqdoc.class);

                intent.putExtra("uploddocto_specificuplod",supportui.getText().toString());

                startActivity(intent);
            }
        });

        //pdf link fetch **************************imp****************************************
        StorageReference profileRef= storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/10" + ".pdf");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                _10=uri.toString();
              //  Toast.makeText(uplod_documents.this, aaaaaaa, Toast.LENGTH_SHORT).show();
               // td10.setText(_10);
                d10.setVisibility(View.VISIBLE);
                u10.setVisibility(View.INVISIBLE);
            }
        });

        StorageReference profileRef1= storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/12" + ".pdf");
        profileRef1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                _12=uri.toString();
                //  Toast.makeText(uplod_documents.this, aaaaaaa, Toast.LENGTH_SHORT).show();
               // td12.setText(_12);
                d12.setVisibility(View.VISIBLE);
                u12.setVisibility(View.INVISIBLE);
            }
        });



        feesturct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(uplod_documents.this,Feesructure_issue.class);

                intent.putExtra("uploddocto_specificuplod",supportui.getText().toString());

                startActivity(intent);


            }
        });


        StorageReference profileRef2= storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/BE" + ".pdf");
        profileRef2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                _4=uri.toString();
                //  Toast.makeText(uplod_documents.this, aaaaaaa, Toast.LENGTH_SHORT).show();
               // tddownbe.setText(_4);
                ddownbe.setVisibility(View.VISIBLE);
                upbe.setVisibility(View.INVISIBLE);

            }
        });

        StorageReference profileRef3= storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/TE" + ".pdf");
        profileRef3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                _3=uri.toString();
                //  Toast.makeText(uplod_documents.this, aaaaaaa, Toast.LENGTH_SHORT).show();
             //   tdownte.setText(_3);

                downte.setVisibility(View.VISIBLE);
                upte.setVisibility(View.INVISIBLE);

            }
        });


        StorageReference profileRef4= storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/SE" + ".pdf");
        profileRef4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                _2=uri.toString();
                //  Toast.makeText(uplod_documents.this, aaaaaaa, Toast.LENGTH_SHORT).show();
              //  tdownse.setText(_2);


                downse.setVisibility(View.VISIBLE);
                upse.setVisibility(View.INVISIBLE);

            }
        });


        StorageReference profileRef5= storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/FE" + ".pdf");
        profileRef5.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                _1=uri.toString();
                //  Toast.makeText(uplod_documents.this, aaaaaaa, Toast.LENGTH_SHORT).show();
              //  tdownfe.setText(_1);
                downfe.setVisibility(View.VISIBLE);
                upfe.setVisibility(View.INVISIBLE);
            }
        });

//

        StorageReference profileRef7= storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/diploma" + ".pdf");
        profileRef7.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                _dip=uri.toString();
                //  Toast.makeText(uplod_documents.this, aaaaaaa, Toast.LENGTH_SHORT).show();
            //    tdowndip.setText(_dip);
                downdip.setVisibility(View.VISIBLE);
                updip.setVisibility(View.INVISIBLE);

            }
        });

   //end*****************************************************************************************************

        u10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent=new Intent(uplod_documents.this,doc_up_10_.class);
startActivity(intent);
finish();

            }
        });

u12.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(uplod_documents.this,doc_up_12.class);
        startActivity(intent);
        finish();
    }
});
        updip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(uplod_documents.this,doc_up_diploma.class);
                startActivity(intent);
                finish();
            }
        });


        upfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(uplod_documents.this, BE_1.class);
                startActivity(intent);
                finish();
            }
        });

        upse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(uplod_documents.this, BE_2.class);
                startActivity(intent);
                finish();
            }
        });

        upte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(uplod_documents.this, BE_3.class);
                startActivity(intent);
                finish();
            }
        });

        upbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(uplod_documents.this, BE_4.class);
                startActivity(intent);
                finish();
            }
        });




// downlod


        d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadFile10(uplod_documents.this,".pdf",DIRECTORY_DOWNLOADS,_10);

            }

            private void downloadFile10(uplod_documents uplod_documents, String s, String directoryDownloads, String s1) {
String fileName="10";
                DownloadManager downloadmanager = (DownloadManager) uplod_documents.
                        getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(s1);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(uplod_documents, directoryDownloads, fileName + s);

                downloadmanager.enqueue(request);

            }
        });



        d12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadFile12(uplod_documents.this,".pdf",DIRECTORY_DOWNLOADS,_12);

            }

            private void downloadFile12(uplod_documents uplod_documents, String s, String directoryDownloads, String s1) {
                String fileName="12";
                DownloadManager downloadmanager = (DownloadManager) uplod_documents.
                        getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(s1);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(uplod_documents, directoryDownloads, fileName + s);

                downloadmanager.enqueue(request);

            }
        });


        downdip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadFile10(uplod_documents.this,".pdf",DIRECTORY_DOWNLOADS,_dip);

            }

            private void downloadFile10(uplod_documents uplod_documents, String s, String directoryDownloads, String s1) {
                String fileName="diploma";
                DownloadManager downloadmanager = (DownloadManager) uplod_documents.
                        getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(s1);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(uplod_documents, directoryDownloads, fileName + s);

                downloadmanager.enqueue(request);

            }
        });



        downfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadFile10(uplod_documents.this,".pdf",DIRECTORY_DOWNLOADS,_1);

            }

            private void downloadFile10(uplod_documents uplod_documents, String s, String directoryDownloads, String s1) {
                String fileName="FE";
                DownloadManager downloadmanager = (DownloadManager) uplod_documents.
                        getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(s1);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(uplod_documents, directoryDownloads, fileName + s);

                downloadmanager.enqueue(request);

            }
        });




        downse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadFile10(uplod_documents.this,".pdf",DIRECTORY_DOWNLOADS,_2);

            }

            private void downloadFile10(uplod_documents uplod_documents, String s, String directoryDownloads, String s1) {
                String fileName="SE";
                DownloadManager downloadmanager = (DownloadManager) uplod_documents.
                        getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(s1);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(uplod_documents, directoryDownloads, fileName + s);

                downloadmanager.enqueue(request);

            }
        });



        downte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadFile10(uplod_documents.this,".pdf",DIRECTORY_DOWNLOADS,_3);

            }

            private void downloadFile10(uplod_documents uplod_documents, String s, String directoryDownloads, String s1) {
                String fileName="TE";
                DownloadManager downloadmanager = (DownloadManager) uplod_documents.
                        getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(s1);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(uplod_documents, directoryDownloads, fileName + s);

                downloadmanager.enqueue(request);

            }
        });




        ddownbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadFile10(uplod_documents.this,".pdf",DIRECTORY_DOWNLOADS,_4);

            }

            private void downloadFile10(uplod_documents uplod_documents, String s, String directoryDownloads, String s1) {
                String fileName="BE";
                DownloadManager downloadmanager = (DownloadManager) uplod_documents.
                        getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(s1);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(uplod_documents, directoryDownloads, fileName + s);

                downloadmanager.enqueue(request);

            }
        });
















    }



}