package com.app.shop.shopapp.utils;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/17 10:11
 * @version: V1.0
 */
public class Constant {
    public static final boolean DEBUG =true;
    private static final String SERVER_RLS = "http://zhonghai.apptech.space/api/";

    private static final String SERVER_DEBUG = "http://zhonghai.apptech.space/api/";
    public static final String HOST_URL = DEBUG ? SERVER_DEBUG : SERVER_RLS;
}
