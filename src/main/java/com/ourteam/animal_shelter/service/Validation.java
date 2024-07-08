package com.ourteam.animal_shelter.service;

import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static liquibase.util.SqlUtil.NAME_PATTERN;
@Service
public class Validation {

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String NAME_PATTERN ="^[a-zA-Zа-яА-Я0-9]{2,16}$";


    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String TELEPHONE_PATTERN ="^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

    private static final String BASE_STR_PATTERN ="^[^\\/:*?\"<>|+]+$";

    private static final String DATE_PATTERN ="^[0-9]{4}([- /.])(((0[13578]|(10|12))\1(0[1-9]|[1-2][0-9]|3[0-1]))|(02\1(0[1-9]|[1-2][0-9]))|((0[469]|11)\1(0[1-9]|[1-2][0-9]|30)))$";

    private static final String TIME_PATTERN="^(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})$";


public static boolean validateName(String str) {
    pattern = Pattern.compile(NAME_PATTERN);
    matcher = pattern.matcher(str);
    return matcher.matches();
}
    public static boolean validateEmail(String str) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean validateBaseStr(String str) {
        pattern = Pattern.compile(BASE_STR_PATTERN);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean validateTelephone(String str) {
        pattern = Pattern.compile(TELEPHONE_PATTERN);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean validateDate(String str) {
        pattern = Pattern.compile(DATE_PATTERN);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean findValidatePhone(String str) {
        pattern = Pattern.compile(TELEPHONE_PATTERN);
        matcher = pattern.matcher(str);
        return matcher.find();
}}
