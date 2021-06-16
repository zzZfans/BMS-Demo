package com.zfans.bmsdemo.util.page;

import lombok.Data;

import java.util.List;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 18:33
 */
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> content;
}
