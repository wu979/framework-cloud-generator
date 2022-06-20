package com.framework.cloud.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.framework.cloud.generator.constant.GeneratorConstant;
import com.framework.cloud.generator.constant.MysqlConstant;
import com.framework.cloud.generator.constant.PathConstant;
import com.framework.cloud.generator.utils.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author wusiwei
 */
public class MybatisGenerator {


    public static void main(String[] args) {
        // 全局配置
        GlobalConfig globalConfig = globalConfig();
        // 数据源配置
        DataSourceConfig dataSourceConfig = dataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = strategyConfig();
        // 包配置
        PackageConfig packageConfig = packageConfig();
        // 自定义配置
        InjectionConfig injectionConfig = injectionConfig();
        // 模板配置
        TemplateConfig templateConfig = templateConfig();
        // 执行
        new AutoGenerator().setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setCfg(injectionConfig)
                .setTemplate(templateConfig)
                .execute();
    }

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
                .setDriverName(MysqlConstant.DRIVER_NAME)
                // 地址
                .setUrl(MysqlConstant.URL_PREFIX + MysqlConstant.URL + MysqlConstant.DATABASE + MysqlConstant.URL_SUFFIX)
                // 用户名
                .setUsername(MysqlConstant.USERNAME)
                // 密码
                .setPassword(MysqlConstant.PASSWORD)
                // 类型转换
                .setTypeConvert(new MySqlTypeConvertCustom());
    }

    /**
     * 策略配置
     */
    public static StrategyConfig strategyConfig() {
        return new StrategyConfig()
                //需要生成的表
                .setInclude(MysqlConstant.TABLES)
                //表名生成策略：下划线连转驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                //表字段生成策略：下划线连转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //去除表前缀
                .setTablePrefix(MysqlConstant.TABLE_PREFIX)
                //生成controller
                .setRestControllerStyle(true)
                //controller映射地址：驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                //自定义实体父类
                .setSuperEntityClass(GeneratorConstant.SUPER_ENTITY_PACKAGE)
                //序列化
                .setEntitySerialVersionUID(true)
                //是否为lombok模型; 需要lombok依赖
                .setEntityLombokModel(true)
                //自定义父类公共字段
                .setSuperEntityColumns(GeneratorConstant.SUPER_ENTITY_COLUMNS)
                ;
    }

    /**
     * 包配置
     */
    public static PackageConfig packageConfig() {
        return new PackageConfig()
                .setParent("")
                .setEntity(PathConstant.ENTITY_PACKAGE)
                .setMapper(PathConstant.MAPPER_PACKAGE)
                .setService(PathConstant.SERVICE_PACKAGE)
                .setServiceImpl(PathConstant.SERVICE_IMPL_PACKAGE)
                .setController(PathConstant.CONTROLLER_PACKAGE);
    }

    /**
     * 模板配置
     * 自定义.ftl或者.vm 全部为NULL
     */
    public static TemplateConfig templateConfig() {
        //置空后方便使用自定义输出位置
        return new TemplateConfig()
                .setEntity(null)
                .setXml(null)
                .setMapper(null)
                .setService(null)
                .setServiceImpl(null)
                .setController(null);
    }

    /**
     * 自定义配置
     */
    private static InjectionConfig injectionConfig() {
        return new InjectionConfig() {
            //自定义属性注入
            //在.ftl(或者是.vm)模板中，通过${cfg.vo}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("vo", PathConstant.VO_PACKAGE);
                map.put("dto", PathConstant.DTO_PACKAGE);
                map.put("ry", PathConstant.REPOSITORY_PACKAGE);
                map.put("ryl", PathConstant.REPOSITORY_IMPL_PACKAGE);
                map.put("converter", PathConstant.CONVERTER_PACKAGE);
                this.setMap(map);
            }
        }
        // 判断是否创建文件
        .setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 检查文件目录，不存在自动递归创建
                return FileUtil.checkDir(filePath, 0);
            }
        })
        // 自定义输出文件
        .setFileOutConfigList(fileOutConfigList());
    }

    /**
     * 自定义输出文件配置
     */
    private static List<FileOutConfig> fileOutConfigList() {
        List<FileOutConfig> list = new ArrayList<>();
        // dto文件输出
        list.add(new FileOutConfig("templates/saveDTO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.DTO_PATH + StringPool.SLASH + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        // dto文件输出
        list.add(new FileOutConfig("templates/pageDTO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.DTO_PATH + StringPool.SLASH + tableInfo.getEntityName() + "PageDTO" + StringPool.DOT_JAVA;
            }
        });
        // vo文件输出
        list.add(new FileOutConfig("templates/infoVO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.VO_PATH + StringPool.SLASH + tableInfo.getEntityName() + "InfoVO" + StringPool.DOT_JAVA;
            }
        });
        // vo文件输出
        list.add(new FileOutConfig("templates/pageVO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.VO_PATH + StringPool.SLASH + tableInfo.getEntityName() + "PageVO" + StringPool.DOT_JAVA;
            }
        });
        // 转换器文件输出
        list.add(new FileOutConfig("templates/converter.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.CONVERTER_PATH + StringPool.SLASH + tableInfo.getEntityName() + "Converter" + StringPool.DOT_JAVA;
            }
        });
        // 实体类文件输出
        list.add(new FileOutConfig("templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.ENTITY_PATH + StringPool.SLASH + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        // mapper xml文件输出
        list.add(new FileOutConfig("templates/xml.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.XML_PATH + StringPool.SLASH + tableInfo.getXmlName() + StringPool.DOT_XML;
            }
        });
        // mapper文件输出
        list.add(new FileOutConfig("templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.MAPPER_PATH + StringPool.SLASH + tableInfo.getMapperName() + StringPool.DOT_JAVA;
            }
        });
        // repository文件输出
        list.add(new FileOutConfig("templates/repository.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.REPOSITORY_PATH + StringPool.SLASH + tableInfo.getEntityName() + "Repository" + StringPool.DOT_JAVA;
            }
        });
        // repository impl文件输出
        list.add(new FileOutConfig("templates/repositoryImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.REPOSITORY_IMPL_PATH + StringPool.SLASH + tableInfo.getEntityName() + "RepositoryImpl" + StringPool.DOT_JAVA;
            }
        });
        // service文件输出
        list.add(new FileOutConfig("templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.SERVICE_PATH + StringPool.SLASH + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });
        // service impl文件输出
        list.add(new FileOutConfig("templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.SERVICE_IMPL_PATH + StringPool.SLASH + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
            }
        });
        // controller文件输出
        list.add(new FileOutConfig("templates/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PathConstant.CONTROLLER_PATH + StringPool.SLASH + tableInfo.getControllerName() + StringPool.DOT_JAVA;
            }
        });
        return list;
    }

    static class MySqlTypeConvertCustom extends MySqlTypeConvert implements ITypeConvert {
        @Override
        public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
            if (fieldType.toLowerCase().contains(MysqlConstant.CONVERT_TINYINT)) {
                return DbColumnType.INTEGER;
            }
            return super.processTypeConvert(globalConfig, fieldType);
        }
    }
}
