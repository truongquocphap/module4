package com.example.blog.controller;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.entity.Category;
import com.example.blog.model.service.IBlogService;
import com.example.blog.model.service.ICategoryService;
import com.example.blog.model.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("/")
    public String showList(@PageableDefault(value = 3) Pageable pageable, @RequestParam("search") Optional<String> name,
                           Model model){
        String search="";
        if (name.isPresent()){
            search= name.orElse(null);
        }
        model.addAttribute("searchName",search);
        model.addAttribute("blogList",iBlogService.findAll(search,pageable));
        return "blog/list";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        List<Category> categoryList=iCategoryService.findAll();
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",categoryList);
        return "blog/create";
    }
    @PostMapping("create")
    public String create(@ModelAttribute("blog") Blog blog,Model model){
        List<Category> categoryList=iCategoryService.findAll();
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",categoryList);
        iBlogService.save(blog);
        return "blog/create";
    }
    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable("id") Integer id,Model model){
        List<Category> categoryList=iCategoryService.findAll();
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("category",categoryList);
        return "blog/edit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute("blog") Blog blog,Model model){
        List<Category> categoryList=iCategoryService.findAll();
        model.addAttribute("blog",iBlogService.findById(blog.getId()));
        model.addAttribute("category",categoryList);

        iBlogService.save(blog);

        return "blog/edit";
    }
    @GetMapping("delete")
    public String delete(@RequestParam("id") Integer id){
        iBlogService.delete(id);
        return "redirect:/";
    }
    @GetMapping("show-category")
    public String showCategory(@PageableDefault(value = 3) Pageable pageable,
                           Model model){
        model.addAttribute("categoryList",iCategoryService.findAll(pageable));
        return "category/list";
    }
    @GetMapping("create-category")
    public String createCategory(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }
    @PostMapping("create-category")
    public String createCategory(@ModelAttribute("category") Category category,Model model){
        model.addAttribute("blog",new Category());
        iCategoryService.save(category);
        return "redirect:/";
    }

}
