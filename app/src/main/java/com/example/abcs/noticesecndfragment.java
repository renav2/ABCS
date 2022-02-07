package com.example.abcs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class noticesecndfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String Notice_Date ,Subject,Description,Highlight,Authority;
    public noticesecndfragment() {
        // Required empty public constructor
    }
    public noticesecndfragment(String notice_Date, String subject, String description, String highlight, String authority) {
        Notice_Date = notice_Date;
        Subject = subject;
        Description = description;
        Highlight = highlight;
        Authority = authority;
    }


    // TODO: Rename and change types and number of parameters
    public static noticesecndfragment newInstance(String param1, String param2) {
        noticesecndfragment fragment = new noticesecndfragment();
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
        View view= inflater.inflate(R.layout.fragment_noticesecndfragment, container, false);
        TextView dateholder=view.findViewById(R.id.dateholder);
        TextView subholder=view.findViewById(R.id.subholder);
        TextView descholder=view.findViewById(R.id.descholder);
        TextView hiholder =view.findViewById(R.id.hiholder);
        TextView authholder=view.findViewById(R.id.authholder);

        dateholder.setText(Notice_Date);
        subholder.setText(Subject);
        descholder.setText(Description);
        hiholder.setText(Highlight);
        authholder.setText(Authority);
        return view;
    }
    public void onBackPressed(){
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrappern, new nrecfragment()).addToBackStack(null).commit();
    }
}