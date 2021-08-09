package furama_resort.model.service;

import furama_resort.model.entity.Contract;
import furama_resort.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> contractList(String name, Pageable pageable);
    Contract findById(Integer id);
    void save(Contract contract);
    void deleteById(Integer id);
    List<Contract> findAll();
    Page<Contract> contractUseServiceList(Pageable pageable,String name);
}
