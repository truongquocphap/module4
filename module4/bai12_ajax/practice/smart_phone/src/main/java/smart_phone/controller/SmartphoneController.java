package smart_phone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartphoneController {
    @GetMapping
    public String show(){
        return "list";
    }
}
