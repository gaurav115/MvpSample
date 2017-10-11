package com.example.mvpsample.network;


import com.example.mvpsample.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public final class RestClient {

    private static Retrofit retrofit = null;

    /**
     * Empty Constructor
     * not called
     */
    private RestClient() {
    }

    /**
     * Gets api interface.
     *
     * @return object of ApiInterface
     */
    public static RestService getRestService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient().build())
                    .build();
        }
        return retrofit.create(RestService.class);
    }



    /**
     * @return object of OkHttpClient.Builder
     */
    private static OkHttpClient.Builder httpClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors
        httpClient.addInterceptor(getLoggingInterceptor());
        return httpClient;
    }

    /**
     * Method to get object of HttpLoggingInterceptor
     *
     * @return object of HttpLoggingInterceptor
     */
    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        //logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return logging;
    }
}
