package com.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.controller.utils.R;
import com.springboot.domain.Book;
import com.springboot.service.BookService;
import com.springboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author sunmoon
 * @create 2021-12-16-20:05
 */
@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService service;

    @RequestMapping
    public R getAll(){
        return new R(true,service.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if(book.getName().equals("123"))throw new IOException();
        boolean flag = service.save(book);
        return new R(flag,flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(service.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(service.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,service.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
//        IPage<Book> page = service.getPage(currentPage, pageSize);
//        if(currentPage > page.getPages()){
//            page = service.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(true,page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Book book){
        System.out.println(book);
        IPage<Book> page = service.getPage(currentPage, pageSize,book);
        if(currentPage > page.getPages()){
            page = service.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }
}