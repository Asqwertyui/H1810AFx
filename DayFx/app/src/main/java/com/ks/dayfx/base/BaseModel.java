package com.ks.dayfx.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by F0519 on 2019/6/5.
 */

public abstract class BaseModel {
    protected CompositeDisposable mCompositeDisposable=new CompositeDisposable();

    public void clear() {
        mCompositeDisposable.clear();
    }
}
