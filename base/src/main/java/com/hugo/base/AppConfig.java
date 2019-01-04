package com.hugo.base;

/**
 * @author 作者：hugo
 * @date 时间：2018/12/11.
 * 版本：v1.0
 * 描述：用于保存 各个module 的 application 完整类名
 * 用于在
 */
public class AppConfig {
    private static final String LoginApp = "com.hugo.login.LoginApp";

    public static String[] moduleApps = {
            LoginApp
    };
}
