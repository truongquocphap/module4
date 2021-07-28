package blog_manager.model.service;

import blog_manager.model.bean.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    List<Blog> findByTitle(String title);

    void delete(Long id);
}

