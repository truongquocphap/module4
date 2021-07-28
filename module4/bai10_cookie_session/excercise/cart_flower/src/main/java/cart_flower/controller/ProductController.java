package cart_flower.controller;

import cart_flower.model.entity.Cart;
import cart_flower.model.entity.Product;
import cart_flower.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("product", productService.findAll());
        return "list";
    }

    @GetMapping("add/{id}")
    public String view(@PathVariable("id") Integer id,
                       @SessionAttribute("cart") Cart cart, @RequestParam(value = "action") String action,
                       RedirectAttributes redirectAttributes) {
        Optional<Product> optionalProduct = productService.findById(id);
        System.out.printf("ddoi tuogn " + action);
        if (!optionalProduct.isPresent()) {
            return "404";
        } else if (action.equals("+")) {
            cart.addProduct(optionalProduct, action);
            return "redirect:/carts";
        } else if (action.equals("-")) {
            cart.addProduct(optionalProduct, action);
            return "redirect:/carts";
        } else if (action.equals("delete")) {
            cart.addProduct(optionalProduct, action);
            return "redirect:/carts";
        }
        redirectAttributes.addFlashAttribute("product", cart.addProduct(optionalProduct, action));
        return "redirect:/";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Optional<Product> optionalProduct = productService.findById(id);
        model.addAttribute("products", optionalProduct.get());
        return "view";
    }
}
