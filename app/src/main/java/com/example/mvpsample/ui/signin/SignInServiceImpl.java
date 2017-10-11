package com.example.mvpsample.ui.signin;

import com.example.mvpsample.R;
import com.example.mvpsample.network.RestService;
import com.example.mvpsample.network.model.CommonResponse;
import com.example.mvpsample.utils.ValidationUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cl-macmini-01 on 9/27/17.
 */

public class SignInServiceImpl implements SignInService {

    private RestService mRestService;

    public SignInServiceImpl(RestService restService) {
        mRestService = restService;
    }

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

        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);

        mRestService.signIn(map).enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(final Call<CommonResponse> call, final Response<CommonResponse> response) {

                if (response.isSuccessful()) {
                    onLoginListener.onLoginSuccess();
                } else {
                    if(response.errorBody()!=null){
                        try {
                            CommonResponse error = new Gson().fromJson(response.errorBody().string(), CommonResponse.class);
                            onLoginListener.onLoginFail(error.getMessage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }

            @Override
            public void onFailure(final Call<CommonResponse> call, final Throwable t) {

                onLoginListener.onLoginFail(t.getMessage());
            }
        });


    }

}
