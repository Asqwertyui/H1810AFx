package com.ks.dayfx.util;

import android.util.Log;

import com.ks.dayfx.BuildConfig;

/**
 * Created by $lzj on 2019/5/5.
 */
public class Logger {

    public static void logD(String tag,String msg){
        if (BuildConfig.DEBUG){
            Log.d(tag, "logD: "+msg);
        }
    }
}
