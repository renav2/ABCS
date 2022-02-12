package com.example.abcs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.FirebaseFirestore;

public class adminsndfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String Name, Email,Prn,Subject,Description,FromD,FromT,ToD,ToT,Status,Uid,Docid,Comment;


    public adminsndfragment(String name, String email, String prn, String subject, String description,
                            String fromD, String fromT, String toD, String toT, String status, String uid, String docid, String comment) {
        Name = name;
        Email = email;
        Prn = prn;
        Subject = subject;
        Description = description;
        FromD = fromD;
        FromT = fromT;
        ToD = toD;
        ToT = toT;
        Status = status;
        Uid = uid;
        Docid = docid;
        Comment = comment;
    }

    public adminsndfragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static adminsndfragment newInstance(String param1, String param2) {
        adminsndfragment fragment = new adminsndfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_adminsndfragment, container, false);
        TextView nameholder=view.findViewById(R.id.nmholder);
        TextView emailholder =view.findViewById(R.id.emholder);
        TextView prnholder=view.findViewById(R.id.pholder);
        TextView subholder=view.findViewById(R.id.subholder);
        TextView descholder=view.findViewById(R.id.descholder);
        TextView fromD=view.findViewById(R.id.d1holder);
        TextView fromT=view.findViewById(R.id.t1holder);
        TextView toD=view.findViewById(R.id.d2holder);
        TextView toT=view.findViewById(R.id.t2holder);
        Button ab=view.findViewById(R.id.approvebutton);
        Button rb=view.findViewById(R.id.rejectbutton);
        TextView t=view.findViewById(R.id.status);
        EditText c=view.findViewById(R.id.comment);

        nameholder.setText(Name);
        emailholder.setText(Email);
        prnholder.setText(Prn);
        subholder.setText(Subject);
        descholder.setText(Description);
        fromD.setText(FromD);
        fromT.setText(FromT);
        toD.setText(ToD);
        toT.setText(ToT);
        t.setText(Status);


        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ab.setVisibility(View.INVISIBLE);
                rb.setVisibility(View.INVISIBLE);
                String a="Approved";
                t.setText(a);
                Comment=c.getText().toString();

                // changeStatus("Approved");
                FirebaseFirestore.getInstance().collection("Permission").document(Uid)
                        .collection("Applications").document(Docid).update("Status",
                        "Approved","Comment",Comment);



            }
        });

        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ab.setVisibility(View.INVISIBLE);
                rb.setVisibility(View.INVISIBLE);
                String a="Rejected";
                t.setText(a);
                Comment=c.getText().toString();

                FirebaseFirestore.getInstance().collection("Permission").document(Uid)
                        .collection("Applications").document(Docid).update("Status","Rejected",
                        "Comment",Comment);

                // changeStatus("Rejected");
            }
        });

        return view;
    }

    public void onBackPressed(){
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.awrapper, new adrecfragment()).addToBackStack(null).commit();

    }
    }
