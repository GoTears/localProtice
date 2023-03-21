package com.huafa.demo.dto;

import lombok.Data;

@Data
public class R {

    // 返回的编号
    private Integer code;
    // 返回的数据,数据类型N中，
    private Object data;
    // 返回的信息
    private String message;


    public static R success(Object data, String message) {
        R r = new R();
        r.setCode(200);
        r.setData(data);
        r.setMessage(message);
        return r;
    }


    public static R success(Object data) {
        return success(data, "");
    }


    public static R fail(Integer code, String message) {
        R r = new R();
        r.setCode(code);
        r.setData(null);
        r.setMessage(message);
        return r;
    }
}
