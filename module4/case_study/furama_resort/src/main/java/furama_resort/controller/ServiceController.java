package furama_resort.controller;

import furama_resort.model.dto.CustomerDto;
import furama_resort.model.dto.ServiceDto;
import furama_resort.model.entity.Customer;
import furama_resort.model.entity.RentType;
import furama_resort.model.entity.Service;
import furama_resort.model.entity.ServiceType;
import furama_resort.model.service.IRentTypeService;
import furama_resort.model.service.IServiceService;
import furama_resort.model.service.IServiceTypeService;
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
public class ServiceController {
    @Autowired
    IServiceService serviceService;
    @Autowired
    IRentTypeService rentTypeService;
    @Autowired
    IServiceTypeService serviceTypeService;
    @ModelAttribute("rentType")
    public List<RentType> rentTypeList(){
        return rentTypeService.findAll();
    }
    @ModelAttribute("serviceType")
    public List<ServiceType> serviceTypeList(){
        return serviceTypeService.findAll();
    }
    @GetMapping("/service-list")
    public String showListService(@PageableDefault(value = 3) Pageable pageable, @RequestParam("search") Optional<String> name,
                                   Model model) {
        String search = "";
        if (name.isPresent()) {
            search = name.orElse(null);
        }
        model.addAttribute("searchName", search);
        model.addAttribute("serviceList", serviceService.serviceList(search, pageable));
        return "service/list";
    }
    @GetMapping("service-create")
    public String create(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
        return "service/create";
    }
    @PostMapping("/service-create")
    public String create(@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("serviceDto" , serviceDto);
            return "service/create";
        }
        Service service= new Service();
        BeanUtils.copyProperties(serviceDto,service);
        serviceService.save(service);
        return "redirect:/service-list";
    }
    @GetMapping("/service-edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        Service service= serviceService.findById(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service,serviceDto);
        model.addAttribute("serviceDto",serviceDto);
        return "service/edit";
    }
    @PostMapping("/service-update")
    public String update(@Valid @ModelAttribute("serviceDto")ServiceDto serviceDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("serviceDto" , serviceDto);
            return "service/edit";
        }
        Service service= new Service();
        BeanUtils.copyProperties(serviceDto,service);
        serviceService.save(service);
        return "redirect:/service-list";
    }
    @GetMapping("/service-delete")
    public String deleteService(@RequestParam("id") Integer id){
        serviceService.deleteById(id);
        return "redirect:/service-list";
    }
}
