package com.framework.cloud.generator.constant;

/**
 * 代码生成常量
 *
 * @author wusiwei
 */
public class GeneratorConstant {
    /** 数据库 */
    public static final String URL = "jdbc:mysql://localhost:3306/framework-user?characterEncoding=utf8&useSSL=false&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&serverTimezone=GMT%2B8";
    /** 全局 */
    public static final String OVERALL_PATH = "C:/Program Files/979/framework";
    /** 主模块 */
    public static final String MODULE_PATH = "/framework-cloud-user";
    /** 服务层模块 */
    public static final String PROJECT_PATH = "framework-cloud-user-api";
    /** 基础设施层模块 */
    public static final String INFRASTRUCTURE_PATH = "/framework-cloud-user-infrastructure";
    /** 默认JAVA文件路径 */
    public static final String SRC_PATH = "/src/main/java/";
    /** 默认资源文件路径 */
    public static final String XML_PATH = "/src/main/resources/";
    /** 包名 */
    public static final String PACKAGE_PROJECT_PATH = "com.framework.cloud.user.api";
    /** 包名 */
    public static final String PACKAGE_ENTITY_PATH = "com.framework.cloud.user.infrastructure";

    //实体是否继承父类
    public static final boolean IS_SUPER = true;
    /** 父类公共属性 */
    public static final String[] SUPER_ENTITY_COLUMNS =
            {
                    "create_id", "update_id", "create_time",
                    "update_time", "deleted", "version"
            };
    public static final String AUTHOR = "wusiwei";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String CONVERT_TINYINT = "tinyint";
}
