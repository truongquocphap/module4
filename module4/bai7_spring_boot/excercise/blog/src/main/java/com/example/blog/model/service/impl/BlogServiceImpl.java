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
    public Page<Blog> findAll(String name,Pageable pageable) {
        return iBlogRepository.blogList(name,pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
    iBlogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findAllByCategory_Id(Integer id) {
        return iBlogRepository.findAllByCategory_Id(id);
    }
}
