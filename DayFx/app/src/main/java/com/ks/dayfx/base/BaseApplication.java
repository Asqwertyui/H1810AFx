package com.ks.dayfx.base;

import android.app.Application;

/**
 * Created by F0519 on 2019/6/5.
 */

public class BaseApplication extends Application {
    private static BaseApplication baseApplication;

    public BaseApplication() {
        baseApplication=this;
    }

    public static BaseApplication getBaseApplication() {
        return baseApplication;
    }
}
