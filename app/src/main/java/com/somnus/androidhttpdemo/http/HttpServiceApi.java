package com.somnus.androidhttpdemo.http;


import com.somnus.androidhttpdemo.ui.entity.BookListDto;
import com.somnus.androidhttpdemo.ui.entity.HttpResultBase;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * API接口
 */
public interface HttpServiceApi {

    //获取视频地址
//    @GET("video/getVideoList")
//    Observable<HttpResult<List<VideoListDto>>> getVideoList();

    //根据图书类别获得图书列表
    @GET("api/getTypeBooks")
    Observable<HttpResultBase<List<BookListDto>>> getBookList(@Query("type") String type, @Query("pageIndex") int pageIndex);
}
