package com.hugo.communication;

/**
 * @author 作者：hugo
 * @date 时间：2018/12/11.
 * 版本：v1.0
 * 描述：各个模块or 组件提供给外部的服务的工厂类
 */
public class ServiceFactory {

    private static class Inner{
        private static ServiceFactory serviceFactory = new ServiceFactory();
    }
    /**
     * 禁止外部创建ServiceFactory
     */
    private ServiceFactory(){}

    /**
     *  通过静态内部类方式实现serviceFactory的单例
     * @return ServiceFactory
     */
    public static ServiceFactory getInstance(){
        return Inner.serviceFactory;
    }


}
