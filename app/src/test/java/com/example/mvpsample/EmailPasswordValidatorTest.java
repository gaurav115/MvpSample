package com.example.mvpsample;

import com.example.mvpsample.utils.ValidationUtils;

import org.junit.Assert;
import org.junit.Test;

public class EmailPasswordValidatorTest {

    @Test
    public void emailValidator_incorrectMail_returnsFalse() throws Exception {
        Assert.assertEquals(false, ValidationUtils.checkEmail("aba@i"));
    }

    @Test
    public void emailValidator_correctMail_returnsTrue() throws Exception {
        Assert.assertEquals(true, ValidationUtils.checkEmail("aba@gmail.com"));
    }

    @Test
    public void passwordValidator_emptyPassword_returnsFalse() throws Exception {
        Assert.assertEquals(false, ValidationUtils.checkPassword(""));
    }

    @Test
    public void passwordValidator_invalidPassword_returnsFalse() throws Exception {
        Assert.assertEquals(false, ValidationUtils.checkPassword("   "));
    }

    @Test
    public void passwordValidator_passwordLengthLessThanSix_returnsFalse() throws Exception {
        Assert.assertEquals(false, ValidationUtils.checkPassword("12345"));
    }
}