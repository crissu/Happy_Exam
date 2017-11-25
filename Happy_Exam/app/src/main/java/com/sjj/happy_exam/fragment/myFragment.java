package com.sjj.happy_exam.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sjj.happy_exam.R;
import com.sjj.happy_exam.activity.PersonalinfoActivity;
import com.sjj.happy_exam.activity.SigninActivity;
import com.sjj.happy_exam.base.BaseFragment;

import cn.bmob.v3.BmobUser;

/**
 * Created by Asu on 2017/11/6.
 */
public class myFragment extends BaseFragment {

    private Button btn_sign_in;
    private TextView tv_revise_bac;
    private RelativeLayout my_memo;
    private RelativeLayout my_collection;
    private RelativeLayout my_info;
    private RelativeLayout my_set;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.myfragment_layout, null);
        //初始化控件
        btn_sign_in = (Button) view.findViewById(R.id.btn_sign_in);
        btn_sign_in.setOnClickListener(new MyOnClickListener());
        tv_revise_bac = (TextView) view.findViewById(R.id.tv_revise_bac);
        tv_revise_bac.setOnClickListener(new MyOnClickListener());
        my_memo = (RelativeLayout) view.findViewById(R.id.my_memo);
        my_memo.setOnClickListener(new MyOnClickListener());
        my_collection = (RelativeLayout) view.findViewById(R.id.my_collection);
        my_collection.setOnClickListener(new MyOnClickListener());
        my_info = (RelativeLayout) view.findViewById(R.id.my_info);
        my_info.setOnClickListener(new MyOnClickListener());
        my_set = (RelativeLayout) view.findViewById(R.id.my_set);
        my_set.setOnClickListener(new MyOnClickListener());

        //判断是否登录
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser!=null){
            //说明已登录
            btn_sign_in.setText(bmobUser.getUsername());
            btn_sign_in.setBackgroundColor(Color.TRANSPARENT);
            btn_sign_in.setEnabled(false);
        }else {
            //说明未登录

        }

        return view;
    }

    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_sign_in:
                    Intent intent = new Intent(mContext, SigninActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_revise_bac:

                    break;
                case R.id.my_memo:

                    break;
                case R.id.my_collection:

                    break;
                case R.id.my_info:
                    Intent intent_05 = new Intent(mContext, PersonalinfoActivity.class);
                    startActivity(intent_05);
                    break;
                case R.id.my_set:
                    
                    break;
            }
        }
    }

    @Override
    protected void initData() {
        super.initData();
    }
}
