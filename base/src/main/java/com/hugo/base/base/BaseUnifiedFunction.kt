package com.hugo.base.base

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

    /**
     * 设置布局
     */
    fun getLayout(): Int

    /**
     * 设置title
     */
    fun setTitle(title:String)

    /**
     * 初始化界面观察者的监听
     */
    fun initViewObservable()

    /**
     * 初始化 页面数据
     */
    fun initData()

    /**
     * Activity初始化 View
     */
    fun initView()


    /**
     * 设置ViewModel
     */
    fun getViewModel1():VM?{
        return null
    }


}