package com.zfans.bmsdemo.entity.vo;

import com.zfans.bmsdemo.entity.Category;
import com.zfans.bmsdemo.group.Create;
import com.zfans.bmsdemo.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 图书
 * </p>
 *
 * @author Zfans
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Book对象", description = "图书")
public class BookVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Null(message = "新增时，id应该为null", groups = Create.class)
    @NotNull(message = "更新时，id不应该为null", groups = Update.class)
    @ApiModelProperty(value = "图书ID")
    private Long id;

    @NotBlank(message = "图书名称不能为空字符串", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "图书名称")
    private String name;

    @NotBlank(message = "图书作者不能为空字符串", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "图书作者")
    private String author;

    @NotBlank(message = "图书发行商不能为空字符串", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "图书发行商")
    private String publish;

    @Digits(integer = 10, fraction = 2, message = "价格格式不正确", groups = {Create.class, Update.class})
    @DecimalMin(value = "0.00", message = "价格不低于0.00", groups = {Create.class, Update.class})
    @NotNull(message = "价格不能为空", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "图书价格")
    private BigDecimal price;

    @NotBlank(message = "内容简介不能为空字符串", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "内容简介")
    private String description;

    @Min(value = 0, message = "最小为 0", groups = {Create.class, Update.class})
    @Max(value = Long.MAX_VALUE, message = "最大为 Long.MAX_VALUE", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "图书数量")
    private Long amount;

    @ApiModelProperty(value = "图书类型列表")
    private List<Category> categoryList;
}
