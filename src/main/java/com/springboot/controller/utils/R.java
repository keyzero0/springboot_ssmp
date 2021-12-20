package com.springboot.controller.utils;

import lombok.Data;

/**
 * @author sunmoon
 * @create 2021-12-17-19:45
 */
@Data
public class R {
    private Object data;
    private boolean flag;
    private String msg;
    public R(){

    }

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }
    public R(boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }
}
