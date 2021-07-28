package customer_manage.controller;

import customer_manage.model.bean.Customer;
import customer_manage.model.service.ICustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
   @Autowired
    ICustomerServiceImpl iCustomerServiceImpl;

    @GetMapping("")
    public String index(Model model ,RedirectAttributes redirect) {

        List<Customer> customerList = iCustomerServiceImpl.findAll();
        model.addAttribute("customers", customerList);
        redirect.addFlashAttribute("message","");
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer ,RedirectAttributes redirect) {
        customer.setId((int) (Math.random() * 10000));
        iCustomerServiceImpl.save(customer);
        redirect.addFlashAttribute("message", "Đã thêm thành công");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerServiceImpl.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Customer customer) {
        iCustomerServiceImpl.update(customer.getId(), customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerServiceImpl.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        iCustomerServiceImpl.remove(customer.getId());
        redirect.addFlashAttribute("message", "Removed customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerServiceImpl.findById(id));
        return "/view";
    }
}
