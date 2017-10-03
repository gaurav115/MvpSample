package com.example.mvpsample.ui.splash;


import com.example.mvpsample.ui.base.BasePresenterImpl;

/**
 * Created by cl-macmini-01 on 9/19/17.
 */

class SplashPresenterImpl extends BasePresenterImpl implements SplashPresenter {

    private SplashView mSplashView;

    SplashPresenterImpl(SplashView splashView) {
        mSplashView = splashView;
    }

    public void init() {

        if (mSplashView.isNetworkConnected()) {
            mSplashView.launchSignIn();
        } else {
            mSplashView.showNetworkError();
        }

    }

}
