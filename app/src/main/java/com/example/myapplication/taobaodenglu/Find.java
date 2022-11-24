package com.example.myapplication.taobaodenglu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Calendar;

public class Find extends AppCompatActivity {
    private EditText f_identity;
    private EditText f_name;
    private String str_identity;
    private String str_name;
    private TextView f_time;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        f_identity = findViewById(R.id.edt_identity);
        f_name = findViewById(R.id.edt_name);
        str_identity = f_identity.getText().toString();
        str_name = f_name.getText().toString();
        f_time = findViewById(R.id.time);
        calendar = Calendar.getInstance();

    }

    public void find_finish(View view) {
        finish();
    }


    public void time(View view) {
        showCalenderDialog();;
    }
     private void showCalenderDialog() {
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String calender = year + "年" + (month + 1) + "月" + dayOfMonth + "日";
                f_time.setText(calender);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

}