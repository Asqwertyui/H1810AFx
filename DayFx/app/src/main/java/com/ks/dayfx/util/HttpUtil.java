package com.ks.dayfx.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by F0519 on 2019/6/5.
 */

public class HttpUtil {
    private static volatile HttpUtil httpUtil;
    private final Retrofit.Builder mBuilder;

    private HttpUtil() {
        mBuilder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

    }

    public static HttpUtil getHttpUtil() {
        if(httpUtil==null){
            synchronized (HttpUtil.class){
                if(httpUtil==null){
                    httpUtil=new HttpUtil();
                }
            }
        }
        return httpUtil;
    }
    public <T> T getApiservice(String url,Class<T> tClass){
      return mBuilder.baseUrl(url).build().create(tClass);
    }
}
