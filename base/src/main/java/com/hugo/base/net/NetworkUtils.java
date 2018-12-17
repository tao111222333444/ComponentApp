package com.hugo.base.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.hugo.base.BaseApp;

/**
 * @author 作者：hugo
 * @date 时间：2018/12/17.
 * 版本：v1.0
 * 描述：网络工具
 */
public class NetworkUtils {
    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApp.INSTANCE.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager == null){
            return false;
        }
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(info == null || !info.isConnected()){
            return false;
        }

        return true;
    }

}
