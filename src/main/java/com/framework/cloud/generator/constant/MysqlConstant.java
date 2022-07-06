package com.framework.cloud.generator.constant;

/**
 * 代码生成常量
 *
 * @author wusiwei
 */
public class MysqlConstant {

    /** 数据库-前缀 */
    public static final String URL_PREFIX = "jdbc:mysql://";
    /** 数据库-地址 */
    public static final String URL = "139.155.11.84:3306/";
    /** 数据库-库名 */
    public static final String DATABASE = "framework-platform";
    /** 数据库-后缀 */
    public static final String URL_SUFFIX = "?characterEncoding=utf8&useSSL=false&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&serverTimezone=GMT%2B8";
    /** 数据库-账号 */
    public static final String USERNAME = "979";
    /** 数据库-密码 */
    public static final String PASSWORD = "wsw979";
    /** 数据库-驱动 */
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    /** 类型转换-tinyint to int */
    public static final String CONVERT_TINYINT = "tinyint";
    /** 表名前缀 */
    public static final String TABLE_PREFIX = "t_";
    /** 需要生成的表 */
    public static final String[] TABLES = { "t_gateway_route" };
}
