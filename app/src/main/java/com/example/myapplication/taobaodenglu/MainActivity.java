package com.example.myapplication.taobaodenglu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    private Button mButton_login;
    private EditText mEditText_login;
    private String str_user;
    private boolean b_agree = false;
    private RadioButton m_rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_t);
        mButton_login = findViewById(R.id.btn_login);
        mEditText_login = findViewById(R.id.edt_login);
        m_rb = findViewById(R.id.agree);
        SpannableStringBuilder spannableString = new SpannableStringBuilder();
        spannableString.append("已阅读并同意以下协议：《淘宝平台服务协议》，《隐私权政策》，《支付宝注册相关协议》," +
                "未注册的手机号将自动完成账号注册");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#d3d3d3"));
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#d3d3d3"));
        spannableString.setSpan(colorSpan, 0, 11, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(colorSpan1, 42, 58, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        m_rb.setText(spannableString);



        mButton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_user = mEditText_login.getText().toString();
                if (b_agree) {
                    if (str_user.equals("root")) {
                        Intent intent = new Intent(MainActivity.this, Sucess.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "账号错误", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "请同意用户协议", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void enroll(View view) {
        Intent intent = new Intent(MainActivity.this, ZhuCe.class);
        startActivity(intent);
    }

    public void more(View view) {
        showBottomSheetDialog();
    }
    private void showBottomSheetDialog() {
        final BottomSheetDialog dialog=new BottomSheetDialog(this,R.style.BottomSheetDialog);
        View dialogView= LayoutInflater.from(this).inflate(R.layout.activity_more,null);
        TextView tvSure = (TextView) dialogView.findViewById(R.id.quxiao);
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(dialogView);
        dialog.show();
    }

    public void tobaidu(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }
    public void find(View view){
        Intent intent =new Intent(this,Find.class);
        startActivity(intent);
    }

    public void quit(View view) {
        finish();
    }
    public void agree(View view) {
        b_agree = true;
    }
}