package furama_resort.model.service.impl;

import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Service;
import furama_resort.model.repository.IServiceRepository;
import furama_resort.model.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public Page<Service> serviceList(String name, Pageable pageable) {
        return serviceRepository.serviceList(name, pageable);
    }

    @Override
    public Service findById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteById(Integer id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
