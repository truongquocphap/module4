package com.example.controller;

import com.example.model.entity.Blog;
import com.example.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/blog_list")
public class BlogRestController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogList = iBlogService.blogList(pageable);
        if (!blogList.isEmpty()) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> showSearch(@PageableDefault(value = 3) Pageable pageable, @RequestParam("name") String name) {
        Page<Blog> blogList = iBlogService.findAllByNameContaining(pageable, name);
        if (!blogList.isEmpty()) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
