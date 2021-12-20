package com.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.domain.Book;

/**
 * @author sunmoon
 * @create 2021-12-16-19:48
 */

public interface IBookService extends IService<Book> {

    IPage<Book> getPage(Integer currentPage,Integer pageSize,Book book);
    IPage<Book> getPage(Integer currentPage,Integer pageSize);
}
