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
import com.framework.cloud.generator.utils.FileUtil;

import java.io.File;
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

    /**
     * 省去前缀
     */
    private static final String TABLE_PREFIX = "w_";

    /**
     * 需要生成的表
     */
    private static final String[] TABLES = {"w_pay_order"};

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

    /**
     * 包配置
     */
    public static PackageConfig packageConfig() {
        return new PackageConfig()
                .setParent("")
                .setEntity(GeneratorConstant.PACKAGE_ENTITY_PATH + ".entity")
                .setMapper(GeneratorConstant.PACKAGE_PROJECT_PATH + ".domain.mapper")
                .setService(GeneratorConstant.PACKAGE_PROJECT_PATH + ".domain.service")
                .setServiceImpl(GeneratorConstant.PACKAGE_PROJECT_PATH + ".domain.service.impl")
                .setController(GeneratorConstant.PACKAGE_PROJECT_PATH + ".controller");
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
                map.put("vo", GeneratorConstant.PACKAGE_ENTITY_PATH + ".vo");
                map.put("dto", GeneratorConstant.PACKAGE_ENTITY_PATH + ".dto");
                this.setMap(map);
            }
        }
        // 判断是否创建文件
        .setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 检查文件目录，不存在自动递归创建
                checkDir(filePath);
                FileUtil.isExists(filePath);
                return true;
            }
        })
        // 自定义输出文件
        .setFileOutConfigList(fileOutConfigList());
    }

    /**
     * 自定义输出文件配置
     */
    private static List<FileOutConfig> fileOutConfigList() {
        //模块路径
        String modulePath = GeneratorConstant.OVERALL_PATH + GeneratorConstant.MODULE_PATH;
        String projectPath = modulePath + GeneratorConstant.PROJECT_PATH;
        String entityPath = modulePath + GeneratorConstant.INFRASTRUCTURE_PATH + GeneratorConstant.SRC_PATH;
        String srcPath = projectPath + GeneratorConstant.SRC_PATH;
        String xmlPath = projectPath + GeneratorConstant.XML_PATH + "mapper/";

        String packageEntityPath = GeneratorConstant.PACKAGE_ENTITY_PATH;
        String packageProjectPath = GeneratorConstant.PACKAGE_PROJECT_PATH;

        String dto = FileUtil.replacePath(entityPath, packageEntityPath + ".dto");
        String vo = FileUtil.replacePath(entityPath, packageEntityPath + ".vo");
        String entity = FileUtil.replacePath(entityPath, packageEntityPath + ".entity");
        String xml = FileUtil.replacePath(xmlPath, "");
        String mapper = FileUtil.replacePath(srcPath, packageProjectPath + ".domain.mapper");
        String service = FileUtil.replacePath(srcPath, packageProjectPath + ".domain.service");
        String impl = FileUtil.replacePath(srcPath, packageProjectPath + ".domain.service.impl");
        String controller = FileUtil.replacePath(srcPath, packageProjectPath + ".controller");

        List<FileOutConfig> list = new ArrayList<>();
        // 实体类文件输出
        list.add(new FileOutConfig("templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return entity + StringPool.SLASH + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        // mapper xml文件输出
        list.add(new FileOutConfig("templates/xml.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return xml + StringPool.SLASH + tableInfo.getXmlName() + StringPool.DOT_XML;
            }
        });
        // mapper文件输出
        list.add(new FileOutConfig("templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return mapper + StringPool.SLASH + tableInfo.getMapperName() + StringPool.DOT_JAVA;
            }
        });
        // service文件输出
        list.add(new FileOutConfig("templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return service + StringPool.SLASH + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });
        // service impl文件输出
        list.add(new FileOutConfig("templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return impl + StringPool.SLASH + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
            }
        });
        // controller文件输出
        list.add(new FileOutConfig("templates/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return controller + StringPool.SLASH + tableInfo.getControllerName() + StringPool.DOT_JAVA;
            }
        });
        // dto文件输出
        list.add(new FileOutConfig("templates/saveDTO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return dto + StringPool.SLASH + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        // dto文件输出
        list.add(new FileOutConfig("templates/updateDTO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return dto + StringPool.SLASH + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        // dto文件输出
        list.add(new FileOutConfig("templates/pageDTO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return dto + StringPool.SLASH + tableInfo.getEntityName() + "PageDTO" + StringPool.DOT_JAVA;
            }
        });
        // info文件输出
        list.add(new FileOutConfig("templates/infoVO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return vo + StringPool.SLASH + tableInfo.getEntityName() + "InfoVO" + StringPool.DOT_JAVA;
            }
        });
        // info文件输出
        list.add(new FileOutConfig("templates/pageVO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return vo + StringPool.SLASH + tableInfo.getEntityName() + "PageVo" + StringPool.DOT_JAVA;
            }
        });
        return list;
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
