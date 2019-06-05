package com.ks.dayfx.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by F0519 on 2019/6/5.
 */

public interface Myservice {
    //http://news-at.zhihu.com/api/4/news/hot
    public String url="http://news-at.zhihu.com/";
    @GET("api/4/news/hot")
    Observable<Hot> getHot();
}
