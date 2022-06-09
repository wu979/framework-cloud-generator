package com.framework.cloud.generator.constant;

/**
 * 代码生成常量
 *
 * @author wusiwei
 */
public class GeneratorConstant {
    /** 全局（项目顶级路径） */
    public static final String PATH = "C:/Program Files/979/framework";
    /** 项目模块名称 （如framework-cloud-user 模块名称则为 user ）*/
    public static final String MODULE = "user";
    /** 项目模块路径 */
    public static final String MODULE_PATH = "/framework-cloud-" + MODULE;
    public static final String API_PATH = "/framework-cloud-user-api";
    public static final String INFRASTRUCTURE_PATH = "/framework-cloud-user-infrastructure";

    /** 默认JAVA文件路径 */
    public static final String SRC_PATH = "/src/main/java/";
    /** 默认资源文件路径 */
    public static final String XML_PATH = "/src/main/resources/";
    /** 包名 */
    public static final String PACKAGE_PROJECT_PATH = "com.framework.cloud.user.api";
    /** 包名 */
    public static final String PACKAGE_ENTITY_PATH = "com.framework.cloud.user.infrastructure";

    /** 作者 */
    public static final String AUTHOR = "wusiwei";

    /** 父类实体包名 */
    public static final String SUPER_ENTITY_PACKAGE = "com.framework.cloud.common.base.BaseEntity";
    /** 父类公共属性 */
    public static final String[] SUPER_ENTITY_COLUMNS =
            {
                    "tenant_id", "create_id", "update_id", "create_time",
                    "update_time", "deleted", "version"
            };
}
