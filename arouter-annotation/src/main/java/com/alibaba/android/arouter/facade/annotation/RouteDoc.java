package com.alibaba.android.arouter.facade.annotation;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/2
 * Description : document of router command
 */
public @interface RouteDoc {
    /**
     * description
     * you can not set desc on route annotation
     */
    String desc();

    /**
     * example
     */
    String example();

    /**
     * min support plugin version, default
     */
    String minVer() default "";
}
