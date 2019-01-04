package com.hugo.base.base


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.hugo.base.utils.ToastUtil
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

/**
 * @author 作者：hugo
 * @date 时间：2018/12/12.
 * 版本：v1.0
 * 描述：基础
 */
 abstract class BaseActivity<VM:BaseViewModel>: RxAppCompatActivity(),BaseUnifiedFunction<VM>{
    private  var viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        //初始化View
        initView()
        //初始化页面数据
        initData()

        initViewObservable()

    }

    override fun initViewObservable() {
        viewModel = getViewModel1()
        if (viewModel == null){

            val type = javaClass.genericSuperclass
            var modelClass: Class<BaseViewModel> =if(type is ParameterizedType){
                type.actualTypeArguments[1] as Class<BaseViewModel>
            }else{
                BaseViewModel::class.java
            }
            viewModel = createViewModel(this,modelClass) as VM
        }
        viewModel?.let { lifecycle .addObserver(it) }

    }

    override fun showToast(message: String) {
        ToastUtil.showToast(message)
    }

    override fun showToast(message: Int) {
        ToastUtil.showToast(message)
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    fun <VM : ViewModel?> createViewModel(activity:FragmentActivity, cls :Class<VM> ): VM? {
        return ViewModelProviders.of(activity).get(cls)
    }

}
