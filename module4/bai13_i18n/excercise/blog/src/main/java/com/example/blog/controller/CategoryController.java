package com.example.blog.controller;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.entity.Category;
import com.example.blog.model.service.IBlogService;
import com.example.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
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
    public String createCategory(@ModelAttribute("category") Category category, Model model){
        model.addAttribute("blog",new Category());
        iCategoryService.save(category);
        return "redirect:/show-category";
    }
    @GetMapping("delete-category")
    public String deleteCategory(@RequestParam("id") Integer id){
        iCategoryService.delete(id);
        return "redirect:/show-category";
    }
    @GetMapping("edit-category/{id}")
    public String createCategory(@PathVariable("id") Integer id, Model model){
        Category category=iCategoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }
    @PostMapping("edit-category")
    public String editCategory(@ModelAttribute("category") Category category,Model model){
        iCategoryService.save(category);
        return "redirect:/show-category";
    }
    @GetMapping("blog-list-category/{id}")
    public String blogListCategory( @PathVariable("id") Integer id,
                                    Model model){
        model.addAttribute("blogList",iBlogService.findAllByCategory_Id(id));
        return "category/blog_list_category";
    }
    @GetMapping("view/{id}")
    public String viewBlog( @PathVariable("id") Integer id ,
                            Model model){
        Blog blog=iBlogService.findById(id);
        model.addAttribute("blogList",blog);
        return "blog/view";
    }
}
