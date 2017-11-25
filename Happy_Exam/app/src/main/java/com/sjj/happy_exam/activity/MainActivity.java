package com.sjj.happy_exam.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sjj.happy_exam.R;
import com.sjj.happy_exam.base.BaseFragment;
import com.sjj.happy_exam.fragment.homeFragment;
import com.sjj.happy_exam.fragment.myFragment;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

public class MainActivity extends FragmentActivity {

    private RadioGroup rg_main;

    private TextView tv_title;

    private List<BaseFragment> mBaseFragment;

    //当前选中的fragment
    private int position;

    /**
     * 上次切换的fragment
     */
    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Bmob
        Bmob.initialize(this,"cc123857c47f73b8a7f818b75967a84b");
        //初始化View
        initView();
        //初始化fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rg_main.check(R.id.rg_home);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.rg_home:
                    position = 0;//大厅
                    tv_title.setText("考研大厅");
                    break;
                case R.id.rg_my:
                    position = 1;//我的
                    tv_title.setText("我的考研");
                    break;
                default:
                    position = 0;
                    break;
            }
            //根据位置得到对应的fragment
            BaseFragment to = getFragment();
            //替换
            switchFragment(mContent,to);
        }
    }

    private void switchFragment(Fragment from, Fragment to){
        if (from != to){
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if(!to.isAdded()){
                //to没有被添加
                //from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //添加to
                if(to != null){
                    ft.add(R.id.fl_content,to).commit();
                }
            }else{
                //to已经被添加
                // from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //显示to
                if(to != null){
                    ft.show(to).commit();
                }
            }
        }
    }

    /**
     * 得到将要切换成的fragment
     *
     * @return
     */
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new homeFragment());//大厅fragment
        mBaseFragment.add(new myFragment());//我的fragement
    }

    /**
     * 初始化View
     */
    private void initView() {
        setContentView(R.layout.activity_main);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        tv_title = (TextView) findViewById(R.id.tv_title);
    }

}
