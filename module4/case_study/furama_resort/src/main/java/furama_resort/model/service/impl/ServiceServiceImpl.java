package furama_resort.model.service.impl;

import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Service;
import furama_resort.model.repository.IServiceRepository;
import furama_resort.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ServiceServiceImpl implements ICustomerService {
    @Autowired
    IServiceRepository serviceRepository;
    @Override
    public Page<Service> employeeList(String name, Pageable pageable) {
        return serviceRepository.serviceList(name,pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
