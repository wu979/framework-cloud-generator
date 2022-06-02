package ${package.ServiceImpl};

import cn.hutool.core.util.ObjectUtil;
import com.wsw.cloud.starter.data.util.CopierUtil;
import com.wsw.cloud.starter.data.service.impl.BaseServiceImpl;
import com.wsw.cloud.starter.exception.page.PageVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import ${cfg.vo}.*;
import ${cfg.evt}.*;
import com.wsw.cloud.starter.data.util.PageBuild;
import com.wsw.cloud.starter.data.util.R;
import com.wsw.cloud.starter.exception.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
* ${table.comment!} 服务实现类
* </p>
* @author ${author}
* @since ${date}
*/
@Service
@AllArgsConstructor
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends BaseServiceImpl<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public PageVo<${entity}PageVo> page(${entity}PageEvt param) {
        Page<${entity}PageVo> page = PageBuild.buildOrder(param);
        return R.page(this.baseMapper.page(page, param));
    }

    @Override
    public ${entity}InfoVo info(Long id) {
        ${entity} entity = this.getInfoById(id);
        return CopierUtil.copyProperties(entity, ${entity}InfoVo.class);
    }

    @Override
    public Result saveUpdate(${entity}Evt param) {
        ${entity} entity;
        if (ObjectUtil.isNull(param.getId())) {
            entity = new ${entity}();
            BeanUtils.copyProperties(param, entity);
        } else {
            entity = this.getInfoById(param.getId());
            BeanUtils.copyProperties(param, entity);
        }
        return this.saveOrUpdate(entity) ? R.success() : R.error();
    }

    @Override
    public Result removes(List<Long> ids) {
        return this.removeByIds(ids) ? R.success() : R.error();
    }

}
</#if>