package com.example.myapplication.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.interf.IFirstCallBack;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";

  View view;
  TextView textView;
  Button btn;
 static FirstFragment firstFragment;
 String str=null;

  public static Fragment getInstanceFragment(Bundle bundle){

      if (firstFragment == null){
          firstFragment =new FirstFragment();

      }
      firstFragment.setArguments(bundle);
      return firstFragment;
  }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle bundle=  getActivity().getIntent().getExtras();
        Bundle bundle = getArguments();
        String str=bundle.getString("KK");
        Log.d(TAG,str);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_first, container, false);
        textView=view.findViewById(R.id.first_tv);
        btn=view.findViewById(R.id.btn_ff);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SecondFragment secondFragment=(SecondFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.second_fragment);
//                secondFragment.setTextView("form  first fragment");
            }
        });
//        initView();

        // Inflate the layout for this fragment
        return view;
    }

    public void setTextView(String str) {
        textView.setText(str);
    }

    public void sendMes(IFirstCallBack iFirstCallBack){
        iFirstCallBack.getMsgFormFirstFragment("first-to-activity");
    }
}