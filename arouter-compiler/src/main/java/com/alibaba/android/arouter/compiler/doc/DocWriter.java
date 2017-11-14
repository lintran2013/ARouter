package com.alibaba.android.arouter.compiler.doc;

import java.util.List;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/3
 * Description : This is a description example
 */
public interface DocWriter {
    /**
     * 写入文档
     * @param routeEntryList 当前模块跳转命令信息
     */
    void write(List<RouteEntry> routeEntryList);
}
