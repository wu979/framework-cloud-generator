package com.framework.cloud.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.framework.cloud.generator.constant.GeneratorConstant;

/**
 * 代码生成器
 *
 * @author wusiwei
 */
public class MybatisGenerator {

    /** 省去前缀 */
    private static final String TABLE_PREFIX = "w_";

    /**需要生成的表 */
    private static final String[] TABLES = { "w_pay_order" };

    /**
     * 全局配置
     */
    public static GlobalConfig globalConfig() {
        return new GlobalConfig()
                // 打开文件
                .setOpen(false)
                // 文件覆盖
                .setFileOverride(true)
                // 开启activeRecord模式
                .setActiveRecord(false)
                // XML 二级缓存
                .setEnableCache(false)
                // XML ResultMap: mapper.xml生成查询映射结果
                .setBaseResultMap(true)
                // XML ColumnList: mapper.xml生成查询结果列
                .setBaseColumnList(true)
                // swagger注解; 须添加swagger依赖
                .setSwagger2(true)
                // 作者
                .setAuthor(GeneratorConstant.AUTHOR)
                //时间类型
                .setDateType(DateType.TIME_PACK)
                //设置主键生成策略
                .setIdType(IdType.ASSIGN_ID)
                //自定义文件命名，注意 %s 会自动填充表实体属性！
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper");
    }

    /**
     * 数据源配置
     */
    public static DataSourceConfig dataSourceConfig() {
        return new DataSourceConfig()
                // 数据库类型
                .setDbType(DbType.MYSQL)
                // 连接驱动
                .setDriverName(GeneratorConstant.DRIVER_NAME)
                // 地址
                .setUrl(GeneratorConstant.URL)
                // 用户名
                .setUsername(GeneratorConstant.USERNAME)
                // 密码
                .setPassword(GeneratorConstant.PASSWORD)
                // 类型转换
                .setTypeConvert(new MySqlTypeConvertCustom());
    }

    /**
     * 策略配置
     *
     * @return
     */
    public static StrategyConfig strategyConfig() {
        return new StrategyConfig()
                //需要生成的表
                .setInclude(TABLES)
                //表名生成策略：下划线连转驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                //表字段生成策略：下划线连转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //去除表前缀
                .setTablePrefix(TABLE_PREFIX)
                //生成controller
                .setRestControllerStyle(true)
                //controller映射地址：驼峰转连字符
                .setControllerMappingHyphenStyle(false)
                //自定义实体父类
                .setSuperEntityClass("com.framework.cloud.mybatis.base.BaseEntity")
                //序列化
                .setEntitySerialVersionUID(true)
                //是否为lombok模型; 需要lombok依赖
                .setEntityLombokModel(true)
                //自定义父类公共字段
                .setSuperEntityColumns(GeneratorConstant.SUPER_ENTITY_COLUMNS)
                ;
    }


    static class MySqlTypeConvertCustom extends MySqlTypeConvert implements ITypeConvert {
        @Override
        public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
            if (fieldType.toLowerCase().contains(GeneratorConstant.CONVERT_TINYINT)) {
                return DbColumnType.INTEGER;
            }
            return super.processTypeConvert(globalConfig, fieldType);
        }
    }
}
