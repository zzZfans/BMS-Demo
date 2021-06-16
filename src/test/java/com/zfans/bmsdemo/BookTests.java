package com.zfans.bmsdemo;

import com.zfans.bmsdemo.entity.Book;
import com.zfans.bmsdemo.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @Author Zfans
 * @DateTime 2021/6/16 14:22
 */
@SpringBootTest
public class BookTests {

    @Autowired
    BookMapper bookMapper;

    @Test
    void bookInsertTest() {
        Book book = new Book();
        book.setName("图解网络")
                .setAuthor("小林coding")
                .setPublish("北京大学出版社")
                .setPrice(BigDecimal.valueOf(99))
                .setDescription("图解网络");
        System.out.println(bookMapper.insert(book));
        System.out.println(book);
    }
}
