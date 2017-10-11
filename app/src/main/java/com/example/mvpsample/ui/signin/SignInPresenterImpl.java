package com.example.mvpsample.ui.signin;

import com.example.mvpsample.network.RestClient;
import com.example.mvpsample.ui.base.BasePresenterImpl;

/**
 * Created by cl-macmini-01 on 9/20/17.
 */

public class SignInPresenterImpl extends BasePresenterImpl implements SignInPresenter {

    private SignInView mSignInView;
    private SignInService mSignInService;

    SignInPresenterImpl(SignInView signInView) {
        mSignInView = signInView;
        mSignInService = new SignInServiceImpl(RestClient.getRestService());

    }

    @Override
    public void onSignInClicked(String email, String password) {

        mSignInService.login(email, password, new SignInService.OnLoginListener() {
            @Override
            public void onEmailError(int resId) {

                if (mSignInView != null) {
                    mSignInView.showErrorMessage(resId);
                }
            }

            @Override
            public void onPasswordError(int resId) {

                if (mSignInView != null) {
                    mSignInView.showErrorMessage(resId);
                }
            }

            @Override
            public void onLoginSuccess() {
                if (mSignInView != null) {
                    mSignInView.signInSuccess();
                }
            }

            @Override
            public void onLoginFail(final String error) {
                if (mSignInView != null) {
                    mSignInView.showLoginError(error);
                }
            }
        });
    }


}
