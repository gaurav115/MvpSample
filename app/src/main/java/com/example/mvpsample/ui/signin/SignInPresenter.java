package com.example.mvpsample.ui.signin;

import com.example.mvpsample.ui.base.BasePresenter;

/**
 * Created by cl-macmini-01 on 9/20/17.
 */

public interface SignInPresenter extends BasePresenter{

    void onSignInClicked(String email, String password);
}
