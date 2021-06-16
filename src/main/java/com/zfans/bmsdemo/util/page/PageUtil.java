package com.zfans.bmsdemo.util.page;

import com.github.pagehelper.PageInfo;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 18:33
 */
public class PageUtil {
    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo
     * @return PageResult
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
