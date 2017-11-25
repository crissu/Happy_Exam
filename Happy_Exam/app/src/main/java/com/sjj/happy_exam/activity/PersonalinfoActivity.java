package com.sjj.happy_exam.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sjj.happy_exam.R;

import cn.bmob.v3.BmobUser;

public class PersonalinfoActivity extends AppCompatActivity {

    private TextView tv_id;
    private TextView tv_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);
        //初始化控件
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        BmobUser user_info = BmobUser.getCurrentUser();
        tv_id.setText(user_info.getUsername());
        tv_phone.setText(user_info.getUsername());


    }
}
