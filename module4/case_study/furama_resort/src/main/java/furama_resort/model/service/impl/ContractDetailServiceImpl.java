package furama_resort.model.service.impl;

import furama_resort.model.entity.ContractDetail;
import furama_resort.model.repository.IContractDetailRepository;
import furama_resort.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> contractDetailList(String name, Pageable pageable) {
        return contractDetailRepository.contractDetailList(name, pageable);
    }

    @Override
    public ContractDetail findById(Integer id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void deleteById(Integer id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
