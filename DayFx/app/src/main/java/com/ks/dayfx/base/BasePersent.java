package com.ks.dayfx.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by F0519 on 2019/6/5.
 */

public abstract class BasePersent<M extends BaseModel,V extends BaseView> {
    protected List<BaseModel> list=new ArrayList<>();
    protected M Mymodel;
    protected V Myview;
    public  void initModel(M m) {
        this.Mymodel=m;
    }

    public void attachView(V v) {
        this.Myview=v;
    }
    public void destroy(){
        if(Myview!=null){
            Myview=null;
        }
        if(Mymodel!=null){
            Mymodel=null;
        }
        if(list!=null&&list.size()>0){
            for (BaseModel basemodel:list) {
                basemodel.clear();
            }
        }
    }
}
