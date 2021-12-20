package com.springboot.dao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.domain.Book;
import com.springboot.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sunmoon
 * @create 2021-12-15-20:43
 */
@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(13);
        book.setType("测试数据321");
        book.setName("测试数据321");
        book.setDescription("测试数据321");
        bookService.update(book);
    }
    @Test
    void testDelete(){
        bookService.delete(13);
    }
    @Test
    void testGetAll(){
        bookService.getAll();
    }
    @Test
    void testPage(){
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
    }
}
