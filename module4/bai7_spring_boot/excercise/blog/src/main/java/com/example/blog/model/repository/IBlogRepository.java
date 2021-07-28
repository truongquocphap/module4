package com.example.blog.model.repository;

import com.example.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer > {
    @Query(value = "select * from blog where name like %?1% order by date",nativeQuery = true)
    Page<Blog> blogList(String name,Pageable pageable);
     List<Blog> findAllByCategory_Id(Integer id);
}
