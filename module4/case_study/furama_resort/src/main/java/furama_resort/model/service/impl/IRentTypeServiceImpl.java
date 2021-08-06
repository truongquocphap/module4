package furama_resort.model.service.impl;

import furama_resort.model.entity.RentType;
import furama_resort.model.repository.IRentTypeRepository;
import furama_resort.model.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRentTypeServiceImpl implements IRentTypeService {
    @Autowired
    IRentTypeRepository rentTypeService;
    @Override
    public List<RentType> findAll() {
        return rentTypeService.findAll();
    }
}
