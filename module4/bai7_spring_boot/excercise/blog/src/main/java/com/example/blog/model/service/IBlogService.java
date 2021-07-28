package com.example.blog.model.service;

import com.example.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Page<Blog> findAll(String name,Pageable pageable);
    Blog findById(Integer id);
    void save(Blog blog);
    void delete(Integer id);
    void update(Blog blog);
    List<Blog> findAllByCategory_Id(Integer id);
}
