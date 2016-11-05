package com.somnus.androidhttpdemo.http.retrofit;


import com.somnus.androidhttpdemo.ui.entity.HttpResultBase;

/**
 * 异常类
 * 按照自己公司的接口需求来  不可直接套用
 * 使用需谨慎
 * 有什么问题可以联系我
 */
public class ApiException extends RuntimeException {


    public ApiException(HttpResultBase httpResult) {
        this(getApiExceptionMessage(httpResult));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 对服务器接口传过来的错误信息进行统一处理
     * 免除在Activity的过多的错误判断
     */
    private static String getApiExceptionMessage(HttpResultBase httpResult) {
        String message = "";
        switch (httpResult.getCode()) {
            default:
                message = "与服务端链接错误" + httpResult.getCode();

        }
        return message;
    }
}

