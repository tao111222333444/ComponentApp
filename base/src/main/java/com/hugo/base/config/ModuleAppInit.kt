package com.hugo.base.config

import android.app.Application

/**
 * @author  作者：hugo
 * @date    时间：2019/1/4.
 * 版本：v1.0
 * 描述：
 */
interface ModuleAppInit {
    /**
     * application 初始化
     * @param application
     */
    fun initModuleApp(application: Application)

    /**
     * application  初始化后的自定义操作
     * @param application
     */
    fun initModuleData(application: Application)
}