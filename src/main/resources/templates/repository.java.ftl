package ${cfg.ry};

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import ${cfg.vo}.*;
import ${cfg.dto}.*;
import ${package.Entity}.${entity};

/**
 * ${table.comment!} 数据层接口
 *
 * @author ${author}
 */
public interface ${entity}Repository extends BaseRepository<${entity}> {

    /**
     * ${table.comment!}分页列表
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

}