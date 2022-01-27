package com.example.abcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    //delclaration
   private  Button bt_login, reg;
   private EditText et_email;
   private EditText et_pass;
   private TextView tv_jump;
   private TextView tv_jump2;
   private TextView homejump, adminhome;
   private FirebaseAuth auth;




    // [END auth_fui_create_launcher]
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //createSignInIntent();
                        adminhome=findViewById(R.id.textView39);
                        bt_login=findViewById(R.id.btn_login);
                        et_email=findViewById(R.id.txt_email);
                        et_pass=findViewById(R.id.txt_password);
                        tv_jump=findViewById(R.id.txt_view_jump);
                        tv_jump2=findViewById(R.id.txt_view_jump2);

//firbase intialize
        auth = FirebaseAuth.getInstance();


       //temp jump page for testing purpose
        homejump=findViewById(R.id.txhome);
//all button code

        checkCurrentUser();

        adminhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Adminhome.class);
                startActivity(intent);
            }
        });





                        homejump.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                                startActivity(intent);
                            }
                        });

                 

                        bt_login.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String tex_email=et_email.getText().toString();
                                String tex_pass=et_pass.getText().toString();

//                                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
//
                               // startActivity(intent);



                                if(tex_email.equals("Admin")&&  tex_pass.equals("admin")){
                                    Intent intent1=new Intent(MainActivity.this,Adminhome.class);
                                    startActivity(intent1);
                                }
                                else{
                                loginuser(tex_email,tex_pass);
                                }
                            }
                        });

                                tv_jump2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent=new Intent(MainActivity.this,social_media_login_Activity.class);
                                        startActivity(intent);
                                    }
                                });





    }

    private void checkCurrentUser() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();

        } else {
            // No user is signed in

            Toast.makeText(this, "login karna ", Toast.LENGTH_SHORT).show();
        }

    }

    private void loginuser(String _email, String _pass) {
        auth.signInWithEmailAndPassword(_email,_pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, " login done bro :)", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                intent.putExtra("home_email",_email);
               intent.putExtra("home_pass",_pass);



                startActivity(intent);

finish();

            }
        });

    }



}