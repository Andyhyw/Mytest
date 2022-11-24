package com.example.myapplication.ui.dfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.myapplication.R;
import com.example.myapplication.ui.UIEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * TextView
 * EditText
 * Button
 * spinner
 * CheckBox
 * progressbar
 *
 * imageview
 *
 * LinearLayout
 * RelativeLayout
 * FrameLayout
 * ConstraintLayout
 *
 * * TableLayout(--)
 *  * AbsoluteLayout（--）
 *
 *
 * * switchbutton（）
 * * popWindow（）
 * DatePicker（）
 * TimePicker（）
 *
 *
 * dialog
*
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    FrameLayout frameLayout;
    Button btn1,btn2;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    List<Fragment>  fragmentList = new  ArrayList<>();

    D1Fragment d1Fragment;
    D2Fragment d2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        frameLayout =findViewById(R.id.fl);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(this::onClick);
        btn2.setOnClickListener(this::onClick);

//        EventBus.getDefault().register(this);

        fragmentManager = getSupportFragmentManager();
        d1Fragment =new D1Fragment();
        Bundle bundle =new Bundle();
        bundle.putString("KK","ll");
        d1Fragment.setArguments(bundle);
        fragmentList.add(d1Fragment);
        hideOtherFeagment(d1Fragment,true,"d1Fragment");


//        EventBus.getDefault().post();

    }

    public void hideOtherFeagment(Fragment fragment,boolean add,String tag){
        fragmentTransaction =fragmentManager.beginTransaction();//每次都要调用一次transaction
        if (add){
            fragmentTransaction.add(R.id.fl,fragment,tag);//
        }
        for (Fragment fragment1 :fragmentList){
            if (fragment.equals(fragment1)){
                fragmentTransaction.show(fragment1);
            }else {
                fragmentTransaction.hide(fragment1);
            }
        }
        fragmentTransaction.commit();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:

                hideOtherFeagment(d1Fragment,false,"d1Fragment");
                break;
            case R.id.btn2:
                if (d2Fragment == null){
                    d2Fragment = new D2Fragment();
                    fragmentList.add(d2Fragment);
                    hideOtherFeagment(d2Fragment,true,"d2Fragment");
                }else {
                    hideOtherFeagment(d2Fragment,false,"d2Fragment");
                }

                break;
        }
    }

    @Override
    protected void onStop() {
//        EventBus.getDefault().unregister(this);//事件总线
        super.onStop();

    }
}