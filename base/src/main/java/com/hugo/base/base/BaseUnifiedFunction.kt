package com.hugo.base.base

import android.os.Bundle
import androidx.annotation.StringRes

/**
 * @author  作者：hugo
 * @date    时间：2018/12/15.
 * 版本：v1.0
 * 描述：统一activity 和 fragment
 */
interface BaseUnifiedFunction<VM:BaseViewModel> {

    fun showToast(message:String)

    fun showToast(@StringRes message:Int)

    fun showIDialog()

    fun showIDialog(message:String)

    /**
     * 设置布局
     */
    fun getLayout(savedInstanceState: Bundle?): Int

    /**
     * 获取VIewModel的id
     * @return BR的id
     */
    fun getVariableId():Int

    /**
     * 设置title
     */
    fun setTitle(title:String)



    /**
     * 初始化 页面数据
     */
    fun initData()



    /**
     * 设置ViewModel
     */
    fun getViewModel1():VM?{
        return null
    }


}