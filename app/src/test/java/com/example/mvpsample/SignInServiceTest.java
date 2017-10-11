package com.example.mvpsample;

import com.example.mvpsample.network.RestService;
import com.example.mvpsample.ui.signin.SignInService;
import com.example.mvpsample.ui.signin.SignInServiceImpl;
import com.example.mvpsample.util.SynchronousExecutorService;
import com.example.mvpsample.utils.FileUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cl-macmini-01 on 10/3/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class SignInServiceTest {

    @Mock
    SignInService.OnLoginListener onLoginListener;
    private RestService mRestService;
    private MockWebServer mockWebServer;

    @Before
    public void setUpRestService() throws IOException {

        mockWebServer = new MockWebServer();
        mockWebServer.start();

        mRestService = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .dispatcher(new Dispatcher(new SynchronousExecutorService()))
                        .build())
                .build().create(RestService.class);
    }

    @Test
    public void signInService_invalidEmail_callsOnEmailError() throws Exception {

        SignInServiceImpl signInService = new SignInServiceImpl(mRestService);
        signInService.login("aioo", "123456", onLoginListener);
        Mockito.verify(onLoginListener).onEmailError(Mockito.anyInt());

    }

    @Test
    public void signInService_invalidPassword_callsOnPasswordError() {

        SignInServiceImpl signInService = new SignInServiceImpl(mRestService);
        signInService.login("ai@gmail.com", "", onLoginListener);
        Mockito.verify(onLoginListener).onPasswordError(Mockito.anyInt());

    }

    @Test
    public void signInService_validEmailPassword_callsOnLoginSuccess() throws Exception {

        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(FileUtils.convertStreamToString(getClass().getClassLoader().getResourceAsStream("login_200.json"))));

        SignInServiceImpl signInService = new SignInServiceImpl(mRestService);
        signInService.login("ai@gmail.com", "123456", onLoginListener);
        Mockito.verify(onLoginListener).onLoginSuccess();


    }

    @Test
    public void signInService_invalidEmailPassword_callsOnLoginSuccess() throws Exception {

        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(400)
                .setBody(FileUtils.convertStreamToString(getClass().getClassLoader().getResourceAsStream("login_400.json"))));

        SignInServiceImpl signInService = new SignInServiceImpl(mRestService);
        signInService.login("a@gmail.com", "123456", onLoginListener);
        Mockito.verify(onLoginListener).onLoginFail("Invalid login");


    }


    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }
}
