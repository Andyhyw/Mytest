package com.example.myapplication.taobaodenglu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.R;

public class ZhuCe extends AppCompatActivity {
    private Button zBtn;
    private EditText zuser;
    private String str_user;
    private boolean b_agree = false;
    private RadioButton z_rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        zBtn = findViewById(R.id.btn_enroll);
        zuser = findViewById(R.id.edt_enroll);
        z_rb = findViewById(R.id.z_agree);
        SpannableStringBuilder spannableString = new SpannableStringBuilder();
        spannableString.append("已阅读并同意以下协议：《淘宝平台服务协议》，《隐私权政策》，《支付宝注册相关协议》。" );
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#d3d3d3"));
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#d3d3d3"));
        spannableString.setSpan(colorSpan, 0, 11, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        z_rb.setText(spannableString);
        zuser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(zuser.getText())) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        zBtn.setBackground(getDrawable(R.drawable.old));
                    }
                    zBtn.setEnabled(Boolean.FALSE);

                } else {
                    zBtn.setBackground(getDrawable(R.drawable.button));
                    zBtn.setEnabled(Boolean.TRUE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        zBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_user = zuser.getText().toString();
                if (b_agree) {
                    if (str_user.length() == 11) {
                        Intent intent = new Intent(ZhuCe.this, Sucess.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ZhuCe.this, "请输入正确的手机号格式", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ZhuCe.this, "请同意用户协议", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void enroll_finish(View view) {
        finish();
    }

    public void question(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void agree(View view) {
        b_agree = true;
    }
}
