package com.hugo.base.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

import com.hugo.base.BuildConfig;
import com.hugo.base.utils.AppManager;
import com.hugo.base.utils.LogUtil;
import com.hugo.base.utils.SdkManager;
import com.hugo.base.utils.ToastUtil;

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

        initBase();
    }

    private void initBase() {
        INSTANCE = (Application) getApplicationContext();
        if(BuildConfig.DEBUG) {
            //调试工具
            SdkManager.initFacebookStetho(INSTANCE);
            SdkManager.initLeakCanary(INSTANCE);
        }
        Handler mainHandler = new Handler(getMainLooper());
        ToastUtil.initToast(mainHandler, INSTANCE);
        /**
         * 注册监听每个Activity的生命周期，便于堆栈管理
         */
        INSTANCE.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AppManager.getInstance().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                AppManager.getInstance().removeActivity(activity);

            }
        });
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ToastUtil.clear();
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
