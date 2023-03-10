package ${package.ServiceImpl};

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.CopierUtil;
import ${cfg.dto}.*;
import ${cfg.vo}.*;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${cfg.ry}.${entity}Repository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${table.comment!} 服务实现类
 *
 * @author ${author}
 */
@Service
@AllArgsConstructor
public class ${table.serviceImplName} implements ${table.serviceName} {

    private final ${entity}Repository ${entity?uncap_first}Repository;

    @Override
    public PageVO<${entity}PageVO> page(${entity}PageDTO param) {
        return ${entity?uncap_first}Repository.page(param);
    }

    @Override
    public ${entity}InfoVO info(Long id) {
        return ${entity?uncap_first}Repository.info(id);
    }

    @Override
    public boolean save(${entity}DTO param) {
        ${entity} ${entity?uncap_first} = new ${entity}();
        CopierUtil.copyProperties(param, ${entity?uncap_first});
        return ${entity?uncap_first}Repository.save(${entity?uncap_first});
    }

    @Override
    public boolean update(${entity}DTO param) {
        ${entity} ${entity?uncap_first} = ${entity?uncap_first}Repository.getByIdNotNull(param.getId());
        CopierUtil.copyProperties(param, ${entity?uncap_first});
        return ${entity?uncap_first}Repository.updateById(${entity?uncap_first});
    }

    @Override
    public boolean removes(List<Long> ids) {
        return ${entity?uncap_first}Repository.removeByIds(ids);
    }

}