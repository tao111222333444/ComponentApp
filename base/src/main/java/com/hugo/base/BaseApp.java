package com.hugo.base;

import android.app.Application;

import com.hugo.base.utils.LogUtil;
import com.hugo.base.utils.SdkManager;

import androidx.annotation.CallSuper;

/**
 * @author 作者：hugo
 * @date 时间：2018/12/11.
 * 版本：v1.0
 * 描述：base App 整个项目的  基础application
 */
public abstract class BaseApp extends Application {

    public static Application INSTANCE;

    @Override @CallSuper
    public void onCreate() {
        super.onCreate();
        INSTANCE = (Application) getApplicationContext();
        com.facebook.stetho.common.LogUtil.e("这是baseApp");
        if(BuildConfig.DEBUG) {
            SdkManager.initFacebookStetho(INSTANCE);
            SdkManager.initLeakCanary(INSTANCE);
        }
    }

    /**
     * application 初始化
     * @param application
     */
    public abstract void initModuleApp(Application application);

    /**
     *  application  初始化后的自定义操作
     * @param application
     */
    public abstract void initModuleData(Application application);
}
