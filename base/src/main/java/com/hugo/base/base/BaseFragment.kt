package com.hugo.base.base

import android.os.Bundle
import android.view.View
import com.hugo.base.utils.ToastUtil
import com.trello.rxlifecycle3.components.RxFragment

/**
 * @author  作者：hugo
 * @date    时间：2019/1/3.
 * 版本：v1.0
 * 描述：
 */
abstract class  BaseFragment<VM:BaseViewModel> : RxFragment(),BaseUnifiedFunction<VM> {


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initViewObservable()

    }

    override fun showToast(message: String) {
        ToastUtil.showToast(message)
    }

    override fun showToast(message: Int) {
        ToastUtil.showToast(message)
    }



    override fun initViewObservable() {

    }



}