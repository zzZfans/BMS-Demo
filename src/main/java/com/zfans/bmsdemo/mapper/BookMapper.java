package com.zfans.bmsdemo.mapper;

import com.github.pagehelper.Page;
import com.zfans.bmsdemo.entity.Book;
import com.zfans.bmsdemo.entity.vo.BookVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 14:08
 */
@Repository
public interface BookMapper {

    /**
     * 新增图书
     *
     * @param book 图书
     * @return 成功 - true 失败 - false
     */
    boolean insert(Book book);

    @Delete("delete from book where id = #{id}")
    boolean deleteById(Long id);

    @Update("update book set " +
            "name = #{name}, author = #{author}, " +
            "publish = #{publish}, price = #{price}, " +
            "description = #{description}, amount = #{amount} " +
            "where id = #{id}")
    boolean update(Book book);

    @Select("select * from book")
    List<Book> selectAll();

    List<BookVo> selectAllBookVo();

    @Select("select * from book")
    Page<Book> selectAllForPage();

    Page<BookVo> selectAllForPageBookVo();

    @Select("select * from book where name like concat('%', #{name}, '%')")
    List<Book> fuzzySelectByName(String name);

    List<BookVo> fuzzySelectByNameBookVo(String name);

    @Select("select * from book where author = #{author}")
    List<Book> selectByAuthor(String author);

    List<BookVo> selectByAuthorBookVo(String author);
}
