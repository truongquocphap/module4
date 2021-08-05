package furama_resort.model.service.impl;

import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Service;
import furama_resort.model.repository.ICustomerRepository;
import furama_resort.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public Page<Service> employeeList(String name, Pageable pageable) {
        return customerRepository.customerList(name,pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
    customerRepository.save(customer);
    }

    @Override
    public void deleteById(Integer id) {
    customerRepository.deleteById(id);
    }
}
