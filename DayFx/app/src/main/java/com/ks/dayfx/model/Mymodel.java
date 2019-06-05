package com.ks.dayfx.model;

import com.ks.dayfx.base.BaseCallback;
import com.ks.dayfx.base.BaseModel;
import com.ks.dayfx.base.BaseObserver;
import com.ks.dayfx.bean.Hot;
import com.ks.dayfx.bean.Myservice;
import com.ks.dayfx.util.HttpUtil;
import com.ks.dayfx.util.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by F0519 on 2019/6/5.
 */

public  class Mymodel extends BaseModel {

    public void getData(final BaseCallback<Hot> baseCallback) {
        Myservice myservice = HttpUtil.getHttpUtil().getApiservice(Myservice.url, Myservice.class);
        Observable<Hot> hot = myservice.getHot();
        hot.compose(RxUtil.<Hot>op())
                .subscribe(new BaseObserver<Hot>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Hot hot) {
                    if(hot!=null){
                        baseCallback.OnSuccess(hot);
                    }else {
                        baseCallback.OnFail("no");
                    }
                    }
                });
    }
}
