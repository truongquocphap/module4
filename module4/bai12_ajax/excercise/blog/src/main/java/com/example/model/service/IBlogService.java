package com.example.model.service;
import com.example.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IBlogService {
    Page<Blog> blogList(Pageable pageable);
    List<Blog> findAll();
    Blog findById(Integer id);
    List<Blog> findAllByCategory_Id(Integer id);
    Page<Blog> findAllByNameContaining(Pageable pageable,String name);
}
