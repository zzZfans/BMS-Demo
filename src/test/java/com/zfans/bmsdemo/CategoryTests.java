package com.zfans.bmsdemo;

import com.zfans.bmsdemo.entity.Category;
import com.zfans.bmsdemo.mapper.CategoryMapper;
import com.zfans.bmsdemo.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 10:38
 */
@SpringBootTest
public class CategoryTests {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryService categoryService;

    @Test
    void categoryInsertTest() {
        Category category = new Category();
        category.setName("testInBmsDemoApplicationTests3");
        System.out.println(categoryMapper.insert(category));
        System.out.println(category);
    }

    @Test
    void categoryDeleteTest() {
        System.out.println(categoryMapper.deleteById(1L));
    }

    @Test
    void categoryUpdateTest() {
        Category category = new Category();
        category.setId(3L).setName("updateTest");
        System.out.println(categoryMapper.update(category));
    }

    @Test
    void categorySelectByIdTest() {
        System.out.println(categoryMapper.selectById(8L));
    }

    @Test
    void categorySelectAllTest() {
        System.out.println(categoryMapper.selectAll());
    }

    @Test
    void categorySelectAllForPageTest() {
        System.out.println(categoryMapper.selectAllForPage());
        System.out.println(categoryService.selectOfPage(2, 2));
    }

    @Test
    void categorySelectByLikeTest() {
        System.out.println(categoryMapper.fuzzySelectByName("T"));
    }

    @Test
    void categorySelectByIdListTest() {
        // 参数不能为 null，不能为 空 List
        System.out.println(categoryMapper.selectByidList(Stream.of(3L, 5L).collect(Collectors.toList())));
    }
}
