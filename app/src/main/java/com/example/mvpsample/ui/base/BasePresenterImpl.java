package com.example.mvpsample.ui.base;

/**
 * Created by cl-macmini-01 on 9/22/17.
 */

public class BasePresenterImpl implements BasePresenter {

    private boolean mIsViewResumed;

    @Override
    public void onPause() {

        mIsViewResumed = false;
    }

    @Override
    public void onResume() {
        mIsViewResumed = true;
    }

    public boolean isViewVisible() {
        return mIsViewResumed;
    }
}
