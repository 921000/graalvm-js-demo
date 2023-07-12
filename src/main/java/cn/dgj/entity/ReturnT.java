package cn.dgj.entity;

import java.io.Serializable;

/**
 * common return
 * @param <T>
 * @author piesat 2015-12-4 16:32:31
 */
public class ReturnT<T> implements Serializable {
    public static final long serialVersionUID = 42L;

    public static final int SUCCESS_CODE = 200;

    public static final int BAD_REQUEST = 400;

    public static final int FAIL_CODE = 500;

    public static final int CODE_OK = 200;

    public static final int CODE_ERROR_SECURITY = 500;
    //验证码错误
    public static final int CODE_ERROR_PHONE = 501;
    //手机格式不正确
    public static final int CODE_ERROR_USER = 502;
    //用户没有注册
    public static final int CODE_NOAUTHENTION = 100;
    //没有权限

    public static final int REQUEST_ERROR = 400;
    //参数错误
    public static final ReturnT<String> SUCCESS = new ReturnT<String>(null);
    public static final ReturnT<String> FAIL = new ReturnT<String>(FAIL_CODE, null);

    private int code;
    private String msg;
    private T data;

    public ReturnT() {
    }

    public ReturnT(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReturnT(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ReturnT(T data) {
        this.code = SUCCESS_CODE;
        this.data = data;
    }

    public ReturnT(T data, String msg) {
        this.code = SUCCESS_CODE;
        this.data = data;
        this.msg = msg;
    }

    public static <T> ReturnT<T> success() {
        ReturnT<T> returnT = new ReturnT<T>();
        returnT.setCode(SUCCESS_CODE);
        returnT.setMsg("success");
        return returnT;
    }

    public static <T> ReturnT<T> success(T data) {
        ReturnT<T> returnT = new ReturnT<T>();
        returnT.setCode(SUCCESS_CODE);
        returnT.setMsg("success");
        returnT.setData(data);
        return returnT;
    }

    public static <T> ReturnT<T> failed() {
        ReturnT<T> returnT = new ReturnT<T>();
        returnT.setCode(FAIL_CODE);
        returnT.setMsg("failed");
        return returnT;
    }

    public static <T> ReturnT<T> failed(T data) {
        ReturnT<T> returnT = new ReturnT<T>();
        returnT.setCode(FAIL_CODE);
        returnT.setMsg("failed");
        returnT.setData(data);
        return returnT;
    }

    public static <T> ReturnT<T> failed(Integer code,String msg,T data) {
        ReturnT<T> returnT = new ReturnT<T>();
        returnT.setCode(code);
        returnT.setMsg(msg);
        returnT.setData(data);
        return returnT;
    }

    public static <T> ReturnT<T> failed(Integer code,String msg) {
        ReturnT<T> returnT = new ReturnT<T>();
        returnT.setCode(code);
        returnT.setMsg(msg);
        return returnT;
    }

    public static <T> ReturnT<T> failedMsg(String msg) {
        ReturnT<T> returnT = new ReturnT<T>();
        returnT.setCode(FAIL_CODE);
        returnT.setMsg(msg);
        returnT.setData((T) "0");
        return returnT;
    }


    public int getCode() {
        return code;
    }

    public ReturnT<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ReturnT<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ReturnT<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ReturnT [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

}
