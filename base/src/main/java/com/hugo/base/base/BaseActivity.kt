package com.hugo.base.base


import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.hugo.base.utils.ToastUtil
import com.hugo.idialog.R
import com.hugo.idialog.dialog.HugoDialog
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

/**
 * @author 作者：hugo
 * @date 时间：2018/12/12.
 * 版本：v1.0
 * 描述：基础
 */
 abstract class BaseActivity<V:ViewDataBinding,VM:BaseViewModel>: RxAppCompatActivity(),BaseUnifiedFunction<VM>{
    private  var viewModel: VM? = null

    private  lateinit var binding:V

    private var viewModelId:Int = 0

    private lateinit var mDialog: HugoDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //初始化页面数据
        initData()

        initViewObservable(savedInstanceState)

    }

    /**
     * ViewModel生命周期绑定
     */
    fun initViewObservable(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this,getLayout(savedInstanceState))
        viewModel = getViewModel1()

        viewModelId = getVariableId()
        if (viewModel == null){

            val type = javaClass.genericSuperclass
            val modelClass: Class<BaseViewModel> =if(type is ParameterizedType){
                type.actualTypeArguments[1] as Class<BaseViewModel>
            }else{
                BaseViewModel::class.java
            }
            viewModel = createViewModel(this,modelClass) as VM
        }
        binding.setVariable(viewModelId,viewModel)

        viewModel?.let { lifecycle .addObserver(it) }
        //注入Rx用的生命周期  保证不内存泄漏
        viewModel?.injectLifecycleProvider(this)
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
        if (!::mDialog.isInitialized){
            mDialog = HugoDialog.HugoLoadingBuilder(this).create()
        }
        if(mDialog.isShowing){
            mDialog.dismiss()
        }
        mDialog.setText(R.id.tv_dialog_loading_hint,message).show()
    }



    override fun onDestroy() {
        super.onDestroy()

    }

    fun <T : ViewModel?> createViewModel(activity:FragmentActivity, cls :Class<T> ): T? {
        return ViewModelProviders.of(activity).get(cls)
    }

}
