package ${package.Controller};

import com.wsw.cloud.starter.data.annotation.*;
import com.wsw.cloud.starter.data.group.*;
import com.wsw.cloud.starter.data.util.R;
import com.wsw.cloud.starter.exception.page.PageVo;
import com.wsw.cloud.starter.exception.result.Result;
import ${cfg.vo}.*;
import ${cfg.evt}.*;
import ${package.Service}.${table.serviceName};
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
<#if restControllerStyle>
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

import javax.validation.Valid;
import java.util.List;

/**
* <p>
* ${table.comment} 前端控制器
* </p>
* @author ${author}
* @since ${date}
*/
@Slf4j
@Api(tags = "${table.comment}")
<#if restControllerStyle>
@WswRestController(path = "<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#else>
@WswController(path = "<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
</#if>
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @ApiOperation(value = "${table.comment}分页列表")
    @GetMapping(value = "/page")
    public PageVo<${entity}PageVo> page(@ApiParam("条件") @RequestBody ${entity}PageEvt param) {
        return ${table.serviceName?uncap_first}.page(param);
    }

    @ApiOperation(value = "${table.comment}详情")
    @GetMapping(value = "/info/{id}")
    public Result<${entity}InfoVo> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.data(${table.serviceName?uncap_first}.info(id));
    }

    @ApiOperation(value = "${table.comment}新增")
    @PostMapping(value = "/save")
    public Result save(@ApiParam("${table.comment}") @Valid @Validated(Save.class) @RequestBody ${entity}Evt param) {
        return ${table.serviceName?uncap_first}.saveUpdate(param);
    }

    @ApiOperation(value = "${table.comment}修改")
    @PostMapping(value = "/update")
    public Result update(@ApiParam("${table.comment}") @Valid @Validated(Update.class) @RequestBody ${entity}Evt param) {
        return ${table.serviceName?uncap_first}.saveUpdate(param);
    }

    @ApiOperation(value = "${table.comment}删除")
    @DeleteMapping(value = "/removes")
    public Result removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return ${table.serviceName?uncap_first}.removes(ids);
    }

}
</#if>