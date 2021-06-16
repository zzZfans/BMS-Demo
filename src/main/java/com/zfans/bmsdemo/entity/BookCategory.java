package com.zfans.bmsdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 图书 >-< 类别
 * </p>
 *
 * @author Zfans
 * @since 2021-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "BookCategory对象", description = "图书 >-< 类别")
public class BookCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书ID")
    private Long bookId;

    @ApiModelProperty(value = "类别ID")
    private Long categoryId;

}
