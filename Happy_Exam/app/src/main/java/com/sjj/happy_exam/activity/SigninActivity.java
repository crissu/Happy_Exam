package com.sjj.happy_exam.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.sjj.happy_exam.R;
import com.sjj.happy_exam.fragment.signinFragment;

public class SigninActivity extends FragmentActivity {

    private signinFragment signinFragments;

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //添加SigninFragment
        signinFragments = new signinFragment();
        fragment = signinFragments;
        addFragment(fragment);

    }

    /**
     * 添加signinFragment
     * @param fragment
     */
    private void addFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (!fragment.isAdded()) {
            ft.add(R.id.fl_signin_content, fragment).commit();
        } else {
            ft.show(fragment).commit();
        }
    }
}
