package com.example.mvpsample.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mvpsample.utils.NetworkUtils;

/**
 * Created by cl-macmini-01 on 9/22/17.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

    private BasePresenter mBasePresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBasePresenter = new BasePresenterImpl();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBasePresenter.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mBasePresenter.onPause();
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkAvailable(this);
    }

}

