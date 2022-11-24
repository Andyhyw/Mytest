package com.example.myapplication.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.interf.IFirstCallBack;
import com.example.myapplication.ui.fragment.FirstFragment;
import com.example.myapplication.ui.fragment.SecondFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentJActivity extends FragmentActivity implements View.OnClickListener{
//    FragmentActivity

    Button btn1,btn2;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    TextView tv_tv ;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btn1 =findViewById(R.id.btn1);
        btn2 =findViewById(R.id.btn2);
        btn2.setOnClickListener(this::onClick);
        btn1.setOnClickListener(this::onClick);

        tv_tv=findViewById(R.id.tv_tv);

        initView();

    }

    private void initView() {
        fragmentManager= getSupportFragmentManager();


        Bundle bundle =new Bundle();
        bundle.putString("KK","ll");
        firstFragment =(FirstFragment) FirstFragment.getInstanceFragment(bundle);

        firstFragment.setArguments(bundle);

        fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.first_fragment,firstFragment,"firstfragment");
//        secondFragment=new SecondFragment();
//        secondFragment.setArguments(bundle);
//        fragmentTransaction.add(R.id.second_fragment,secondFragment,"secondfragment");
        fragmentTransaction.commit();


//        addFragment( );

    }

    private void addFragment(Fragment fragment) {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:
//                this.getSupportFragmentManager().getFragments();
//                FirstFragment firstFragment1=(FirstFragment)    this.getSupportFragmentManager().findFragmentById(R.id.first_fragment);
//                    firstFragment.setTextView("from-activity-to-firstfragment");
                    firstFragment.sendMes(new IFirstCallBack() {
                        @Override
                        public void getMsgFormFirstFragment(String str) {
                            tv_tv.setText(str);
                        }
                    });
                    break;
                case R.id.btn2:
                    secondFragment.setTextView("from-activity-to-secondFragment");
                    break;
            }
    }
}
