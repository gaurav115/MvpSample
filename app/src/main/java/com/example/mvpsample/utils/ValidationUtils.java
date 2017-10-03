package com.example.mvpsample.utils;

import java.util.regex.Pattern;

/**
 * Created by cl-macmini-01 on 9/28/17.
 */

public class ValidationUtils {

    public static final String REGEX_EMAIL_ADDRESS = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";

    private static final int PASSWORD_LENGTH = 6;


    private ValidationUtils() {
    }

    /**
     * Method to validate email id
     *
     * @param email user email
     * @return whether email is valid
     */
    public static boolean checkEmail(final String email) {
        if (email.trim().length() == 0) {
            return false;
        }
        if (!email.matches(Pattern.compile(REGEX_EMAIL_ADDRESS).toString())) {
            return false;
        }
        return true;
    }

    /**
     * Method to validate password
     *
     * @param password user entered password
     * @return whether the password is valid
     */
    public static boolean checkPassword(final String password) {
        if (password.trim().length() == 0) {
            return false;
        }
        if (password.length() < PASSWORD_LENGTH) {
            return false;
        }
        return true;
    }


}
