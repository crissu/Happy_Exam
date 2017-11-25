package com.sjj.happy_exam.fragment;

import android.view.View;

import com.sjj.happy_exam.R;
import com.sjj.happy_exam.base.BaseFragment;

/**
 * Created by Asu on 2017/11/6.
 */
public class homeFragment extends BaseFragment {
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.homefragment_layout,null);
        return view;
    }
}
