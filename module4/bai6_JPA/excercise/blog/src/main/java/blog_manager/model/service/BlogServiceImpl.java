package blog_manager.model.service;

import blog_manager.model.bean.Blog;
import blog_manager.model.repository.IBlogRepository;
import blog_manager.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByTitle(String title) {
        return iBlogRepository.findByTitle(title);
    }


    @Override
    public void delete(Long id) {
        iBlogRepository.delete(findById(id));
    }
}
