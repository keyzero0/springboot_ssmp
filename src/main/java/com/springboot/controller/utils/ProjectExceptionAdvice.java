package com.springboot.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sunmoon
 * @create 2021-12-18-23:02
 */
//作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
        @ExceptionHandler(Exception.class)
        public R doException(Exception ex){
            ex.printStackTrace();
            return new R("服务器故障请稍后再试");
        }
}
