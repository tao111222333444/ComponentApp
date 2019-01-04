package com.hugo.login

import android.app.Application
import com.hugo.base.base.BaseApp
import com.hugo.base.utils.LogUtil

/**
 * @author  作者：hugo
 * @date    时间：2018/12/12.
 * 版本：v1.0
 * 描述：
 */
class LoginApp: BaseApp() {
    override fun initModuleApp(application: Application) {
        LogUtil.e("hugo","这是 LoginApp initModuleApp")
    }

    override fun initModuleData(application: Application) {
        LogUtil.e("hugo","这是 LoginApp initModuleData")
    }

    override fun onCreate() {
        super.onCreate()
        LogUtil.e("hugo","这是 LoginApp")
    }


}