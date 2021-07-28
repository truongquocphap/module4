package product_manage.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_manage.model.bean.Product;
import product_manage.model.repository.IProductRepository;

import java.util.List;

@Controller

public class ProductController {
    @Autowired
    IProductRepository iProductRepository;

    @GetMapping("/")
    public String index(Model model, RedirectAttributes redirect) {

        List<Product> productList = iProductRepository.findAll();
        model.addAttribute("product", productList);
        redirect.addFlashAttribute("message", "");
        return "/product_list";
    }

    @PostMapping("search")
    public String search(@RequestParam("name") String name, Model model) {
        Product productList = iProductRepository.finByName(name);
        if (productList==null) {
            model.addAttribute("message", "Tên bạn nhập không tìm thấy");

        }else {
            model.addAttribute("product",productList);
        }


        return "/product_list";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("save")
    public String save(Product product,Model model){
        iProductRepository.save(product);
        model.addAttribute("message","Bạn đã insert thành công");
        return "redirect:/";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("product",iProductRepository.findById(id));
        return "/edit";
    }
    @PostMapping("update")
    public String update(Product product){
        iProductRepository.update(product);
        return "redirect:/";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",iProductRepository.findById(id));
        return "/delete";
    }
    @PostMapping("delete")
    public String delete(Product product){
        iProductRepository.remove(product);
       return "redirect:/";
    }
    @GetMapping("{id}/view")
    public String views(@PathVariable int id,Model model){
        model.addAttribute("product",iProductRepository.findById(id));
        return "/view";
    }
}
