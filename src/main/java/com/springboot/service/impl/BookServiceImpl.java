package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.dao.BookDao;
import com.springboot.domain.Book;
import com.springboot.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunmoon
 * @create 2021-12-16-19:50
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book) {

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription,book.getDescription());
        IPage<Book> page = new Page(currentPage,pageSize);
        return bookDao.selectPage(page,lqw);
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize) {

        IPage<Book> page = new Page(currentPage,pageSize);
        return bookDao.selectPage(page,null);

    }
}
