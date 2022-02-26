package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;

public class College_pay extends AppCompatActivity {

    Button show;
    Spinner a,b,c,d;
    TextView unifee,medicfee,deptfee,tituionfee,totlef,mmmm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_pay);

        show=findViewById(R.id.cshow);
        a=findViewById(R.id.cadtype);
        b=findViewById(R.id.cadcat);
        c=findViewById(R.id.cbr);
        d=findViewById(R.id.ccls);

        mmmm=findViewById(R.id.textView152);

        unifee=findViewById(R.id.tv_rem_alrdypay);
        medicfee=findViewById(R.id.tv_rem_remain);
        deptfee=findViewById(R.id.tv_deppartmentfees);
        tituionfee=findViewById(R.id.tv_totalfees);
        totlef=findViewById(R.id.tv_totalfees1);



        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.getSelectedItem().toString();
                b.getSelectedItem().toString();
                c.getSelectedItem().toString();
                d.getSelectedItem().toString();


                    String pro_dept=c.getSelectedItem().toString();
                    //String pro_collagename=documentSnapshot.getString("College_name");
                    String pro_admisontype=a.getSelectedItem().toString();
                    String pro_categary=b.getSelectedItem().toString();
                    String pro_class=d.getSelectedItem().toString();
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
}