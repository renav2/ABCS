package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin_class_wise_sort extends AppCompatActivity {
Button _1,_2,_3,_4;
TextView comp, it,entc,cvil,mech,techdept,techdesg,techemail;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_class_wise_sort);

techdept=findViewById(R.id.teacher_dept);
techdesg=findViewById(R.id.teacher_desg);
techemail=findViewById(R.id.teacher_email);

        comp  =findViewById(R.id.textView99);
        it=findViewById(R.id.textView101);
    entc =findViewById(R.id.textView103);
    cvil =findViewById(R.id.textView102);
    mech=findViewById(R.id.textView104);
    _1=findViewById(R.id._1st);
    _2=findViewById(R.id.button21);
    _3=findViewById(R.id.button22);
    _4=findViewById(R.id.button23);

    //comp, it,entc,cvil,mech,techdept,techdesg,techemail;



    comp.setText(getIntent().getStringExtra("deptcomp"));
    it.setText(getIntent().getStringExtra("deptit"));
    entc.setText(getIntent().getStringExtra("deptentc"));
    cvil.setText(getIntent().getStringExtra("deptcvil"));
    mech.setText(getIntent().getStringExtra("deptmech"));
    //test code for teacher
    techdept.setText(getIntent().getStringExtra("Department"));
    techdesg.setText(getIntent().getStringExtra("Designation"));
    techemail.setText(getIntent().getStringExtra("Email"));



    comp.setVisibility(View.INVISIBLE);
    it.setVisibility(View.INVISIBLE);
    entc.setVisibility(View.INVISIBLE);
    cvil.setVisibility(View.INVISIBLE);
    mech.setVisibility(View.INVISIBLE);
    techdept.setVisibility(View.INVISIBLE);
    techdesg.setVisibility(View.INVISIBLE);
    techemail.setVisibility(View.INVISIBLE);
    //.setVisibility(View.INVISIBLE);




    _1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Admin_class_wise_sort.this,admin_supporpay_final_record.class);
            //  intent.putExtra("deptnname","IT");

           // Toast.makeText(Admin_class_wise_sort.this, comp.getText().toString(), Toast.LENGTH_SHORT).show();
            if(comp.getText().toString().equals("Comp")){
                intent.putExtra("deco1","Comp");
                intent.putExtra("class1","FE");
            }else if(it.getText().toString().equals("IT") && techdesg.getText().toString().equals("TG")){
                intent.putExtra("deco2","IT");
                intent.putExtra("class1","FE");
            }
           else  if(entc.getText().toString().equals("ENTC")){
                intent.putExtra("deco3","ENTC");
                intent.putExtra("class1","FE");
            }
            else if(cvil.getText().toString().equals("Civil")){
                intent.putExtra("deco4","Civil");
                intent.putExtra("class1","FE");
            }
           else if(mech.getText().toString().equals("Mech")){
                intent.putExtra("deco5","Mech");
                intent.putExtra("class1","FE");
            }

            //intent.putExtra("class1","FE");
         //   Toast.makeText(Admin_class_wise_sort.this, comp.getText().toString(), Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    });


    _2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Admin_class_wise_sort.this,admin_supporpay_final_record.class);
            //  intent.putExtra("deptnname","IT");
           // intent.putExtra("class2","SE");

            if(comp.getText().toString().equals("Comp")){
                intent.putExtra("deco1","Comp");
                intent.putExtra("class1","SE");
            }else if(it.getText().toString().equals("IT")){
                intent.putExtra("deco2","IT");
                intent.putExtra("class1","SE");
            }
            else  if(entc.getText().toString().equals("ENTC")){
                intent.putExtra("deco3","ENTC");
                intent.putExtra("class1","SE");
            }
            else if(cvil.getText().toString().equals("Civil")){
                intent.putExtra("deco4","Civil");
                intent.putExtra("class1","SE");
            }
            else if(mech.getText().toString().equals("Mech")){
                intent.putExtra("deco5","Mech");
                intent.putExtra("class1","SE");
            }


            startActivity(intent);
        }
    });

    _3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Admin_class_wise_sort.this,admin_supporpay_final_record.class);
            //  intent.putExtra("deptnname","IT");
          //  intent.putExtra("class3","TE");
            if(comp.getText().toString().equals("Comp")){
                intent.putExtra("deco1","Comp");
                intent.putExtra("class1","TE");
            }else if(it.getText().toString().equals("IT")){
                intent.putExtra("deco2","IT");
                intent.putExtra("class1","TE");
            }
            else  if(entc.getText().toString().equals("ENTC")){
                intent.putExtra("deco3","ENTC");
                intent.putExtra("class1","TE");
            }
            else if(cvil.getText().toString().equals("Civil")){
                intent.putExtra("deco4","Civil");
                intent.putExtra("class1","TE");
            }
            else if(mech.getText().toString().equals("Mech")){
                intent.putExtra("deco5","Mech");
                intent.putExtra("class1","TE");
            }
            startActivity(intent);
        }
    });
    _4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Admin_class_wise_sort.this,admin_supporpay_final_record.class);
            //  intent.putExtra("deptnname","IT");
       //     intent.putExtra("class4","BE");

            if(comp.getText().toString().equals("Comp")){
                intent.putExtra("deco1","Comp");
                intent.putExtra("class1","BE");
            }else if(it.getText().toString().equals("IT")){
                intent.putExtra("deco2","IT");
                intent.putExtra("class1","BE");
            }
            else  if(entc.getText().toString().equals("ENTC")){
                intent.putExtra("deco3","ENTC");
                intent.putExtra("class1","BE");
            }
            else if(cvil.getText().toString().equals("Civil")){
                intent.putExtra("deco4","Civil");
                intent.putExtra("class1","BE");
            }
            else if(mech.getText().toString().equals("Mech")){
                intent.putExtra("deco5","Mech");
                intent.putExtra("class1","BE");
            }
            startActivity(intent);
        }
    });



}
}