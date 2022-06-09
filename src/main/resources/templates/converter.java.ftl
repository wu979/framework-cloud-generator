package ${cfg.converter};

import ${cfg.vo}.*;
import ${package.Entity}.${entity};
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * ${table.comment!} 转换器
 *
 * @author ${author}
 */
@Mapper(componentModel = "spring")
public interface ${entity}Converter {

    /**
     * ${table.comment!} 详情转换
     *
     * @param ${entity?uncap_first} 实体
     * @return 详情
     */
    ${entity}InfoVO info(${entity} ${entity?uncap_first});

}