package com.zfans.bmsdemo.service;

import com.zfans.bmsdemo.entity.vo.BookVo;
import com.zfans.bmsdemo.util.page.PageResult;

import java.util.List;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 14:34
 */
public interface BookService {
    boolean insert(BookVo bookVo);

    boolean deleteById(Long id);

    boolean update(BookVo bookVo);

    List<BookVo> selectAll();

    PageResult selectOfPage(int pageNum, int pageSize);
}
