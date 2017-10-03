package com.example.mvpsample.ui.signin;


import com.example.mvpsample.ui.base.BaseView;

/**
 * Created by cl-macmini-01 on 9/20/17.
 */

public interface SignInView extends BaseView {

    void showErrorMessage(int resId);
    void signInSuccess();
}
