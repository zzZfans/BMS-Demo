package com.zfans.bmsdemo.mapper;

import com.github.pagehelper.Page;
import com.zfans.bmsdemo.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Zfans
 * @DateTime 2021/6/15 20:34
 */
@Repository
public interface CategoryMapper {

    /**
     * 新增图书类型
     *
     * @param category 图书类型
     * @return 成功 - true 失败 - false
     */
    @Insert("insert into category(name) " +
            "value(#{name})")
    // 主键回填
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean insert(Category category);

    /**
     * 新增图书类型
     *
     * @param id 图书类型 id
     * @return 成功 - true 失败 - false
     */
    @Delete("delete from category where id= #{id}")
    boolean deleteById(Long id);

    /**
     * 修改图书类型
     *
     * @param category 图书类型
     * @return 成功 - true 失败 - false
     */
    boolean update(Category category);

    /**
     * 根据 id 查询图书类型
     *
     * @param id id
     * @return 匹配的图书类型
     */
    @Select("select id,name from category where id = #{id}")
    Category selectById(Long id);

    /**
     * 查询所有图书类型
     *
     * @return 图书类型列表
     */
    List<Category> selectAll();

    /**
     * 查询所有图书类型（分页用）
     *
     * @return 图书类型（分页对象）
     */
    @Select("select * from category")
    Page<Category> selectAllForPage();

    /**
     * 根据图书类型名称模糊查询
     *
     * @param name 关键字
     * @return 匹配的图书类型列表
     */
    List<Category> fuzzySelectByName(String name);

    /**
     * 根据图书类型 id 列表查询
     *
     * @param idList 图书类型 id 列表查询
     * @return 匹配的图书类型列表
     */
    List<Category> selectByidList(List<Long> idList);
}
