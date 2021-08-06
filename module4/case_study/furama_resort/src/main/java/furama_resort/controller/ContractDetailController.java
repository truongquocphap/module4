package furama_resort.controller;

import furama_resort.model.entity.AttachService;
import furama_resort.model.entity.Contract;
import furama_resort.model.service.IAttachServiceService;
import furama_resort.model.service.IContractDetailService;
import furama_resort.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ContractDetailController {

    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachServiceService attachServiceService;
    @ModelAttribute("contractList")
    public List<Contract> contractList(){
        return contractService.findAll();
    }
    @ModelAttribute("attachServiceList")
    public List<AttachService> attachServicesList(){
        return attachServiceService.findAll();
    }
    @GetMapping("contract-detail-list")
    public String showListAttachService(@PageableDefault(value = 3) Pageable pageable, @RequestParam("search") Optional<String> name,
                                   Model model){
        String search="";
        if (name.isPresent()){
            search= name.orElse(null);
        }
        model.addAttribute("searchName",search);
        model.addAttribute("contractDetailList",contractDetailService.contractDetailList(search,pageable));
        return "contract_detail/list";
    }
}
