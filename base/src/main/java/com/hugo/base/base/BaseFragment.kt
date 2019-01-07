package com.hugo.base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.hugo.base.utils.ToastUtil
import com.hugo.idialog.R
import com.hugo.idialog.dialog.HugoDialog
import com.trello.rxlifecycle3.components.support.RxFragment
import java.lang.reflect.ParameterizedType

/**
 * @author  作者：hugo
 * @date    时间：2019/1/3.
 * 版本：v1.0
 * 描述：
 */
abstract class  BaseFragment<V: ViewDataBinding,VM:BaseViewModel> : RxFragment(),BaseUnifiedFunction<VM> {
    private  var viewModel: VM? = null

    private lateinit var binding:V

    private var viewModelId = 0

    private lateinit var mDialog: HugoDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        initData()
        return initViewObservable(inflater, container, savedInstanceState)
    }


    override fun showToast(message: String) {
        ToastUtil.showToast(message)
    }

    override fun showToast(message: Int) {
        ToastUtil.showToast(message)
    }

    override fun showIDialog() {

        showIDialog(getString(R.string.dialog_loading_hint))
    }

    override fun showIDialog(message: String) {
        if (context == null){
            return
        }
        if (!::mDialog.isInitialized){
            mDialog = HugoDialog.HugoLoadingBuilder(this.context!!).create()
        }
        if(mDialog.isShowing){
            mDialog.dismiss()
        }
        mDialog.setText(R.id.tv_dialog_loading_hint,message).show()
    }

    /**
     * ViewModel生命周期绑定
     */
    fun initViewObservable(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?):View {
        binding = DataBindingUtil.inflate(inflater,getLayout(savedInstanceState),container,false)

        viewModelId = getVariableId()

        viewModel = getViewModel1()
        if (viewModel == null){

            val type = javaClass.genericSuperclass
            val modelClass: Class<BaseViewModel> =if(type is ParameterizedType){
                type.actualTypeArguments[1] as Class<BaseViewModel>
            }else{
                //如果没有指定泛型参数，则默认使用BaseViewModel
                BaseViewModel::class.java
            }
            viewModel = createViewModel(this,modelClass) as VM
        }

        //绑定ViewModel
        binding.setVariable(viewModelId,viewModel)
        //让ViewModel拥有View的生命周期感应
        viewModel?.let { lifecycle.addObserver(it) }
        //注入Rx用的生命周期  保证不内存泄漏
        viewModel?.injectLifecycleProvider(this)

        return binding.root
    }

    private fun<T: ViewModel> createViewModel(fragment: Fragment, modelClass: Class<T>): T? {
        return ViewModelProviders.of(fragment).get(modelClass)
    }


}