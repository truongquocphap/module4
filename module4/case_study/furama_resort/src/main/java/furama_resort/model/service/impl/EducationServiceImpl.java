package furama_resort.model.service.impl;

import furama_resort.model.entity.EducationEmployee;
import furama_resort.model.repository.IEducationRepository;
import furama_resort.model.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationServiceImpl implements IEducationService {
    @Autowired
    IEducationRepository educationRepository;
    @Override
    public List<EducationEmployee> findAll() {
        return educationRepository.findAll();
    }
}
