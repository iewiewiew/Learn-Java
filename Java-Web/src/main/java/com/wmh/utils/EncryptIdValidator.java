package com.wmh.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author weimenghua
 * @Date 2022-04-29 7:34
 * @Description
 */
public class EncryptIdValidator implements ConstraintValidator<EncryptId, String> {

//    由数字或者a-f的字母组成，2-5长度
    private static final Pattern PATTERN = Pattern.compile("^[a-f\\d]{2,5}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 不为null才进行校验
        if (value != null) {
            Matcher matcher = PATTERN.matcher(value);
            return matcher.find();
        }
        return true;
    }
}
