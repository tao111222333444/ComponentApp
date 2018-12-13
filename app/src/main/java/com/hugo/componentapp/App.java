package com.hugo.componentapp;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.hugo.base.BaseApp;

/**
 * @author 作者：hugo
 * @date 时间：2018/12/12.
 * 版本：v1.0
 * 描述：
 */
public class App extends BaseApp {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void initModuleApp(Application application) {

    }

    @Override
    public void initModuleData(Application application) {

    }
}
