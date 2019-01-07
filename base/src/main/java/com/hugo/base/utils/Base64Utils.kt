package com.hugo.base.utils

import android.util.Base64
import java.util.*

/**
 * @author  作者：hugo
 * @date    时间：2019/1/4.
 * 版本：v1.0
 * 描述：Base64 编码  解码
 */
object Base64Utils{

    /**
     * 进行Base64编码
     */
    fun encodeBase64(string: String):String{
        var result:String = ""
        result = String(Base64.encode(string.toByteArray(Charsets.UTF_8),Base64.DEFAULT),Charsets.UTF_8)
        return result
    }

    /**
     * 进行Base64解码
     */
    fun decodeBase64(string: String):String{
        var result:String = ""
        result = String(Base64.decode(string.toByteArray(Charsets.UTF_8),Base64.DEFAULT),Charsets.UTF_8)
        return result
    }

    /**
     * 获取随机数
     * @i 获取随机多少位随机数
     */
    fun randomHexString(i:Int):String{
        val result = StringBuilder()
        val random = Random()
        var str:String
        repeat(i){
            str =random.nextInt(16).toString(16)
            result.append(str)
        }
        return result.toString().toUpperCase()
    }

}
