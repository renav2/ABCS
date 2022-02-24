package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Adminhome extends AppCompatActivity {
Button apermission, btnpay,notification,teacher,userdata,Support;
Button teacher_add,teacher_delete,teacher_remove,acc_log,issuedoc,acc_del,dlt_notice;
    Button clgpayrecord, examrecord,hostelrecord,supportpay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        btnpay=findViewById(R.id.btn_viewallpay);
//        tests=findViewById(R.id.button18);

        apermission =  findViewById(R.id.adminper);
        notification=findViewById(R.id.button13);
        teacher=findViewById(R.id.button19);
        userdata=findViewById(R.id.button31);
        Support=findViewById(R.id.button34);
       // admintool=findViewById(R.id.button35);
        issuedoc=findViewById(R.id.button41);
        acc_del=findViewById(R.id.button26);
        teacher_add=findViewById(R.id.button38);
        dlt_notice=findViewById(R.id.button51);
        teacher_delete=findViewById(R.id.button42);
        acc_log=findViewById(R.id.login);
        clgpayrecord=findViewById(R.id.Admin_clg_record);
        examrecord=findViewById(R.id.admin_examrecord);
        hostelrecord=findViewById(R.id.admin_hostel_record);
        supportpay=findViewById(R.id.button33);



        supportpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Adminhome.this, Admin_support_pay_deptwise.class);
                startActivity(intent);
            }
        });

        clgpayrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Adminhome.this,Admin_clg_paymentrecod.class);
                startActivity(intent);
            }
        });


        hostelrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//        Intent intent=new Intent(Admin_paymentsection.this,Admin_hostel_payrecord.class);
//        startActivity(intent);
                Intent intent=new Intent(Adminhome.this,hotel_record_dept_wise.class);
                startActivity(intent);

            }
        });

        examrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Adminhome.this,Admin_exam_payrecord.class);
                startActivity(intent);
            }
        });




        dlt_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Adminhome.this,Admin_tool_noticedelete.class);
                startActivity(intent);
            }
        });



        acc_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Adminhome.this,admin_delete_account.class);
                startActivity(intent);
            }
        });

        acc_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Adminhome.this,Admin_account_reg.class);
                startActivity(intent);
            }
        });

        teacher_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Adminhome.this,Admin_teachers_reg.class);
                startActivity(intent);
            }
        });


        issuedoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Adminhome.this,Admin_document_issued.class);
                startActivity(intent);
            }
        });
        teacher_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Adminhome.this,Admin_delete_teacher.class);
                startActivity(intent);
            }
        });

//        admintool.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(Adminhome.this,Admin_tool_home.class);
//                startActivity(intent);
//
//
//            }
//        });



Support.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(Adminhome.this,Admin_support_solver.class);
        startActivity(intent);
    }
});


        userdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,Admin_delete_user.class);
                startActivity(intent);

            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,Teacher_required_docs.class);
                startActivity(intent);

            }
        });

//        tests.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(Adminhome.this,Admin_dept_wise_sort.class);
//                startActivity(intent);
//            }
//        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,AdminNotificationHome.class);
                startActivity(intent);
            }
        });
//        admin_payhome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(Adminhome.this,Admin_paymentsection.class);
//                startActivity(intent);
//            }
//        });

        apermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Adminhome.this,Admin_dept_wise_sort.class);
                startActivity(intent);
            }
        });

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(Adminhome.this, Admin_all_user_permision_section.class);
               startActivity(intent);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     MenuInflater inflater=getMenuInflater();
     inflater.inflate(R.menu.main_menu,menu);
     return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {



            case R.id.logO:
                signout();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void signout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        Toast.makeText(Adminhome.this, "Logout Succesfully", Toast.LENGTH_SHORT).show();

        finish();
    }

}