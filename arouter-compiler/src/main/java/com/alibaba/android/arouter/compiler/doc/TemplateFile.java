package com.alibaba.android.arouter.compiler.doc;

/**
 * Author: lingquan(lingquan@yy.com)
 * Date : 2017/11/13
 * Description : This is a description example
 */
class TemplateFile {
    static String TEMLATE = "<@compress single_line=true>\n" +
            "    <!DOCTYPE html>\n" +
            "    <html lang=\"zh-CN\">\n" +
            "\n" +
            "    <head>\n" +
            "        <meta name=\"viewport\" http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
            "        <link rel=\"stylesheet\" href=\"https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n" +
            "        <link rel=\"stylesheet\" type=\"text/css\" href=\"http://fonts.googleapis.com/css?family=Source+Code+Pro|Source+Sans+Pro:400,600,700\">\n" +
            "        <script src=\"https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n" +
            "        <link rel=\"stylesheet\" href=\"https://bootswatch.com/4/flatly/bootstrap.min.css\">\n" +
            "        <script src=\"https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
            "        <style type=\"text/css\">\n" +
            "        th {\n" +
            "            background-color: #f5f5f5;\n" +
            "        }\n" +
            "\n" +
            "        td {\n" +
            "            /*text-align: center;*/\n" +
            "        }\n" +
            "\n" +
            "        pre>code {\n" +
            "            display: block;\n" +
            "            /*margin: 12px 0;*/\n" +
            "            padding: 18px 20px;\n" +
            "            background: #292b36;\n" +
            "            border: none;\n" +
            "            border-radius: 8px;\n" +
            "            color: #ffffff;\n" +
            "            overflow: auto;\n" +
            "            font-family: \"Source Code Pro\";\n" +
            "            margin-bottom: 20px;\n" +
            "        }\n" +
            "\n" +
            "        #content h3 {\n" +
            "            margin: 40px 0 20px 0;\n" +
            "            color: #0088cc;\n" +
            "            font-size: 24px;\n" +
            "            font-weight: bold;\n" +
            "            line-height: 1em;\n" +
            "        }\n" +
            "\n" +
            "        code,\n" +
            "        h3 {\n" +
            "            font-family: \"Source Sans Pro\", sans-serif;\n" +
            "            line-height: 1em;\n" +
            "        }\n" +
            "\n" +
            "        .param-title {\n" +
            "            font-size: 16px;\n" +
            "        }\n" +
            "\n" +
            "        .param {\n" +
            "            color: #333333;\n" +
            "        }\n" +
            "\n" +
            "        .label {\n" +
            "            display: inline-block;\n" +
            "            padding: 2px 4px;\n" +
            "            background-color: #999999;\n" +
            "            border-radius: 3px 3px 3px 3px;\n" +
            "            color: #FFFFFF;\n" +
            "            font-family: Arial, Helvetica, sans-serif;\n" +
            "            font-size: 11px;\n" +
            "            font-weight: bold;\n" +
            "            line-height: 14px;\n" +
            "            text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);\n" +
            "            vertical-align: baseline;\n" +
            "            white-space: nowrap;\n" +
            "        }\n" +
            "\n" +
            "        .label-optional {\n" +
            "            float: right;\n" +
            "            vertical-align: baseline;\n" +
            "        }\n" +
            "\n" +
            "        .route-title {\n" +
            "            color: #2C3E50;\n" +
            "            font-size: 36px;\n" +
            "            font-weight: bold;\n" +
            "            margin-bottom: 10px;\n" +
            "            margin-top: 50px;\n" +
            "        }\n" +
            "\n" +
            "        .limit .example .param-name {\n" +
            "            font-size: 14px;\n" +
            "            font-family: \"Source Code Pro\";\n" +
            "            font-style: normal;\n" +
            "            font-weight: 400;\n" +
            "        }\n" +
            "\n" +
            "        .route-desc {\n" +
            "            font-size: 16px;\n" +
            "            margin-top: 25px;\n" +
            "            color: #808080;\n" +
            "        }\n" +
            "        </style>\n" +
            "    </head>\n" +
            "\n" +
            "    <body>\n" +
            "        <div class=\"container\">\n" +
            "            <h1 style=\"margin-top: 50px\">欢迎使用ARouter文档</h1>\n" +
            "            <blockquote>\n" +
            "                <p style=\"color: #808080; margin-top: 20px\">本文档根据注解<code>RouteDoc</code>和<code>AutowiredDoc</code>自动生成，如有疑问请联系<a href=\"mailto:lingquan@yy.com\" target=\"_blank\">lingquan@yy.com</a></p>\n" +
            "            </blockquote>\n" +
            "            <hr>\n" +
            "            <p style=\"margin-top: 40px; font-size: 30px\">目录列表</p>\n" +
            "            <p>\n" +
            "                <div class=\"toc\">\n" +
            "                    <#list nodeList as node>\n" +
            "                        <li><a href=\"#ref_node_${node_index}\">${node.path}</a></li>\n" +
            "                    </#list>\n" +
            "                </div>\n" +
            "            </p>\n" +
            "            <#list nodeList as node>\n" +
            "                <h3 class=\"route-title\" id=\"ref_node_${node_index}\">${node.path}</h3>\n" +
            "                <p class=\"route-desc\">${node.desc}</p>\n" +
            "                <p><strong class=\"param-title\">Module</strong>\n" +
            "                    <br>\n" +
            "                    <em class=\"param\">${node.module}</em>\n" +
            "                    <br>\n" +
            "                    <strong class=\"param-title\">Group</strong>\n" +
            "                    <br>\n" +
            "                    <em class=\"param\">${node.group}</em>\n" +
            "                    <br>\n" +
            "                    <strong class=\"param-title\">Extras</strong>\n" +
            "                    <br>\n" +
            "                    <em class=\"param\">0x${node.extras}</em>\n" +
            "                    <br>\n" +
            "                    <strong class=\"param-title\">Priority</strong>\n" +
            "                    <br>\n" +
            "                    <em class=\"param\">${node.priority}</em>\n" +
            "                    <br>\n" +
            "                    <strong class=\"param-title\">Min Support Version</strong>\n" +
            "                    <br>\n" +
            "                    <em class=\"param\">v${node.minVer}</em></p>\n" +
            "                <#if (node.paramList?size> 0)>\n" +
            "                    <p><strong style=\"font-size: 18px\">Parameter</strong></p>\n" +
            "                    <table class=\"table table-bordered\">\n" +
            "                        <thead>\n" +
            "                            <tr>\n" +
            "                                <th style=\"width: 20%;\">Name</th>\n" +
            "                                <th style=\"width: 5%;\">Type</th>\n" +
            "                                <th style=\"width: 60%;\">Description</th>\n" +
            "                                <th style=\"width: 5%;\">Limit</th>\n" +
            "                                <th style=\"width: 5%;\">Example</th>\n" +
            "                                <th style=\"width: 5%; \">Min Ver</th>\n" +
            "                            </tr>\n" +
            "                        </thead>\n" +
            "                        <tbody>\n" +
            "                            <#list node.paramList as param>\n" +
            "                                <tr>\n" +
            "                                    <td class=\"param-name\">${param.outName}\n" +
            "                                        <#if param.required><#else><span class=\"label label-optional\">optional</span></#if>\n" +
            "                                    </td>\n" +
            "                                    <td><code>${param.type}</code></td>\n" +
            "                                    <td style=\"color: #808080\">${param.desc}</td>\n" +
            "                                    <td class=\"limit\">\n" +
            "                                        <#if (param.limit?length> 0)> ${param.limit}\n" +
            "                                            <#else> - </#if>\n" +
            "                                    </td>\n" +
            "                                    <td class=\"example\">${param.example}</td>\n" +
            "                                    <td>v${param.minVer}</td>\n" +
            "                                </tr>\n" +
            "                            </#list>\n" +
            "                        </tbody>\n" +
            "                    </table>\n" +
            "                </#if>\n" +
            "                <p><strong style=\"font-size: 18px\">Example</strong></p>\n" +
            "                <pre><code>yymobile:${node.path}</code></pre>\n" +
            "            </#list>\n" +
            "            <hr style=\"margin-top: 30px\">\n" +
            "            <p>\n" +
            "                <p class=\"note-tags \"><code>@2017 All Right Reserved</code> </p>\n" +
            "            </p>\n" +
            "        </div>\n" +
            "        <div id=\"wmd-preview-section-footnotes\" class=\"preview-content\"></div>\n" +
            "        </div>\n" +
            "        </div>\n" +
            "    </body>\n" +
            "\n" +
            "    </html>\n" +
            "</@compress>";
}
