package com.framework.cloud.generator.constant;

/**
 * 代码生成常量
 *
 * @author wusiwei
 */
public class GeneratorConstant {

    /** 作者 */
    public static final String AUTHOR = "wusiwei";

    /** 父类实体包名 */
    public static final String SUPER_ENTITY_PACKAGE = "com.framework.cloud.common.base.BaseTenant";

    /** 父类公共属性 */
    public static final String[] SUPER_ENTITY_COLUMNS =
            {
                    "tenant_id", "create_id", "update_id", "create_time",
                    "update_time", "deleted", "version"
            };
}
