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

    Button delete;
    FirebaseAuth auth;
    String userID;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_support);

        delete=findViewById(R.id.del10);

        auth=FirebaseAuth.getInstance();
        userID=auth.getCurrentUser().getUid();

        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        delete.setOnClickListener(new View.OnClickListener() {
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

    }
}