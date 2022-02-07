package com.example.abcs;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Payment_examfees_invoice extends AppCompatActivity {
    Display mDisplay;
    String imagesUri;
    String path;
    Bitmap bitmap;
    TextView section;
    ImageView sign;
    int totalHeight;
    int totalWidth;
    String file_name = "collage payment section";
    File myPath;

    public static final int READ_PHONE = 110;
    TextView na,roll,clas,bran,prn,forno,amo,invoicn;
    FirebaseAuth auth;
    String invo_userid;
    FirebaseFirestore fstore;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_examfees_invoice);

        na=findViewById(R.id.tv_examname201);
        clas=findViewById(R.id.tv_exam_class202);
        bran=findViewById(R.id.tv_exam_branch203);
        roll=findViewById(R.id.tv_exam_rollno204);
        prn=findViewById(R.id.tv_examprn206);
        forno=findViewById(R.id.tv_examform_207);
        amo=findViewById(R.id.textView42);
        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        invo_userid=auth.getCurrentUser().getUid();
        invoicn=findViewById(R.id.textView46);
        btn=findViewById(R.id.btn_examfees2);
        sign=findViewById(R.id.idIVQrcode222);
        section=findViewById(R.id.tv_section222);

        sign.setVisibility(View.INVISIBLE);
        section.setVisibility(View.INVISIBLE);
        
        String ex1_amountpass = getIntent().getStringExtra("examamountint");
        String ex1_string_amountpass = getIntent().getStringExtra("examamount");
        String ex1_prn = getIntent().getStringExtra("examprn");
        String ex1_formno = getIntent().getStringExtra("exform");

        //data setting

        na.setText(getIntent().getStringExtra("examname"));
        clas.setText(getIntent().getStringExtra("examclass"));
        bran.setText(getIntent().getStringExtra("exambranch"));
        roll.setText(getIntent().getStringExtra("examrollno"));
        amo.setText(ex1_string_amountpass);
        forno.setText(ex1_formno);
        prn.setText(ex1_prn);


        invoice_no();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                String txt_na = na.getText().toString();
                String txt_class = clas.getText().toString();
                String txt_roll = roll.getText().toString();
                String txt_dept = bran.getText().toString();
               String txt_invoic = invoicn.getText().toString();
                String txt_invamount = amo.getText().toString();
                String txtprn=prn.getText().toString();
                String txt_formno=forno.getText().toString();
                String ex1_back=getIntent().getStringExtra("examback");


                int to = 11000;
                int pay = Integer.parseInt(txt_invamount);
                // int curr=Integer.parseInt(pass);
                int rem = to -pay;
                String txt_rem = Integer.toString(rem);

                WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                mDisplay = wm.getDefaultDisplay();
                if(Build.VERSION.SDK_INT >= 23){
                    if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                            && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED){
                    }else{
                        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, READ_PHONE);
                    }
                }


                DocumentReference reference = fstore.collection("Exam_fees_data").document(invo_userid);
                Map<String, String> v = new HashMap<>();
                v.put("_1Student_roll_no", txt_roll);
                v.put("_1Student_name", txt_na);
                v.put("_1Student_class", txt_class);
                v.put("_1Student_dept", txt_dept);
                v.put("_1Student_invoiceno", txt_invoic);
                v.put("_1Student_back_formno", ex1_back);
                v.put("_1Student_prnno",txtprn);
                v.put("_1Student_formno",txt_formno);
                v.put("_1Student_payed_amount", txt_invamount);
                v.put("_1Student_remain_fees", txt_rem);



                reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Payment_examfees_invoice.this, "your payment record save", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        }, 100);

                btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    takeScreenShot();
                    Print_Button_invisible();
                    
                    
                    
                }
            });




    }

    private void Print_Button_invisible() {

        btn.setVisibility(View.INVISIBLE);
        sign.setVisibility(View.VISIBLE);
        section.setVisibility(View.VISIBLE);
    }

    private void takeScreenShot() {
        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ScreenShot/");

        if(!folder.exists()){
            boolean success = folder.mkdir();
        }

        path = folder.getAbsolutePath();
        path = path + "/" + file_name + System.currentTimeMillis() + ".pdf";


        View u = findViewById(R.id.ticket4);

        NestedScrollView z = findViewById(R.id.ticket4);
        totalHeight = z.getChildAt(0).getHeight();
        totalWidth = z.getChildAt(0).getWidth();




        String extr = Environment.getExternalStorageDirectory() + "/Flight Ticket/";
        File file = new File(extr);
        if(!file.exists())
            file.mkdir();
        String fileName = file_name + ".jpg";
        myPath = new File(extr, fileName);
        imagesUri = myPath.getPath();
        bitmap = getBitmapFromView(u, totalHeight, totalWidth);

        try{
            FileOutputStream fos = new FileOutputStream(myPath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        createPdf();
    }

    private Bitmap getBitmapFromView(View view, int totalHeight, int totalWidth) {
        Bitmap returnedBitmap = Bitmap.createBitmap(totalWidth, totalHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();

        if(bgDrawable != null){
            bgDrawable.draw(canvas);
        }else{
            canvas.drawColor(Color.WHITE);
        }

        view.draw(canvas);
        return returnedBitmap;

    }

    private void createPdf() {
        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);

        Canvas canvas = page.getCanvas();

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawPaint(paint);

        Bitmap bitmap = Bitmap.createScaledBitmap(this.bitmap, this.bitmap.getWidth(), this.bitmap.getHeight(), true);

        paint.setColor(Color.BLUE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        document.finishPage(page);
        File filePath = new File(path);
        try{
            document.writeTo(new FileOutputStream(filePath));
        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, "Something Wrong: "+e.toString(), Toast.LENGTH_SHORT).show();
        }

        document.close();

        if (myPath.exists())
            myPath.delete();

        openPdf(path);
    }

    private void openPdf(String path) {
        File file = new File(path);
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file), "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, "Open FIle");
        try{



            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "No Apps to read PDF FIle", Toast.LENGTH_SHORT).show();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent1=new Intent(Payment_examfees_invoice.this,Payment_home_page.class);
                startActivity(intent1);

            }
        }, 5000);


    }

    private void invoice_no() {

        Random random=new Random();
        int val=random.nextInt(1000000000);
        int val2=random.nextInt(1000000000);
        if(val ==val2){
            invoicn .setText("E0"+val);
        }

        invoicn.setText(Integer.toString(val));

    }
}