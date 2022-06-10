package ${cfg.dto};

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * ${table.comment!} 新增修改DTO
 *
 * @author ${author}
 */
@Data
public class ${entity}DTO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

}
