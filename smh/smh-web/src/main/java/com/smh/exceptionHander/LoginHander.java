package com.smh.exceptionHander;

import com.smh.exception.LoginException;
import com.smh.response.AdusResponse;
import com.smh.sys.SysConstants;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhouyuhang on 2018/12/24.
 */
@RestControllerAdvice(basePackages = {"com.smh.user"})
public class LoginHander {

    @ExceptionHandler(LoginException.class)
    public AdusResponse defaultExceptionHandler(Exception ex, HttpServletResponse response) {
        return new AdusResponse(SysConstants.ResponseCode.FAIL, ex.getMessage(), null);
    }
}
