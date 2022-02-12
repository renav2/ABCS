package com.example.abcs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;


public class adrecfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recview;
    adminadapter adapter;
    public adrecfragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static adrecfragment newInstance(String param1, String param2) {
        adrecfragment fragment = new adrecfragment();
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
        View view =  inflater.inflate(R.layout.fragment_adrecfragment, container, false);
        recview=(RecyclerView)view.findViewById(R.id.arecview);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));



        FirestoreRecyclerOptions<modelpermission> options = new FirestoreRecyclerOptions.Builder<modelpermission>()
                .setQuery(FirebaseFirestore.getInstance().collectionGroup("Applications").whereEqualTo("Status","Pending"), modelpermission.class)
                .build();
        adapter=new adminadapter(options);
        recview.setAdapter(adapter);
        return view;
    }

    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}