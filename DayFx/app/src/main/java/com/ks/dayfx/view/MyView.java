package com.ks.dayfx.view;

import com.ks.dayfx.base.BaseView;
import com.ks.dayfx.bean.Hot;

/**
 * Created by F0519 on 2019/6/5.
 */

public interface MyView extends BaseView {
    void OnSuccess(Hot hot);
    void OnFail(String msg);
}
