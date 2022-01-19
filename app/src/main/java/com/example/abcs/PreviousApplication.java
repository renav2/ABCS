package com.example.abcs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class PreviousApplication extends AppCompatActivity {
    ListView l;
    String uid;
 FirebaseAuth auth= FirebaseAuth.getInstance();
    FirebaseFirestore fs= FirebaseFirestore.getInstance();
    private final List<String> descapp = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_application);
            l = findViewById(R.id.list);
            uid =auth.getCurrentUser().getUid();
        final DocumentReference docRef = fs.collection("Permission_Applications").document(uid);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(PreviousApplication.this, " Details not found", Toast.LENGTH_SHORT).show();
                }

                if (snapshot != null && snapshot.exists()) {
                    Toast.makeText(PreviousApplication.this, "Current Details", Toast.LENGTH_SHORT).show();
                    descapp.clear();
                    descapp.add(snapshot.getString("Name"));
                    ArrayAdapter<String>adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_selectable_list_item,descapp);
                    adapter.notifyDataSetChanged();
                    l.setAdapter(adapter);
                } else {
                    Toast.makeText(PreviousApplication.this, " Details Null", Toast.LENGTH_SHORT).show();
                }
            }
        });
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(PreviousApplication.this, Permission_View_Application.class));
            }
        });

            /*l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openApplicationAt();
                }
            });EventListener<QuerySnapshot> el= new MediaCas.EventListener();
          fs.collection("Permission_Applications").document(uid).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent( QuerySnapshot value, FirebaseFirestoreException error) {
                    descapp.clear();
                    for(DocumentSnapshot snapshot : value){

                        descapp.add(snapshot.getString("Name"));
                    }
                    ArrayAdapter<String>adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_selectable_list_item,descapp);
                    adapter.notifyDataSetChanged();
                    l.setAdapter(adapter);
                }
            });
           /* ArrayAdapter<String> arr;
            arr
                    = new ArrayAdapter<String>(
                    this,
                    R.layout.support_simple_spinner_dropdown_item,
                    tutorials);
            l.setAdapter(arr);
*/

    }

   /* private void veiwpecific(String uid, ListView l) {
     final DocumentReference dr= fs.collection("Permission_Application").document(uid);

        dr.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent( QuerySnapshot value, FirebaseFirestoreException error) {
                descapp.clear();
                for(DocumentSnapshot snapshot : value){

                    descapp.add(snapshot.getString("Name"));
                }
                ArrayAdapter<String>adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_selectable_list_item,descapp);
                adapter.notifyDataSetChanged();
                l.setAdapter(adapter);
            }
        });
    }

    /*private void openApplicationAt() {
        Intent intent=new Intent(this, Permission_View_Application.class);
        startActivity(intent);
    }*/
}