package com.shop.controller;

import com.shop.connectionDB.UserDB;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserValidity {

    public static boolean checkReg(String login, String password, String re_password, String firstName, String lastName, String age, String gender, String country, String termsOfService) {
        ArrayList<String> errorReg = new ArrayList<>();
        errorReg.add(loginValidity(login));
        errorReg.add(passwordValidity(password));
        errorReg.add(passwordReconciliation(password, re_password));
        errorReg.add(checkLength(firstName));
        errorReg.add(checkLength(lastName));
        errorReg.add(ageValidity(age));
        errorReg.add(checkLength(gender));
        errorReg.add(checkLength(country));
        errorReg.add(checkTermsOfService(termsOfService));
        return checkReg(errorReg);
    }


    public static boolean checkReg(ArrayList<String> errorLog) {
        for (String er : errorLog) {
            if (!er.equals("")) {
                return true;
            }
        }
        return false;
    }



    public static boolean loginAuthorization(String login, String password) {
        ArrayList<String> arr = UserDB.searchUser(login);
        if (arr.size() != 0 && arr.get(0).replace("`", "''").equals(login) && arr.get(1).equals(password)) {
            return false;
        } else {
            return true;
        }
    }


    public static String loginValidity(String login) {
        if (login.length() != 0 && login.matches("^[a-zA-Z0-9]{1,}" + "((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*" + "@" + "[a-zA-Z0-9]{1,}" + "((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*" + "\\.[a-zA-Z]{2,}$")) {
            return "";
        } else {
            return "please enter a valid email address";
        }
    }


    public static String passwordValidity(String password) {
        if (password.length() != 0 && password.matches("(?=.*[0-9]{2,})(?=.*[a-z]{2,})(?=.*[A-Z]{2,})[0-9a-zA-Z!@#$%^&*]{8,}")) {
            return "";
        } else {
            return "Include 2 a-z, 2 A-Z, 2 0-9";
        }

    }

    public static String passwordReconciliation(String password, String re_password) {
        if (password.length() != 0 && password.equals(re_password)) {
            return "";
        } else {
            return "Passwords do not match";
        }
    }

    public static String ageValidity(String age) {
        try {
            if (Integer.parseInt(age) > 12) {
                return "";
            } else {
                return "Age must be between 12";
            }
        } catch (NumberFormatException e) {
            return "not a number";
        }
    }

    public static String checkTermsOfService(String check) {
        if (check != null) {
            return "";
        } else {
            return "You must agree to the Subscriber Agreement to continue";
        }
    }

    public static String checkNull(String value) {
        if (value != null) {
            return "";
        } else {
            return "the field is not filled";
        }
    }
    public static String checkLength(String value) {
        if (value.length() != 0) {
            return "";
        } else {
            return "the field is not filled";
        }
    }

    public static String checkValue(String value) {
        if (!value.equals("0")) {
            return "";
        } else {
            return "the field is not filled";
        }
    }

}
