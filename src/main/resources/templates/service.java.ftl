package ${package.Service};

import com.framework.cloud.common.base.PageVO;
import ${cfg.vo}.*;
import ${cfg.dto}.*;
import ${package.Entity}.${entity};

import java.util.List;

/**
 * ${table.comment!} 服务层接口
 *
 * @author ${author}
 */
public interface ${table.serviceName} {
    /**
     * ${table.comment!} 分页
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<${entity}PageVO> page(${entity}PageDTO param);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    ${entity}InfoVO info(Long id);

    /**
     * 新增/修改
     *
     * @param param 新增修改参数
     * @return 是否成功
     */
    boolean saveUpdate(${entity}DTO param);

    /**
     * 删除
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean removes(List<Long> ids);

}