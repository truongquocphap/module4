package blog_manager.model.repository;

import blog_manager.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    List<Blog> findByTitle(String title);
}
