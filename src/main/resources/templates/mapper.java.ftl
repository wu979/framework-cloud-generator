package ${package.Mapper};

import ${superMapperClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${cfg.vo}.*;
import ${cfg.dto}.*;
import ${package.Entity}.${entity};
import org.apache.ibatis.annotations.Param;

/**
 * ${table.comment!} 数据库接口
 *
 * @author ${author}
 */
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    IPage<${entity}PageVO> page(@Param("pg") Page<${entity}PageVO> page, @Param("param") ${entity}PageDTO param);

}