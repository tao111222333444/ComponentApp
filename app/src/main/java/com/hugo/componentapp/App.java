package com.hugo.componentapp;

import android.app.Application;
import android.content.Context;

import com.hugo.base.config.AppConfig;
import com.hugo.base.base.BaseApp;
import com.hugo.base.config.ModuleInit;

import androidx.multidex.MultiDex;

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
        initModuleApp(this);
        initModuleData(this);
    }

    @Override
    public void initModuleApp(Application application) {
        ModuleInit.Companion.getInstance().initModuleApp(application);

    }

    @Override
    public void initModuleData(Application application) {
        ModuleInit.Companion.getInstance().initModuleData(application);

    }
}
