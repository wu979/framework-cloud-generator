package ${cfg.evt};

import com.wsw.cloud.starter.data.group.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
* <p>
* ${table.comment} 前端接收类
* </p>
* @author ${author}
* @since ${date}
*/
@Data
public class ${entity}Evt {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

}
