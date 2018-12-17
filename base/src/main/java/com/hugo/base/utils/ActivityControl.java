package com.hugo.base.utils;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/**
 * 类描述    :管理所有Activity
 * 类名称    : ActivityControl
 * 修改时间  :
 * 修改备注  :
 */
public class ActivityControl {
    private Stack<Activity> allActivities;

    /**
     * 禁止外部访问
     */
    private ActivityControl(){}

    /**
     * 获取对象
     * @return ActivityControl
     */
    public static ActivityControl getInstance(){
        return Inner.inner;
    }

    /**
     * 静态内部类实现单例
     */
    private static class Inner{
        private static ActivityControl inner = new ActivityControl();
    }

    /**
     * 描述      :  获取当前运行的Activity,有可能返回null
     * 方法名    :  getCurrentAtivity
     * param    : 无
     * 返回类型  : BaseActivity
     */
    public Activity getCurrentAtivity() {
        return allActivities.lastElement();
    }

    /**
     * 描述      : 添加Activity到管理
     * 方法名    :  addActivity
     * param    :   act Activity
     */
    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new Stack<>();
        }
        allActivities.add(act);
    }

    /**
     * 描述      :从管理器移除Activity，一般在Ondestroy移除，防止强引用内存泄漏
     * 方法名    :  removeActivity
     * param    :   act Activity
     * 返回类型  : void
     */
    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 是否还有activity
     * @return
     */
    public boolean isActivity(){
        if(allActivities != null ){
            return !allActivities.isEmpty();
        }
        return false;
    }


    /**
     * 描述      :关闭所有Activity
     * 方法名    :  finishiAll
     * param    :无
     * 返回类型  :void
     * 创建人    : ghy
     */
    public void finishiAll() {
        if (allActivities != null) {
            for (Activity act : allActivities) {
                act.finish();
            }
        }
    }


    /**
     * 描述      :关闭所有Activity 除了对应的activity
     * 方法名    :  finishiAll
     * param    :无
     * 返回类型  :void
     */
    public void finishiAllExcept(Activity activity) {
        if (allActivities != null) {
            for (Activity act : allActivities) {
                if (act!=activity){
                    act.finish();
                }
            }
        }
    }

    /**
     * 退出应用程序
     */
    public void appExit() {
        try {
            finishiAll();
            // 杀死该应用进程
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
