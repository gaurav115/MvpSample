package com.example.mvpsample.ui.signin;

/**
 * Created by cl-macmini-01 on 9/27/17.
 */

public interface SignInService {

    interface OnLoginListener {

        void onEmailError(int resId);

        void onPasswordError(int resId);

        void onLoginSuccess();
    }

    void login(String email, String password, OnLoginListener loginListener);

}
