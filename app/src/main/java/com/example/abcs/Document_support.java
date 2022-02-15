package com.example.abcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Document_support extends AppCompatActivity {

    Button _10,_12,_Dip,_FE,_SE,_TE,_BE,_cus;
    FirebaseAuth auth;
    String userID;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_support);

        _10=findViewById(R.id.del10);
        _12=findViewById(R.id.del12);
        _Dip=findViewById(R.id.deldip);
        _FE=findViewById(R.id.delfe);
        _SE=findViewById(R.id.delse);
        _TE=findViewById(R.id.delte);
        _BE=findViewById(R.id.delbe);


        auth=FirebaseAuth.getInstance();
        userID=auth.getCurrentUser().getUid();

        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        _10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 StorageReference desertRef =  storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/10" + ".pdf");
                 desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // File deleted successfully
                        Toast.makeText(Document_support.this, "10th Document deleted", Toast.LENGTH_SHORT).show();
                    }
                 }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Uh-oh, an error occurred!
                        Toast.makeText(Document_support.this, "Error delete"+ exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        _12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StorageReference desertRef =  storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/12" + ".pdf");
                desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // File deleted successfully
                        Toast.makeText(Document_support.this, "12th Document deleted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Uh-oh, an error occurred!
                        Toast.makeText(Document_support.this, "Error delete"+ exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        _Dip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StorageReference desertRef =  storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/diploma" + ".pdf");
                desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // File deleted successfully
                        Toast.makeText(Document_support.this, "Diploma Document deleted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Uh-oh, an error occurred!
                        Toast.makeText(Document_support.this, "Error delete"+ exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        _FE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StorageReference desertRef =  storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/FE" + ".pdf");
                desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // File deleted successfully
                        Toast.makeText(Document_support.this, "FE Document deleted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Uh-oh, an error occurred!
                        Toast.makeText(Document_support.this, "Error delete"+ exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        _SE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StorageReference desertRef =  storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/SE" + ".pdf");
                desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // File deleted successfully
                        Toast.makeText(Document_support.this, "SE Document deleted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Uh-oh, an error occurred!
                        Toast.makeText(Document_support.this, "Error delete"+ exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        _TE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StorageReference desertRef =  storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/TE" + ".pdf");
                desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // File deleted successfully
                        Toast.makeText(Document_support.this, "TE Document deleted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Uh-oh, an error occurred!
                        Toast.makeText(Document_support.this, "Error delete"+ exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        _BE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StorageReference desertRef =  storageReference.child("final student data/"+ "/"+auth.getCurrentUser().getUid()+"/BE" + ".pdf");
                desertRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // File deleted successfully
                        Toast.makeText(Document_support.this, "BE Document deleted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Uh-oh, an error occurred!
                        Toast.makeText(Document_support.this, "Error delete"+ exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}