package com.zfans.bmsdemo.mapper;

import com.zfans.bmsdemo.entity.BookCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 14:48
 */
@Repository
public interface BookCategoryMapper {
    /**
     * 新增图书-图书类型关系
     *
     * @param bookCategory 图书-图书类型
     * @return 成功 - true 失败 - false
     */
    @Insert("insert into book_category(book_id,category_id) " +
            "value(#{bookId},#{categoryId})")
    boolean insert(BookCategory bookCategory);

    @Select("select count(*) from book_category where category_id = #{id}")
    Long countByCategoryId(Long id);

    @Delete("delete from book_category where book_id = #{id}")
    boolean deleteByBookId(Long id);

    @Select("select category_id from book_category where book_id = #{id}")
    List<Long> selectCategoryIdListByBookId(Long id);

    boolean deleteByCategoryIdList(List<Long> categoryIdList);

    boolean insertBookCategoryList(List<BookCategory> bookCategoryList);
}
