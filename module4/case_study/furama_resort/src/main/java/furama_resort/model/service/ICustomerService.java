package furama_resort.model.service;

import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Service> employeeList(String name, Pageable pageable);
    Customer findById(Integer id);
    void save(Customer customer);
    void deleteById(Integer id);
}
