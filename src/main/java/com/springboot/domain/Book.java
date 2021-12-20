package com.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sunmoon
 * @create 2021-12-15-19:39
 */
@Data
public class Book {
    private int id;
    private String type;
    private String name;
    private String description;
}
