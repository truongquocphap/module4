package com.example.blog.controller;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.entity.Category;
import com.example.blog.model.service.IBlogService;
import com.example.blog.model.service.ICategoryService;
import com.example.blog.model.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/blog_list")
public class BlogRestController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogList=iBlogService.blogList( pageable);
        if (blogList!=null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
