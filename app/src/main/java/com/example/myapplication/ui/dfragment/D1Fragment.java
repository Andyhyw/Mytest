package com.example.myapplication.ui.dfragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class D1Fragment extends Fragment {
    private static final String TAG = "D1Fragment";
    View view;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        Bundle bundle=  getActivity().getIntent().getExtras();
        Bundle bundle = this.getArguments();
        String str=bundle.getString("KK");
        Log.d(TAG,str);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_d1, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}