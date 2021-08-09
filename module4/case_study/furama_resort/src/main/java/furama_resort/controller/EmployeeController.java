package furama_resort.controller;

import furama_resort.model.dto.CustomerDto;
import furama_resort.model.dto.EmployeeDto;
import furama_resort.model.entity.*;
import furama_resort.model.service.IDivisionService;
import furama_resort.model.service.IEducationService;
import furama_resort.model.service.IEmployeeService;
import furama_resort.model.service.IPositionService;
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
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationService educationService;
    @Autowired
    IDivisionService divisionService;
    @ModelAttribute("positionList")
    public List<Position> positionList(){
        return  positionService.findAll();
    }
    @ModelAttribute("educationList")
    public List<EducationEmployee> educationList(){
        return  educationService.findAll();
    }
    @ModelAttribute("divisionList")
    public List<DivisionEmployee> divisionList(){
        return  divisionService.findAll();
    }
    @GetMapping("/employee-list")
    public String showListEmployee(@PageableDefault(value = 3) Pageable pageable, @RequestParam("search") Optional<String> name,
                                   Model model){
        String search="";
        if (name.isPresent()){
            search= name.orElse(null);
        }
        model.addAttribute("searchName",search);
        model.addAttribute("employeeList",employeeService.employeeList(search,pageable));
        return "employee/list";
    }
    @GetMapping("/employee-create")
    public String create(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        return "employee/create";
    }
    @PostMapping("/employee-create")
    public String create(@Valid @ModelAttribute("employeeDto")EmployeeDto employeeDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("employeeDto" , employeeDto);
            return "employee/create";
        }
        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setDeleteFlag(1);
        employeeService.save(employee);
        return "redirect:/employee-list";
    }
    @GetMapping("/employee-edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        Employee employee= employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "employee/edit";
    }
    @PostMapping("/employee-edit")
    public String update(@Valid @ModelAttribute("employeeDto")EmployeeDto employeeDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("employeeDto" , employeeDto);
            return "employee/edit";
        }
        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        return "redirect:/employee-list";
    }
    @GetMapping("/employee-delete")
    public String delete(@RequestParam("id") Integer id){
        employeeService.findById(id).setDeleteFlag(0);
        employeeService.save(employeeService.findById(id));
        return "redirect:/employee-list";
    }
}
