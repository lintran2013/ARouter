package com.alibaba.android.arouter.compiler.doc;

import java.io.File;
import java.util.List;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/3
 * Description : This is a description example
 */
public class JsonTxtWriter implements DocWriter {
    @Override
    public void write(List<RouteEntry> routeEntryList) {
        File file = new File("routeDocument.txt");

    }
}
