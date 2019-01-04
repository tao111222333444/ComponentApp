package com.hugo.communication

import com.hugo.communication.defaultMock.MockLoginService
import com.hugo.communication.service.ILoginService

/**
 * @author 作者：hugo
 * @date 时间：2018/12/11.
 * 版本：v1.0
 * 描述：各个模块or 组件提供给外部的服务的工厂类
 */
class ServiceFactory
/**
 * 禁止外部创建ServiceFactory
 */
private constructor() {
    /**
     * 登录组件提供的服务
     */
    /**
     * 返回登录组件的服务
     * @return ILoginService
     */
    /**
     * 设置登录组件服务
     * @param loginService
     */
    var loginService: ILoginService? = null
        get() {
            if (field == null) {
                this.loginService = MockLoginService()
            }
            return field
        }

    private object Inner {
        val serviceFactory = ServiceFactory()
    }

    companion object {

        /**
         * 通过静态内部类方式实现serviceFactory的单例
         * @return ServiceFactory
         */
        val instance: ServiceFactory
            get() = Inner.serviceFactory
    }
}
