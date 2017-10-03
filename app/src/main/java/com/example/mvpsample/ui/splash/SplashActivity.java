package com.example.mvpsample.ui.splash;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.example.mvpsample.R;
import com.example.mvpsample.ui.base.BaseActivity;
import com.example.mvpsample.ui.signin.SignInActivity;

/**
 * Created by cl-macmini-01 on 9/19/17.
 */

public class SplashActivity extends BaseActivity implements SplashView {

    private SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashPresenter = new SplashPresenterImpl(this);
        mSplashPresenter.init();

    }


    @Override
    public void launchSignIn() {

        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }


    @Override
    public void showNetworkError() {

        new AlertDialog.Builder(SplashActivity.this)
                .setMessage(R.string.error_internet_not_connected)
                .setPositiveButton(R.string.txt_retry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        mSplashPresenter.init();
                    }
                })
                .show();
    }

}
