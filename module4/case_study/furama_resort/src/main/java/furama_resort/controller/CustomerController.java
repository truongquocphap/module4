package furama_resort.controller;

import furama_resort.model.dto.CustomerDto;
import furama_resort.model.entity.Customer;
import furama_resort.model.entity.CustomerType;
import furama_resort.model.service.ICustomerService;
import furama_resort.model.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;
    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList(){
        return customerTypeService.findAll();
    }
    @GetMapping("customer-list")
    public String showListCustomer(@PageableDefault(value = 3) Pageable pageable, @RequestParam("search") Optional<String> name,
                           Model model){
        String search="";
        if (name.isPresent()){
            search= name.orElse(null);
        }
        model.addAttribute("searchName",search);
        model.addAttribute("customerList",customerService.customerList(search,pageable));
        return "customer/list";
    }
    @GetMapping("/customer-create")
    public String create(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        return "customer/create";
    }
    @PostMapping("/customer-create")
    public String create(@Valid @ModelAttribute("customerDto")CustomerDto customerDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("customerDto" , customerDto);
            return "customer/create";
        }
        customerDto.setDeleteFlag(1);
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customer.setDeleteFlag(1);
        customerService.save(customer);
        return "redirect:/customer-list";
    }
    @GetMapping("/customer-edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        Customer customer= customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        return "customer/edit";
    }
    @PostMapping("/customer-update")
    public String update(@Valid @ModelAttribute("customerDto")CustomerDto customerDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("customerDto" , customerDto);
            return "customer/edit";
        }
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        return "redirect:/customer-list";
    }
    @GetMapping("/customer-delete")
    public String delete(@RequestParam("id") Integer id){
        customerService.findById(id).setDeleteFlag(0);
        customerService.save(customerService.findById(id));
        return "redirect:/customer-list";
    }
}
