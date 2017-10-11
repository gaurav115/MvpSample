package com.example.mvpsample.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommonResponse {

    @SerializedName("status")
    @Expose
    private int statusCode;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private Object data;

    /**
     * Get the data
     *
     * @return data object
     */
    public Object getData() {
        return data;
    }

    /**
     * Get message from api response
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get status code of api response
     *
     * @return statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return statusCode + " " + message + "\n" + data;
    }
}
