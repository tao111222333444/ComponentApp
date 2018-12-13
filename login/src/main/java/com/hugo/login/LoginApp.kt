package com.hugo.login

import android.app.Application
import com.facebook.stetho.common.LogUtil
import com.hugo.base.BaseApp

/**
 * @author  作者：hugo
 * @date    时间：2018/12/12.
 * 版本：v1.0
 * 描述：
 */
class LoginApp: BaseApp() {
    override fun onCreate() {
        super.onCreate()
        LogUtil.e("这是 LoginApp")
    }

    override fun initModuleApp(application: Application?) {

    }

    override fun initModuleData(application: Application?) {

    }

}