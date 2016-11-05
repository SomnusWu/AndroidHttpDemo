package com.somnus.androidhttpdemo.mvp.listener;

/**
 * 2016年11月4日 15:48:09
 * @param <T>
 */
public interface OnLoadDataListListener<T> {
    void onSuccess(T data);
    void onFailure(Throwable e);
}
