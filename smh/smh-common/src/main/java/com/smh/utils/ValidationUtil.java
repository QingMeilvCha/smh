package com.smh.utils;

import org.springframework.stereotype.Component;

/**
 * Created by 周宇航 on 2018/12/17.
 */
public class ValidationUtil {

    /**
     * 判断字符串是否满足手机正则
     * @param str 手机号
     * @return 判断结果
     */
    public static boolean checkPhone(String str) {
        // 手机正则
        String phone = "(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7}";
        return str.matches(phone);
    }

    /**
     * <判断邮箱格式是否满足条件>
     * @param emailStr
     * 需要校验的邮箱字符串
     */
    public static boolean checkEmail(String emailStr) {
        // 邮箱正则
        String emailRegStr = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return emailStr.matches(emailRegStr);
    }
}
