package ${package.Controller};

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import ${cfg.dto}.*;
import ${cfg.vo}.*;
import ${package.Service}.${table.serviceName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
<#if restControllerStyle>
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 */
@Slf4j
@Api(tags = "${table.comment}")
@RestController
<#if restControllerStyle>
@RequestMapping(path = "<#if package.ModuleName??>${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#else>
@RequestMapping(path = "<#if package.ModuleName??>${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
</#if>
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Resource
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @ApiOperation(value = "${table.comment}列表")
    @PostMapping(value = "/page")
    public Result<PageVO<${entity}PageVO>> page(@ApiParam("条件") @RequestBody ${entity}PageDTO param) {
        return R.success(${table.serviceName?uncap_first}.page(param));
    }

    @ApiOperation(value = "${table.comment}详情")
    @GetMapping(value = "/{id}/info")
    public Result<${entity}InfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(${table.serviceName?uncap_first}.info(id));
    }

    @ApiOperation(value = "${table.comment}新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("${table.comment}") @Valid @Validated(Save.class) @RequestBody ${entity}DTO param) {
        return R.success(${table.serviceName?uncap_first}.save(param));
    }

    @ApiOperation(value = "${table.comment}修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("${table.comment}") @Valid @Validated(Update.class) @RequestBody ${entity}DTO param) {
        return R.success(${table.serviceName?uncap_first}.update(param));
    }

    @ApiOperation(value = "${table.comment}删除")
    @DeleteMapping(value = "/removes")
    public Result<Boolean> removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return R.success(${table.serviceName?uncap_first}.removes(ids));
    }

}
</#if>