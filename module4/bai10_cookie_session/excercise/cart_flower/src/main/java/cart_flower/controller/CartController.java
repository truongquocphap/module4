package cart_flower.controller;

import cart_flower.model.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CartController {
    @GetMapping("carts")
    public String showCart(@SessionAttribute(name = "cart", required = false) Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }
}
