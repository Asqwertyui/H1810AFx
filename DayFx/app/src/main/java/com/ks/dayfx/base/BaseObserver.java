package com.ks.dayfx.base;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by F0519 on 2019/6/5.
 */

public  abstract class BaseObserver<T> implements Observer <T>{
    private final String Tag=getClass().getName();

    @Override
    public void onError(Throwable e) {
        Log.e(Tag,"OnError:"+e.toString());
    }

    @Override
    public void onComplete() {
        Log.e(Tag,"onComplete");
    }
}
