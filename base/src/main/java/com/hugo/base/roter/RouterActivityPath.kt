package com.hugo.base.roter

/**
 * @author  作者：hugo
 * @date    时间：2019/1/4.
 * 版本：v1.0
 * 描述：ARouter单Activity跳转的统一路径注册
 */
open class RouterActivityPath {
    /**
     * 主页面 组件
     */
    object Main{
        const val MAIN = "/main"
        /**
         * 业务
         * **/
        const val PAGER_MAIN = "$MAIN/Main"
    }

    /**
     * 登录组件
     */
    object Sign{
        const val SIGN = "/sign"
        /**登录页面**/
        const val PAGER_LOGIN = "$SIGN/Login"

    }
}