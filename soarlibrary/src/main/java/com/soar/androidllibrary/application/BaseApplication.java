package com.soar.androidllibrary.application;

import android.app.Application;

import com.soar.androidllibrary.utils.Config;

/**
 * Created by gaofei on 2016/4/26.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        Config.CACHAE_DIR=getCacheDir();
        super.onCreate();
    }
}
