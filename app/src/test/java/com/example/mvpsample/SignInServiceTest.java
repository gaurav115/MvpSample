package com.example.mvpsample;

import com.example.mvpsample.ui.signin.SignInService;
import com.example.mvpsample.ui.signin.SignInServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by cl-macmini-01 on 10/3/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class SignInServiceTest {

    @Mock
    SignInService.OnLoginListener onLoginListener;

    @Test
    public void signInService_invalidEmail_callsOnEmailError() {

        SignInServiceImpl signInService = new SignInServiceImpl();
        signInService.login("aioo", "123456", onLoginListener);
        Mockito.verify(onLoginListener).onEmailError(Mockito.anyInt());

    }

    @Test
    public void signInService_invalidPassword_callsOnPasswordError() {

        SignInServiceImpl signInService = new SignInServiceImpl();
        signInService.login("ai@gmail.com", "", onLoginListener);
        Mockito.verify(onLoginListener).onPasswordError(Mockito.anyInt());

    }

    @Test
    public void signInService_validEmailPassword_callsOnLoginSuccess() {

        SignInServiceImpl signInService = new SignInServiceImpl();
        signInService.login("ai@gmail.com", "123456", onLoginListener);
        Mockito.verify(onLoginListener).onLoginSuccess();

    }

}
