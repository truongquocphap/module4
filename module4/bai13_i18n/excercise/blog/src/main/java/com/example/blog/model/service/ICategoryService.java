package com.example.blog.model.service;


import com.example.blog.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    List<Category> findAll();
    void save(Category blog);
    void delete(Integer id);
    Category findById(Integer id);


}
