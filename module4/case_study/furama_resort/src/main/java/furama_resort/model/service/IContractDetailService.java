package furama_resort.model.service;

import furama_resort.model.entity.ContractDetail;
import furama_resort.model.dto.ContractDetailOther;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    Page<ContractDetail> contractDetailList(String name, Pageable pageable);
    ContractDetail findById(Integer id);
    void save(ContractDetail contractDetail);
    void deleteById(Integer id);
    List<ContractDetail> findAll();
    List<ContractDetailOther> contractDetailOtherList();
    List<ContractDetail> findAllByContract_ContractId(Integer id);
}
