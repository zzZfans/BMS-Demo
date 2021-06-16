package com.zfans.bmsdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zfans.bmsdemo.entity.Category;
import com.zfans.bmsdemo.exception.BMSDemoException;
import com.zfans.bmsdemo.mapper.BookCategoryMapper;
import com.zfans.bmsdemo.mapper.CategoryMapper;
import com.zfans.bmsdemo.ret.ResultCodeEnum;
import com.zfans.bmsdemo.service.CategoryService;
import com.zfans.bmsdemo.util.page.PageResult;
import com.zfans.bmsdemo.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 10:55
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BookCategoryMapper bookCategoryMapper;

    @Override
    public boolean insert(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean deleteById(Long id) {
        if (bookCategoryMapper.countByCategoryId(id) > 0) {
            throw new BMSDemoException(ResultCodeEnum.UNABLE_TO_REMOVE_DEPENDENCIES);
        }
        return categoryMapper.deleteById(id);
    }

    @Override
    public boolean update(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public PageResult selectOfPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categoryList = categoryMapper.selectAllForPage();
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        return PageUtil.getPageResult(pageInfo);
    }

    @Override
    public List<Category> selectByLike(String name) {
        return categoryMapper.selectByLike(name);
    }

    @Override
    public List<Category> selectByidList(List<Long> idList) {
        return categoryMapper.selectByidList(idList);
    }
}
