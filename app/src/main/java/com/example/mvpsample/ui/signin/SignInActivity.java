package com.example.mvpsample.ui.signin;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvpsample.R;
import com.example.mvpsample.ui.base.BaseActivity;

/**
 * Created by cl-macmini-01 on 9/20/17.
 */

public class SignInActivity extends BaseActivity implements View.OnClickListener, SignInView {

    private EditText mEdtEmail;
    private EditText mEdtPassword;
    private SignInPresenter mSignInPresenter;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        init();
        mSignInPresenter = new SignInPresenterImpl(this);
    }

    /**
     * Init the views
     */
    private void init() {

        mEdtEmail = (EditText) findViewById(R.id.edtEmail);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);

        mEdtPassword.setTypeface(Typeface.DEFAULT);
        mEdtPassword.setTransformationMethod(new PasswordTransformationMethod());

        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);

    }


    @Override
    public void showErrorMessage(final int resId) {
        new AlertDialog.Builder(this)
                .setMessage(resId)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    @Override
    public void signInSuccess() {

        // todo launch main / home
    }


    @Override
    public void onClick(final View v) {
        switch (v.getId()) {

            case R.id.btnSignIn:

                mSignInPresenter.onSignInClicked(mEdtEmail.getText().toString().trim(),
                        mEdtPassword.getText().toString().trim());

                break;

            default:

                break;
        }
    }


}
