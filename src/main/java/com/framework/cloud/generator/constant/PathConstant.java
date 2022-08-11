package com.framework.cloud.generator.constant;

/**
 * 代码生成常量
 *
 * @author wusiwei
 */
public class PathConstant {

    /** 项目生成文件夹 */
    public static final String PATH = "C:/Program Files/979/framework";
    /** 模块名称 */
    public static final String MODULE = "pay";

    // 以下配置无特殊需求 禁止修改
    // 定义 包名
    /** super */
    public static final String SUPER_PACKAGE = "com.framework.cloud." + MODULE;
    /** api */
    public static final String API_PACKAGE = SUPER_PACKAGE + ".api";
    /** common */
    public static final String COMMON_PACKAGE = SUPER_PACKAGE + ".common";
    /** domain */
    public static final String DOMAIN_PACKAGE = SUPER_PACKAGE + ".domain";
    /** infrastructure */
    public static final String INFRASTRUCTURE_PACKAGE = SUPER_PACKAGE + ".infrastructure";
    /** controller */
    public static final String CONTROLLER_PACKAGE = API_PACKAGE + ".controller";
    /** repository */
    public static final String REPOSITORY_PACKAGE = DOMAIN_PACKAGE + ".repository";
    /** service */
    public static final String SERVICE_PACKAGE = DOMAIN_PACKAGE + ".service";
    /** serviceImpl */
    public static final String SERVICE_IMPL_PACKAGE = INFRASTRUCTURE_PACKAGE + ".service";
    /** repositoryImpl */
    public static final String REPOSITORY_IMPL_PACKAGE = INFRASTRUCTURE_PACKAGE + ".repository";
    /** mapper */
    public static final String MAPPER_PACKAGE = INFRASTRUCTURE_PACKAGE + ".mapper";
    /** entity */
    public static final String ENTITY_PACKAGE = DOMAIN_PACKAGE + ".entity";
    /** dto */
    public static final String DTO_PACKAGE = COMMON_PACKAGE + ".dto";
    /** vo */
    public static final String VO_PACKAGE = COMMON_PACKAGE + ".vo";
    /** converter */
    public static final String CONVERTER_PACKAGE =  INFRASTRUCTURE_PACKAGE + ".converter";


    // 定义 路径
    /** JAVA */
    public static final String SRC_PATH = "/src/main/java";
    /** resources */
    public static final String RESOURCES_PATH = "/src/main/resources";
    /** package */
    public static final String PACKAGE_PATH = SRC_PATH + "/com/framework/cloud/" + MODULE;
    /** super */
    public static final String SUPER_PATH = PATH + "/framework-cloud-" + MODULE;
    /** api */
    public static final String API_PATH = SUPER_PATH + "/framework-cloud-" + MODULE + "-api" + PACKAGE_PATH + "/api";
    /** domain */
    public static final String DOMAIN_PATH = SUPER_PATH + "/framework-cloud-" + MODULE + "-domain" + PACKAGE_PATH + "/domain";
    /** common */
    public static final String COMMON_PATH = SUPER_PATH + "/framework-cloud-" + MODULE + "-common" + PACKAGE_PATH + "/common";
    /** infrastructure */
    public static final String INFRASTRUCTURE_PATH = SUPER_PATH + "/framework-cloud-" + MODULE + "-infrastructure" + PACKAGE_PATH + "/infrastructure";
    /** controller */
    public static final String CONTROLLER_PATH = API_PATH + "/controller";
    /** repository */
    public static final String REPOSITORY_PATH = DOMAIN_PATH + "/repository";
    /** service */
    public static final String SERVICE_PATH = DOMAIN_PATH + "/service";
    /** serviceImpl */
    public static final String SERVICE_IMPL_PATH = INFRASTRUCTURE_PATH + "/service";
    /** repositoryImpl */
    public static final String REPOSITORY_IMPL_PATH = INFRASTRUCTURE_PATH + "/repository";
    /** mapper */
    public static final String MAPPER_PATH = INFRASTRUCTURE_PATH + "/mapper";
    /** entity */
    public static final String ENTITY_PATH = DOMAIN_PATH + "/entity";
    /** xml */
    public static final String XML_PATH = SUPER_PATH + "/framework-cloud-" + MODULE + "-api" + RESOURCES_PATH + "/mapper";
    /** dto */
    public static final String DTO_PATH = COMMON_PATH + "/dto";
    /** vo */
    public static final String VO_PATH = COMMON_PATH + "/vo";
    /** converter */
    public static final String CONVERTER_PATH = INFRASTRUCTURE_PATH + "/converter";
}
