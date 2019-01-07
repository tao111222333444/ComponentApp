package com.hugo.base.config

import android.app.Application
import com.hugo.base.base.BaseApp
import kotlin.reflect.KClass

/**
 * @author  作者：hugo
 * @date    时间：2019/1/4.
 * 版本：v1.0
 * 描述：
 */
class ModuleInit

private constructor():ModuleAppInit{
    override fun initModuleApp(application: Application) {
       for(item in AppConfig.moduleApps){
           try {
           val clazz = Class.forName(item)
           val baseApp: BaseApp = clazz.newInstance() as BaseApp
           baseApp.initModuleApp(application)
           }catch (e:ClassNotFoundException ) {
               e.printStackTrace()
           } catch (e:InstantiationException ) {
               e.printStackTrace()
           } catch (e:IllegalAccessException ) {
               e.printStackTrace()
           }
       }
    }

    override fun initModuleData(application: Application) {
        for (item in AppConfig.moduleApps){
            try {
                val clazz = Class.forName(item)
                val baseApp:BaseApp = clazz.newInstance() as BaseApp
                baseApp.initModuleData(application)
            }catch (e:ClassNotFoundException ) {
                e.printStackTrace()
            } catch (e:InstantiationException ) {
                e.printStackTrace()
            } catch (e:IllegalAccessException ) {
                e.printStackTrace()
            }
        }
    }

    private object Inner{
        val instance = ModuleInit()
    }

    companion object {
        val instance :ModuleInit
        get() = Inner.instance

    }


}