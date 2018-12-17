package com.hugo.base.base

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes

/**
 * @author  作者：hugo
 * @date    时间：2018/12/15.
 * 版本：v1.0
 * 描述：统一activity 和 fragment
 */
interface BaseUnifiedFunction {

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
}