package com.sjj.happy_exam.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sjj.happy_exam.R;
import com.sjj.happy_exam.activity.MainActivity;
import com.sjj.happy_exam.base.BaseFragment;
import com.sjj.happy_exam.utils.LogUtil;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Asu on 2017/11/22.
 */

public class signinFragment extends BaseFragment {

    private EditText edt_userid;
    private EditText edt_password;
    private TextView tv_signup;
    private TextView tv_find_password;
    private Button btn_signin_up;

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.signinfragment_layout, null);
        //初始化控件
        edt_userid = (EditText) view.findViewById(R.id.edt_userid);
        edt_password = (EditText) view.findViewById(R.id.edt_password);
        tv_signup = (TextView) view.findViewById(R.id.tv_signup);
        tv_signup.setOnClickListener(new MyOnClickListener());
        tv_find_password = (TextView) view.findViewById(R.id.tv_find_password);
        tv_find_password.setOnClickListener(new MyOnClickListener());
        btn_signin_up = (Button) view.findViewById(R.id.btn_signin_up);
        btn_signin_up.setOnClickListener(new MyOnClickListener());
        return view;
    }

    class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_signup:
                    btn_signin_up.setText("注册");
                    break;
                case R.id.tv_find_password:

                    break;
                case R.id.btn_signin_up:
                    //获取输入框内信息
                    String id = String.valueOf(edt_userid.getText());
                    String password = String.valueOf(edt_password.getText());

                    if (btn_signin_up.getText().equals("登录")) {
                        if (id.equals("用户名") || id.equals("") ||
                                password.equals("密码") || password.equals("")) {
                            Toast.makeText(mContext, "尚未输入用户名或密码", Toast.LENGTH_SHORT).show();
                        } else {
                            //登录操作
                            //1.输入登录信息
                            BmobUser user_2 = new BmobUser();
                            user_2.setUsername(id);
                            user_2.setPassword(password);
                            //2.开始登录
                            user_2.login(new SaveListener<BmobUser>() {
                                @Override
                                public void done(BmobUser bmobUser, BmobException e) {
                                    if (e == null) {
                                        Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(mContext, MainActivity.class);
                                        startActivity(intent);
                                    } else {
                                        LogUtil.e("登录出错：" + e.toString());
                                    }
                                }
                            });
                        }
                    }
                    if (btn_signin_up.getText().equals("注册")) {
                        if (id.equals("用户名") || id.equals("") ||
                                password.equals("密码") || password.equals("")) {
                            Toast.makeText(mContext, "尚未输入注册信息", Toast.LENGTH_SHORT).show();
                        } else {
                            //注册操作
                            //1.输入注册信息
                            BmobUser user_1 = new BmobUser();
                            user_1.setUsername(id);
                            user_1.setPassword(password);
                            //2.开始注册
                            user_1.signUp(new SaveListener<BmobUser>() {
                                @Override
                                public void done(BmobUser bmobUser, BmobException e) {
                                    if (e == null) {
                                        Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
                                        //回到登录界面
                                        edt_userid.setText("用户名");
                                        edt_password.setText("密码");
                                        btn_signin_up.setText("登录");
                                    } else {
                                        LogUtil.e("注册出错：" + e.toString());
                                    }
                                }
                            });
                        }
                    }
                    break;
            }
        }
    }

}
