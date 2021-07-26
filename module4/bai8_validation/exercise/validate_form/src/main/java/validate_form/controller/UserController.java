package validate_form.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import validate_form.model.dto.UserDto;
import validate_form.model.entity.User;
import validate_form.model.service.IUserService;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/")
    public String showCreate(Model model){
        model.addAttribute("userDto", new UserDto());
        return "index";
    }
    @PostMapping("/")
    public String save(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
           model.addAttribute("userDto",userDto);
                return "index";
        }else {
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            iUserService.save(user);
            return "result";
        }
    }
}
