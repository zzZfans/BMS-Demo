package com.zfans.bmsdemo.handler;


import com.zfans.bmsdemo.exception.BMSDemoException;
import com.zfans.bmsdemo.ret.R;
import com.zfans.bmsdemo.ret.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionHandler
 * @Author Zfans
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        log.error(e.getMessage(), e.getCause());
        return R.error();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public R error(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e.getCause());
        return R.setResult(ResultCodeEnum.PARAM_ERROR)
                .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(BMSDemoException.class)
    @ResponseBody
    public R error(BMSDemoException e) {
        log.error(String.valueOf(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
