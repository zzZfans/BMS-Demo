package com.zfans.bmsdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zfans.bmsdemo.entity.Book;
import com.zfans.bmsdemo.entity.BookCategory;
import com.zfans.bmsdemo.entity.Category;
import com.zfans.bmsdemo.entity.vo.BookVo;
import com.zfans.bmsdemo.mapper.BookCategoryMapper;
import com.zfans.bmsdemo.mapper.BookMapper;
import com.zfans.bmsdemo.mapper.CategoryMapper;
import com.zfans.bmsdemo.service.BookService;
import com.zfans.bmsdemo.util.page.PageResult;
import com.zfans.bmsdemo.util.page.PageUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author Zfans
 * @DateTime 2021/6/16 14:35
 */
// @Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookCategoryMapper bookCategoryMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean insert(BookVo bookVo) {

        Book book = new Book();

        BeanUtils.copyProperties(bookVo, book);

        bookMapper.insert(book);

        if (bookVo.getCategoryList() != null) {
            if (!bookVo.getCategoryList().isEmpty()) {
                List<BookCategory> bookCategoryList = bookVo.getCategoryList()
                        .stream()
                        .map(ele -> new BookCategory().setBookId(book.getId()).setCategoryId(ele.getId()))
                        .collect(Collectors.toList());
                bookCategoryMapper.insertBookCategoryList(bookCategoryList);
            }
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean deleteById(Long id) {
        bookCategoryMapper.deleteByBookId(id);
        bookMapper.deleteById(id);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean update(BookVo bookVo) {

        List<Long> newcategoryIdList = bookVo
                .getCategoryList()
                .stream()
                .map(Category::getId)
                .collect(Collectors.toList());

        List<Long> oldCategoryIdList = bookCategoryMapper.selectCategoryIdListByBookId(bookVo.getId());

        List<BookCategory> insertList = newcategoryIdList
                .stream()
                .filter(ele -> !oldCategoryIdList.contains(ele))
                .map(ele -> new BookCategory().setBookId(bookVo.getId()).setCategoryId(ele))
                .collect(Collectors.toList());

        bookCategoryMapper.insertBookCategoryList(insertList);

        List<Long> deleteList = oldCategoryIdList
                .stream()
                .filter(ele -> !newcategoryIdList.contains(ele))
                .collect(Collectors.toList());

        bookCategoryMapper.deleteByCategoryIdList(deleteList);

        Book book = new Book();

        BeanUtils.copyProperties(bookVo, book);

        bookMapper.update(book);

        return true;
    }

    private List<BookVo> bookListToBookVoList(List<Book> bookList) {
        return bookList
                .stream()
                .map(book -> {

                    BookVo bookVo = new BookVo();

                    BeanUtils.copyProperties(book, bookVo);

                    List<Category> categoryList = bookCategoryMapper
                            .selectCategoryIdListByBookId(book.getId())
                            .stream()
                            .map(categoryId -> new Category()
                                    .setId(categoryId)
                                    .setName(categoryMapper.selectById(categoryId).getName()))
                            .collect(Collectors.toList());

                    bookVo.setCategoryList(categoryList);

                    return bookVo;

                }).collect(Collectors.toList());
    }

    @Override
    public List<BookVo> selectAll() {
        return bookListToBookVoList(bookMapper.selectAll());
    }

    @Override
    public List<BookVo> selectAllBookVo() {
        return bookMapper.selectAllBookVo();
    }

    @Override
    public PageResult selectOfPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Book> bookList = bookMapper.selectAllForPage();

        PageInfo<BookVo> pageInfo = new PageInfo<>(bookListToBookVoList(bookList));

        return PageUtil.getPageResult(pageInfo);
    }

    @Override
    public PageResult selectOfPageBookVo(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<BookVo> bookVoList = bookMapper.selectAllForPageBookVo();

        PageInfo<BookVo> pageInfo = new PageInfo<>(bookVoList);

        return PageUtil.getPageResult(pageInfo);
    }

    @Override
    public List<BookVo> fuzzySelectByName(String name) {
        return bookListToBookVoList(bookMapper.fuzzySelectByName(name));
    }

    @Override
    public List<BookVo> fuzzySelectByNameBookVo(String name) {
        return bookMapper.fuzzySelectByNameBookVo(name);
    }

    @Override
    public List<BookVo> selectByAuthor(String author) {
        return bookListToBookVoList(bookMapper.selectByAuthor(author));
    }

    @Override
    public List<BookVo> selectByAuthorBookVo(String author) {
        return bookMapper.selectByAuthorBookVo(author);
    }
}
