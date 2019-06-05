package com.ks.dayfx.base;

/**
 * Created by F0519 on 2019/6/5.
 */

public abstract class BaseMvpFragment<M extends BaseModel,V extends BaseView,P extends BasePersent> extends BaseFragment {
    protected  P initPresent;

    @Override
    protected void initMvp() {
        initPresent=initMvpPersent();
        if(initPresent!=null){
           initPresent.initModel(InitMvpmodel());
            initPresent.attachView(initViewView());
        }
    }

    protected abstract V initViewView();

    protected abstract M InitMvpmodel();

    protected abstract P initMvpPersent();
}
