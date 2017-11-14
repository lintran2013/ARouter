package com.alibaba.android.arouter.compiler.doc;

import com.alibaba.android.arouter.compiler.utils.Logger;
import com.alibaba.android.arouter.compiler.utils.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.AutowiredDoc;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.annotation.RouteDoc;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.swing.plaf.TextUI;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/2
 * Description : This is a description example
 */
public class DocGenerator {
    private static final boolean DEBUG = true;

    private Logger mLogger;
    private String mModuleName;
    private boolean mStickMode;
    private DocWriter mDocWriter;

    public DocGenerator(String module, boolean stickMode, ProcessingEnvironment processingEnv) {
        mModuleName = module;
        mStickMode = stickMode;
        mLogger = new Logger(processingEnv.getMessager());   // Package the log utils.

        mDocWriter = new HtmlDocWriter();
    }

    /**
     * generate route document
     *
     * @param routeElements elements
     */
    public void generate(Set<? extends Element> routeElements) {
        if (CollectionUtils.isNotEmpty(routeElements)) {
            mLogger.info(">>> start generate document... <<<");

            List<RouteEntry> routeEntryList = new ArrayList<>();

            for (Element element : routeElements) {
                if (element.getAnnotation(RouteDoc.class) == null && mStickMode) {
                    throw new IllegalArgumentException(element.getSimpleName() + " must add Annotation RouteDoc");
                }

                RouteEntry entry = fillRoute(element);
                mLogger.info("===============");
                mLogger.info("class: " + element.getSimpleName());

                for (Element field : element.getEnclosedElements()) {
                    if (field.getKind().isField() && field.getAnnotation(Autowired.class) != null) {
                        // It must be field, then it has annotation, but it not be provider.
                        if (field.getAnnotation(AutowiredDoc.class) == null && mStickMode) {
                            throw new IllegalArgumentException(field.getSimpleName() + " in " + element.getSimpleName() + " must add Annotation AutowiredDoc");
                        }

                        addRouteParam(entry, field);

                        mLogger.info("field: " + field.getSimpleName());
                    }
                }
                mLogger.info("===============");

                routeEntryList.add(entry);
            }

            //write to file
            mDocWriter.write(routeEntryList);
        }
    }

    private RouteEntry fillRoute(Element element) {
        Route route = element.getAnnotation(Route.class);
        RouteDoc routeDoc = element.getAnnotation(RouteDoc.class);

        RouteEntry entry = new RouteEntry();
        entry.module = mModuleName;
        entry.path = route.path();
        entry.group = route.group();
        entry.extras = Integer.toBinaryString(route.extras()).toUpperCase();
        entry.priority = route.priority();

        if (routeDoc == null) {
            entry.desc = "please add route description";
            entry.example = "";
            entry.minVer = "N/A";
        } else {
            entry.desc = routeDoc.desc();
            entry.example = routeDoc.example();
            entry.minVer = TextUtils.isEmpty(routeDoc.minVer()) ? "7.0.0" : routeDoc.minVer();
        }
        return entry;
    }

    private void addRouteParam(RouteEntry entry, Element element) {
        RouteEntry.RouteParam routeParam = fillRouteParam(element);
        if (TextUtils.isEmpty(routeParam.minVer)) {
            routeParam.minVer = entry.minVer;
        }

        entry.paramList.add(routeParam);
    }

    private RouteEntry.RouteParam fillRouteParam(Element field) {
        Autowired paramConfig = field.getAnnotation(Autowired.class);
        AutowiredDoc fieldDoc = field.getAnnotation(AutowiredDoc.class);

        RouteEntry.RouteParam param = new RouteEntry.RouteParam();

        if (TextUtils.isEmpty(paramConfig.name())) {
            param.outName = field.getSimpleName().toString();
        }else {
            param.outName = paramConfig.name();
            param.innerName = field.getSimpleName().toString();
        }

        param.type = getSimpleType(field.asType().toString());
        param.required = paramConfig.required();

        if (fieldDoc == null) {
            param.desc = "please add route description";
            param.example = "";
            param.limit = "N/A";
        }else {
            param.desc = fieldDoc.desc();
            param.example = fieldDoc.example();
            param.limit = fieldDoc.limit();
            param.minVer = fieldDoc.minVer();
        }

        return param;
    }

    private String getSimpleType(String type) {
        // if (type.contains(".")) {
        //     return type.substring(type.lastIndexOf(".") + 1, type.length());
        // }

        return type;
    }
}
