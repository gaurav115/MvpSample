package com.example.mvpsample.network;

import com.example.mvpsample.network.model.CommonResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by cl-macmini-01 on 10/6/17.
 */

public interface RestService {

    /**
     * Tries to log user in
     *
     * @param map the map of params to send along
     * @return the parsed common response object
     */
    @FormUrlEncoded
    @POST("/parent_login")
    Call<CommonResponse> signIn(@FieldMap Map<String, String> map);

}
