package com.somnus.androidhttpdemo.http;

import com.somnus.androidhttpdemo.http.retrofit.ApiException;
import com.somnus.androidhttpdemo.http.retrofit.RetrofitUtils;
import com.somnus.androidhttpdemo.ui.entity.BookListDto;
import com.somnus.androidhttpdemo.ui.entity.HttpResultBase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @date： 2016/11/4.
 * @FileName: com.somnus.androidhttpdemo.http.HttpRequest.java
 * @author: Somnus
 * @Description:
 */

public class HttpRequest extends RetrofitUtils {

    //获取单例
    public static HttpRequest getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpRequest INSTANCE = new HttpRequest();
    }

    protected static final HttpServiceApi service = getRetrofit().create(HttpServiceApi.class);


    //请求列表数据
    public void HttpDataToSchoolList(String type, int pageIndex, Observer<List<BookListDto>> observer) {
        Observable observable = service.getBookList(type, pageIndex).map(new HttpResultFunc<List<BookListDto>>());
        setSubscribe(observable, observer);
    }

    /**
     * 插入观察者
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }


    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Function<HttpResultBase<T>, T> {
        @Override
        public T apply(HttpResultBase<T> tHttpResultBase) throws Exception {
            if (tHttpResultBase.getCode() != 1) {
                throw new ApiException(tHttpResultBase);
            }
            return tHttpResultBase.getData();
        }
    }


}
