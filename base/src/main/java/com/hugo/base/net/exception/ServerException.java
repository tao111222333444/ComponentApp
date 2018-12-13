package com.hugo.base.net.exception;

/**
 * @author 作者：hugo
 * @date 时间：2018/7/20.
 * 版本：v1.0
 * 描述：全局统一的错误
 * */
public class ServerException extends Exception{
    /**
     * 识别码
     */
    private int code;

    public ServerException(String message,int code){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
