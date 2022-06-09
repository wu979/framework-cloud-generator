package ${cfg.ryl};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import ${cfg.vo}.*;
import ${cfg.dto}.*;
import ${package.Entity}.${entity};
import ${cfg.ry}.${entity}Repository;
import ${cfg.converter}.${entity}Converter;
import ${package.Mapper}.${table.mapperName};
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${table.comment!} 数据实现层
 *
 * @author ${author}
 */
@Repository
@AllArgsConstructor
public class ${entity}RepositoryImpl extends BaseRepositoryImpl<${table.mapperName}, ${entity}> implements ${entity}Repository {

    private final UserConverter userConverter;

    @Override
    public PageVO<${entity}PageVO> page(${entity}PageDTO param) {
        Page<${entity}PageVO> page = PageParam.buildOrder(param);
        IPage<${entity}PageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public ${entity}InfoVO info(Long id) {
        ${entity} entity = this.getById(id);
        return userConverter.info(entity);
    }
}