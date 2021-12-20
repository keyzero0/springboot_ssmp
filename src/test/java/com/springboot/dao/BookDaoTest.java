package com.springboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sunmoon
 * @create 2021-12-15-19:49
 */
@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;
    @Test
    void testGetByID(){
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(12);
        book.setType("测试数据321");
        book.setName("测试数据321");
        book.setDescription("测试数据321");
        bookDao.updateById(book);
    }
    @Test
    void testDelete(){
        bookDao.deleteById(12);
    }
    @Test
    void testGetAll(){
      bookDao.selectList(null);
    }
    @Test
    void testGetPage(){

        IPage page = new Page(2,5);
        bookDao.selectPage(page,null);
    }
    @Test
    void testGetBy(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("type", "理论");
        bookDao.selectList(wrapper);
    }
    @Test
    void testGetBy1(){
        String name = "1";
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(name != null,Book::getName,name);
        bookDao.selectList(wrapper);
    }

}
