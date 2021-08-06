package furama_resort.model.service.impl;

import furama_resort.model.entity.DivisionEmployee;
import furama_resort.model.repository.IDivisionRepository;
import furama_resort.model.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;
    @Override
    public List<DivisionEmployee> findAll() {
        return divisionRepository.findAll();
    }
}
