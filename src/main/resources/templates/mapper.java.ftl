package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import ${cfg.vo}.*;
import ${cfg.evt}.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* <p>
* ${table.comment!} Mapper 接口
* </p>
* @author ${author}
* @since ${date}
*/
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    IPage<${entity}PageVo> page(@Param("pg") Page page, @Param("param") ${entity}PageEvt param);

}