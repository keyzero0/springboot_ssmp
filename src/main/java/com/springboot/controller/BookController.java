package com.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
//@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService service;

    @RequestMapping
    public List<Book> getAll(){
        return service.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book) throws IOException {



        return service.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return service.updateById(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return service.removeById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        return service.getPage(currentPage,pageSize);
    }

}
