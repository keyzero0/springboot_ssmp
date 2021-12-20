package com.springboot.dao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.domain.Book;
import com.springboot.service.BookService;
import com.springboot.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author sunmoon
 * @create 2021-12-15-20:43
 */
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService bookService;

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
        book.setId(11);
        book.setType("测试数据321");
        book.setName("测试数据321");
        book.setDescription("测试数据321");
        bookService.updateById(book);
    }
    @Test
    void testDelete(){
        bookService.removeById(12);
    }
    @Test
    void testGetAll(){
        List<Book> list = bookService.list();
        System.out.println(list);
    }
    @Test
    void testPage(){
      IPage<Book> page = new Page(2,5);
        IPage<Book> page1 = bookService.page(page);
        System.out.println(page.getRecords());
    }
}
