package com.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.domain.Book;

import java.util.List;

/**
 * @author sunmoon
 * @create 2021-12-15-20:36
 */

public interface BookService {

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage,int pageSize);
}
