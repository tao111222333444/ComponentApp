package com.hugo.base.base


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.hugo.base.utils.ActivityControl
import com.hugo.base.utils.ToastUtil

/**
 * @author 作者：hugo
 * @date 时间：2018/12/12.
 * 版本：v1.0
 * 描述：基础
 */
 abstract class BaseActivity:AppCompatActivity(),BaseUnifiedFunction{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        lifecycle.addObserver(getLifeListener())
        ActivityControl.getInstance().addActivity(this)
    }

    override fun showToast(message: String) {
        ToastUtil.showToast(message)
    }

    override fun showToast(message: Int) {
        ToastUtil.showToast(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityControl.getInstance().removeActivity(this)
    }

}
