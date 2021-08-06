package furama_resort.controller;

import furama_resort.model.dto.ContractDto;
import furama_resort.model.entity.Contract;
import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Employee;
import furama_resort.model.entity.Service;
import furama_resort.model.service.IContractService;
import furama_resort.model.service.ICustomerService;
import furama_resort.model.service.IEmployeeService;
import furama_resort.model.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IServiceService serviceService;
    @ModelAttribute("customerList")
    public List<Customer> customerList(){
        return customerService.findAll();
    }
    @ModelAttribute("employeeList")
    public List<Employee> employeeList(){
        return employeeService.findAll();
    }
    @ModelAttribute("serviceList")
    public List<Service> serviceList(){
        return serviceService.findAll();
    }
    @GetMapping("contract-list")
    public String showListCustomer(@PageableDefault(value = 3) Pageable pageable, @RequestParam("search") Optional<String> name,
                                   Model model){
        String search="";
        if (name.isPresent()){
            search= name.orElse(null);
        }
        model.addAttribute("searchName",search);
        model.addAttribute("contractList",contractService.contractList(search,pageable));
        return "contract/list";
    }
    @GetMapping("/contract-create")
    public String create(Model model){
        model.addAttribute("contractDto",new ContractDto());
        return "contract/create";
    }
    @PostMapping("/contract-create")
    public String create(@Valid @ModelAttribute("contractDto")ContractDto contractDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("contractDto" , contractDto);
            return "contract/create";
        }
        Contract contract= new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        return "redirect:/contract-list";
    }
    @GetMapping("/contract-edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        Contract contract= contractService.findById(id);
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract,contractDto);
        model.addAttribute("contractDto",contractDto);
        return "contract/edit";
    }
    @PostMapping("/contract-edit")
    public String update(@Valid @ModelAttribute("contractDto")ContractDto contractDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("contractDto" , contractDto);
            return "contract/edit";
        }
        Contract contract= new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        return "redirect:/contract-list";
    }
    @GetMapping("/contract-delete")
    public String delete(@RequestParam("id") Integer id){
        contractService.deleteById(id);
        return "redirect:/contract-list";
    }
}
