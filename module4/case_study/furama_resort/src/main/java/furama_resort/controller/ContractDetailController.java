package furama_resort.controller;

import furama_resort.model.dto.ContractDetailDto;
import furama_resort.model.dto.ContractDto;
import furama_resort.model.entity.AttachService;
import furama_resort.model.entity.Contract;
import furama_resort.model.entity.ContractDetail;
import furama_resort.model.service.IAttachServiceService;
import furama_resort.model.service.IContractDetailService;
import furama_resort.model.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
    @GetMapping("/contract-detail-create")
    public String create(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        return "contract_detail/create";
    }
    @PostMapping("/contract-detail-create")
    public String create(@Valid @ModelAttribute("contractDetailDto")ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("contractDetailDto" , contractDetailDto);
            return "contract_detail/create";
        }
        ContractDetail contractDetail= new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        contractDetail.setDeleteFlag(1);
        contractDetailService.save(contractDetail);
        return "redirect:/contract-detail-list";
    }

}
