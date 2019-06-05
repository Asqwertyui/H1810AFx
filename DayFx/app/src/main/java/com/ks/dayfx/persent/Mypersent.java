package com.ks.dayfx.persent;

import com.ks.dayfx.base.BaseCallback;
import com.ks.dayfx.base.BasePersent;
import com.ks.dayfx.bean.Hot;
import com.ks.dayfx.model.Mymodel;
import com.ks.dayfx.view.MyView;

/**
 * Created by F0519 on 2019/6/5.
 */

public class Mypersent extends BasePersent <Mymodel,MyView>{
    public void getHot() {
        if(Mymodel!=null){
            Mymodel.getData(new BaseCallback<Hot>() {
                @Override
                public void OnSuccess(Hot hot) {
                    if(Myview!=null){
                        Myview.OnSuccess(hot);
                    }
                }

                @Override
                public void OnFail(String msg) {
                    if(Myview!=null){
                        Myview.OnFail(msg);
                    }
                }
            });
        }
    }
}
