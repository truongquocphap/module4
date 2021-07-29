package com.example.blog.model.service;

import com.example.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();
    Blog findById(Integer id);
    List<Blog> findAllByCategory_Id(Integer id);
}
