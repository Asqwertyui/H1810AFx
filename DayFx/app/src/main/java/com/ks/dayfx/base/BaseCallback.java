package com.ks.dayfx.base;

/**
 * Created by F0519 on 2019/6/5.
 */

public interface BaseCallback<T> {
    void OnSuccess(T t);
    void OnFail(String msg);
}
