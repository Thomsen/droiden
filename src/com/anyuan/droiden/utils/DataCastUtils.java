package com.anyuan.droiden.utils;

/**
 * Created with IntelliJ IDEA.
 * User: thom
 * Date: 3/9/13
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataCastUtils {

    public static String castString(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }
}
