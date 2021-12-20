package com.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author sunmoon
 * @create 2021-12-15-19:47
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
