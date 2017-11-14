package com.alibaba.android.arouter.compiler.doc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.cache.FileTemplateLoader;
import freemarker.log.Logger;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.utility.SecurityUtilities;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/3
 * Description : This is a description example
 */
public class HtmlDocWriter implements DocWriter {
    private static final String TEMPLATE_PATH = "/build";
    private static final String TEMPLATE_FILE_NAME = "aroute_doc.ftlh";
    private static final String DOC_FILE_NAME = "arouter_doc.html";

    private Configuration mConfiguration;
    private final File mCurrentWorkDir;

    public HtmlDocWriter() {
        try {
            Logger.selectLoggerLibrary(2);
        } catch (ClassNotFoundException ignore) {
        }

        mCurrentWorkDir = new File(SecurityUtilities.getSystemProperty("user.dir"));

        try {
            mConfiguration = new Configuration();
            mConfiguration.setTemplateLoader(new FileTemplateLoader(new File(mCurrentWorkDir + TEMPLATE_PATH)));
            mConfiguration.setDefaultEncoding("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(List<RouteEntry> routeEntryList) {
        if (mConfiguration == null) {
            throw new IllegalStateException("Configuration has some error");
        }

        Map<String, Object> root = new HashMap<>();
        root.put("nodeList", routeEntryList);

        String outFileName = mCurrentWorkDir + File.separator + DOC_FILE_NAME;
        File outFile = new File(outFileName);
        if (outFile.exists()) {
            outFile.delete();
        }

        try {
            sureTemplateFile();

            Template tp = mConfiguration.getTemplate(TEMPLATE_FILE_NAME);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            tp.process(root, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sureTemplateFile() {
        Writer templateOut = null;
        try {
            if (!new File(mCurrentWorkDir + TEMPLATE_PATH).exists()) {

            }
            File templateFile = new File(mCurrentWorkDir + TEMPLATE_PATH + File.separator + TEMPLATE_FILE_NAME);
            if (templateFile.exists()) {
                templateFile.delete();
                // return;
            }

            templateOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(templateFile), "UTF-8"));
            templateOut.write(TemplateFile.TEMLATE);
            // templateOut.write(new String( TemplateFile.TEMLATE.getBytes("GBK"), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (templateOut != null) {
                try {
                    templateOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
