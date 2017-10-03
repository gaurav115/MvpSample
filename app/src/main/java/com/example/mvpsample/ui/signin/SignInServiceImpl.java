package com.example.mvpsample.ui.signin;

import com.example.mvpsample.R;
import com.example.mvpsample.utils.ValidationUtils;

/**
 * Created by cl-macmini-01 on 9/27/17.
 */

public class SignInServiceImpl implements SignInService {


    @Override
    public void login(final String email, final String password, final OnLoginListener onLoginListener) {

        if (!ValidationUtils.checkEmail(email)) {
            onLoginListener.onEmailError(R.string.error_invalid_email);
            return;
        }

        if (!ValidationUtils.checkPassword(password)) {
            onLoginListener.onPasswordError(R.string.error_invalid_password);
            return;
        }

        //todo actual api logic
        onLoginListener.onLoginSuccess();

    }
}
