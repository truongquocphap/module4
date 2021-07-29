package com.example.blog.model.service.impl;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.repository.IBlogRepository;
import com.example.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAllByCategory_Id(Integer id) {
        return iBlogRepository.findAllByCategory_Id(id);
    }
}
