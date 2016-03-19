package com.app.shop.shopapp;

import android.app.Application;

import com.jiongbull.jlog.JLog;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/11 15:17
 * @version: V1.0
 */
public class App extends Application {
    public  static App instance;
    public static App getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        JLog.init(this)
                .setDebug(BuildConfig.DEBUG);
    }
}
