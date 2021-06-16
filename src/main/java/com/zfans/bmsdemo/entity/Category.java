package com.zfans.bmsdemo.entity;

import com.zfans.bmsdemo.group.Create;
import com.zfans.bmsdemo.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * <p>
 * 图书类型
 * </p>
 *
 * @author Zfans
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Category对象", description = "图书类型")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Null(message = "新增时，id应该为null", groups = Create.class)
    @NotNull(message = "更新时，id不应该为null", groups = Update.class)
    @ApiModelProperty(value = "类别ID")
    private Long id;

    @NotBlank(message = "图书类型名称不能为空字符串", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "类别名称")
    private String name;
}
