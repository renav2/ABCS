package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Feesructure_issue extends AppCompatActivity {
    TextView unifee,medicfee,deptfee,tituionfee,totlef;
    TextView c_flag;
    FirebaseFirestore fstore;
    FirebaseAuth auth;
    String pro_userid;
    Spinner pay_instllmen;
    String txt_secondinstallmentm;
    String txt_installment,newroll;
    String samount;
    String imagesUri;

    Bitmap bitmap;
    Display mDisplay;
    TextView n,c,yaaa,b,data;
    File myPath;
    String file_name = "feestucture_CollageDocument_section";
    public static final int READ_PHONE = 110;
    int totalHeight;
    int totalWidth;
    String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feesructure_issue);

        data=findViewById(R.id.date);
        n=findViewById(R.id.fname);
        c=findViewById(R.id.fcolg);
        yaaa=findViewById(R.id.textView165);
        b=findViewById(R.id.fdept);



        unifee=findViewById(R.id.tv_rem_alrdypay);
        medicfee=findViewById(R.id.tv_rem_remain);
        deptfee=findViewById(R.id.tv_deppartmentfees);
        tituionfee=findViewById(R.id.tv_totalfees);
        totlef=findViewById(R.id.tv_totalfees1);

        auth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();



        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        String dateString = sdf.format(date);
        data.setText(dateString);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {




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

                takeScreenShot();



            }
        }, 3000);




        DocumentReference reference = fstore.collection("demo").document(auth.getCurrentUser().getUid());
        reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //fetching invoice related data from firestore
                String pro_dept=documentSnapshot.getString("Branch");
                String pro_collagename=documentSnapshot.getString("College_name");
                String pro_admisontype=documentSnapshot.getString("Admission_type");
                String pro_categary=documentSnapshot.getString("Category");
                String pro_class=documentSnapshot.getString("_Class");
String assignno=documentSnapshot.getString("assignno");
                n.setText(documentSnapshot.getString("Name"));
                c.setText(documentSnapshot.getString("College_name"));
                yaaa.setText(documentSnapshot.getString("_Class"));
                b.setText(documentSnapshot.getString("Branch"));


                DocumentReference reference=fstore.collection("document_issue_by_clg").document();
                Map<String, String> v=new HashMap<>();
                v.put("assignno",assignno);
                v.put("Name",n.getText().toString());
                v.put("dept",b.getText().toString());
                v.put("yr",yaaa.getText().toString());
                v.put("date",data.getText().toString());
                v.put("collagename",c.getText().toString());
                v.put("documentname","feestucture");

                reference.set(v).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Feesructure_issue.this, "You Are Successfully Registered ", Toast.LENGTH_SHORT).show();

                    }
                });


//comp BE & capround
                if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){
                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90000");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //comp   BE Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE comp
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //comp  Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //comp  Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //comp   BE Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //comp   BE Managment
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Comp") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//dept change




                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //IT   BE Managment
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE IT
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //IT  Managment
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //IT  Managment
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //IT   BE Managment
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //IT   BE Managment
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("IT") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }


                //dept---->entc

                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //ENTC   BE Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE ENTC
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //ENTC  Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //ENTC  Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //ENTC   BE Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //ENTC   BE Managment
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("ENTC") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }

// DEPT CHANGE--->



                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Civil   BE Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE Civil
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //Civil  Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //Civil  Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Civil   BE Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Civil   BE Managment
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Civil") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }

//DEPT -->Mech


                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Mech   BE Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("BE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//--> TE Mech
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //Mech  Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("TE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE

                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("9000");//totoal 10k
                    totlef.setText("13,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");
                }
                //Mech  Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");


                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                //--> inhouse cota

                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("89000");//total 90k
                    totlef.setText("93,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("49000");//total 50k
                    totlef.setText("53,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6300");//totoal 10k
                    totlef.setText("10,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("900");//
                    totlef.setText("2,300 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("300");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,300 only");

                }

//----->SE DSE
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Mech   BE Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");//total 90k
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("46000");//total 50k
                    totlef.setText("50,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("SE(D.S.E)") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
//----->FE
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80,000");//total 90k
                    totlef.setText("84,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Capround") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");
                }
                //Mech   BE Managment
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000 ");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("Management") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("86000");
                    totlef.setText("90,000 only");
                }
                //tfws
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("TFWS") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");
                }
                //--> inhouse cota

                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");
                    tituionfee.setText("80000");//total 90k
                    totlef.setText("84,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("40000");//total 50k
                    totlef.setText("44,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("3000");//4000
                    tituionfee.setText("6000");//totoal 10k
                    totlef.setText("10,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("In House Kota ") ){

                    unifee.setText("800");
                    medicfee.setText("200");
                    deptfee.setText("400");//2000
                    tituionfee.setText("600");//
                    totlef.setText("2,000 only");

                }
                //--> j and k
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("Open(EBC) ") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("O.B.C") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");
                }
                else if(pro_dept.equals("Mech") && pro_class.equals("FE") && pro_categary.equals("SC/NT") && pro_admisontype.equals("j and k") ){

                    unifee.setText("1000");
                    medicfee.setText("0000");
                    deptfee.setText("0000");
                    tituionfee.setText("0000");//total 0k
                    totlef.setText("1,000 only");

                }
            }
        });



    }

    private void takeScreenShot() {

        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ScreenShot/");

        if(!folder.exists()){
            boolean success = folder.mkdir();
        }

        path = folder.getAbsolutePath();
        path = path + "/" + file_name + System.currentTimeMillis() + ".pdf";


        View u = findViewById(R.id.ticket52020);

        NestedScrollView z = findViewById(R.id.ticket52020);
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

    private Bitmap getBitmapFromView(View u, int totalHeight, int totalWidth) {
        Bitmap returnedBitmap = Bitmap.createBitmap(totalWidth, totalHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = u.getBackground();

        if(bgDrawable != null){
            bgDrawable.draw(canvas);
        }else{
            canvas.drawColor(Color.WHITE);
        }

        u.draw(canvas);
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


//                Intent intent1=new Intent(Payment_examfees_invoice.this,Payment_home_page.class);
//                startActivity(intent1);

            }
        }, 5000);



    }
}