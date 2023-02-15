package com.wzq.util;

import org.apache.http.HttpStatus;

/**
 * @author wzq
 * @create 2023-02-13 21:47
 */
public class R<T> {

    private Integer code;
    private String message;
    private T data;

    public R() {
    }

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> of(Integer code, String message, T data) {
        return new R<>(code, message, data);
    }

    public static <T> R<T> ok() {
        R<T> r = new R<>();
        r.setCode(HttpStatus.SC_OK);
        r.setMessage("success");
        return r;
    }

    public static <T> R<T> ok(T data) {
        R<T> r = ok();
        r.setData(data);
        return r;
    }

    public static <T> R<T> error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static <T> R<T> error(String message) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, message);
    }

    public static <T> R<T> error(Integer code, String message) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
