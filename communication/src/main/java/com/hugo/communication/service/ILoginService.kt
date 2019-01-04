package com.hugo.communication.service

/**
 * @author  作者：hugo
 * @date    时间：2019/1/2.
 * 版本：v1.0
 * 描述：
 */
interface ILoginService {

    /**
     * 是否登录
     */
    public fun isLogin():Boolean

    /**
     * 获取UID
     */
    public fun getUid():String
}