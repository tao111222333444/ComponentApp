package com.hugo.base.base

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle
import com.trello.rxlifecycle3.LifecycleProvider

/**
 * @author  作者：hugo
 * @date    时间：2019/1/3.
 * 版本：v1.0
 * 描述：
 */
abstract class BaseViewModel(@NonNull application: Application):AndroidViewModel(application),IBaseViewModel {

    private lateinit var lifecycle:LifecycleProvider<*>

    /**
     * 注入RxLifecycle 生命周期
     */
    fun injectLifecycleProvider(lifecycle:LifecycleProvider<*>){
        this.lifecycle = lifecycle
    }


}