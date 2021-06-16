package com.zfans.bmsdemo.service;

import com.zfans.bmsdemo.entity.Category;
import com.zfans.bmsdemo.util.page.PageResult;

import java.util.List;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 10:46
 */
public interface CategoryService {

    boolean insert(Category category);

    boolean deleteById(Long id);

    boolean update(Category category);

    List<Category> selectAll();

    PageResult selectOfPage(int pageNum, int pageSize);

    List<Category> selectByLike(String name);

    List<Category> selectByidList(List<Long> idList);
}
