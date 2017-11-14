package com.alibaba.android.arouter.compiler.doc;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/3
 * Description : This is a description example
 */

public class RouteEntry {
    /**
     * Path of route
     */
    String path;

    /**
     * Used to merger routes, the group outName MUST BE USE THE COMMON WORDS !!!
     */
    String group;

    /**
     * Extra data, can be set by user.
     * Ps. U should use the integer num sign the switch, by bits. 10001010101010
     */
    String extras;

    /**
     * The priority of route.
     */
    int priority;

    /**
     *
     * module outName
     */
    String module;

    /**
     * description
     */
    String desc;

    /**
     * example
     */
    String example;

    /**
     * formateStr
     */
    String formate;

    /**
     * min support plugin version
     */
    String minVer;

    /**
     * param list
     */
    List<RouteParam> paramList = new ArrayList<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public String getMinVer() {
        return minVer;
    }

    public void setMinVer(String minVer) {
        this.minVer = minVer;
    }

    public List<RouteParam> getParamList() {
        return paramList;
    }

    public void setParamList(List<RouteParam> paramList) {
        this.paramList = paramList;
    }

    public static class RouteParam{
        /**
         * param type
         */
        String type;

        /**
         * write name
         */
        String innerName;

        // Mark param's outName or service outName.
        String outName;

        // If required, app will be crash when value is null.
        // Primitive type wont be check!
        boolean required;

        /**
         * description
         */
        String desc;

        /**
         * example
         */
        String example;

        /**
         * list limited value
         */
        String limit;

        /**
         * min support plugin version
         */
        String minVer;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getInnerName() {
            return innerName;
        }

        public void setInnerName(String innerName) {
            this.innerName = innerName;
        }

        public String getOutName() {
            return outName;
        }

        public void setOutName(String outName) {
            this.outName = outName;
        }

        public boolean isRequired() {
            return required;
        }

        public void setRequired(boolean required) {
            this.required = required;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public String getMinVer() {
            return minVer;
        }

        public void setMinVer(String minVer) {
            this.minVer = minVer;
        }
    }
}
