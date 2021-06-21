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

    List<BookVo> selectAllBookVo();

    PageResult selectOfPage(int pageNum, int pageSize);

    PageResult selectOfPageBookVo(int pageNum, int pageSize);

    List<BookVo> fuzzySelectByName(String name);

    List<BookVo> fuzzySelectByNameBookVo(String name);

    List<BookVo> selectByAuthor(String author);

    List<BookVo> selectByAuthorBookVo(String author);
}
