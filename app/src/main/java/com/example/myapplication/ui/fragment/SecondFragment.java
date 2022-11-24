package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private static final String TAG = "SecondFragment";
    View view ;
    TextView tv_second;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle bundle=  getActivity().getIntent().getExtras();
        Bundle bundle = getArguments();
        String str=bundle.getString("KK");
        Log.d(TAG,str);
    }


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_second,container,false);
        tv_second = view.findViewById(R.id.se_tv);

        return view;
    }




    public  void  setTextView(String  str){
            tv_second.setText(str);
    }
}
