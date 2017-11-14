package com.alibaba.android.arouter.facade.annotation;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/3
 * Description : This is a description example
 */
public @interface AutowiredDoc {
    /**
     * description
     */
    String desc();

    /**
     * example
     */
    String example();

    /**
     * list limited value, if
     */
    String limit() default "";

    /**
     * min support plugin version, default value {@link RouteDoc#minVer()}
     */
    String minVer() default "";
}
