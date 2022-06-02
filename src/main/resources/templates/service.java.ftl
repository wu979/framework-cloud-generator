package ${package.Service};

import com.wsw.cloud.starter.data.service.IBaseService;
import com.wsw.cloud.starter.exception.page.PageVo;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${cfg.vo}.*;
import ${cfg.evt}.*;
import com.wsw.cloud.starter.exception.result.Result;

import java.util.List;

/**
* <p>
* ${table.comment!} 服务类
* </p>
* @author ${author}
* @since ${date}
*/
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends IBaseService<${entity}> {

    PageVo<${entity}PageVo> page(${entity}PageEvt param);

    ${entity}InfoVo info(Long id);

    Result saveUpdate(${entity}Evt param);

    Result removes(List<Long> ids);

}
</#if>