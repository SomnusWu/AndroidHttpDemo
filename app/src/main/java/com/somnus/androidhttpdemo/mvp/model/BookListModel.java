package com.somnus.androidhttpdemo.mvp.model;


import com.somnus.androidhttpdemo.http.HttpRequest;
import com.somnus.androidhttpdemo.mvp.listener.OnLoadDataListListener;
import com.somnus.androidhttpdemo.ui.entity.BookListDto;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class BookListModel {

    public void LoadData(String type, int pageIndex, final OnLoadDataListListener listener) {
        HttpRequest.getInstance().HttpDataToSchoolList(type, pageIndex, new Observer<List<BookListDto>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<BookListDto> value) {
                listener.onSuccess(value);
            }

            @Override
            public void onError(Throwable e) {
                //设置页面为加载错误
                listener.onFailure(e);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
