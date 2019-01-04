package com.hugo.communication.defaultMock

import com.hugo.communication.service.ILoginService

/**
 * @author  作者：hugo
 * @date    时间：2019/1/2.
 * 版本：v1.0
 * 描述：login 服务模拟类
 */
class MockLoginService :ILoginService{
    override fun isLogin(): Boolean {
        return true
    }

    override fun getUid(): String {
        return ""
    }
}