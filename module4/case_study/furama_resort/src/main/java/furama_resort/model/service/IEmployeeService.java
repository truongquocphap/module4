package furama_resort.model.service;

import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> employeeList(String name, Pageable pageable);
    Employee findById(Integer id);
    void save(Employee employee);
    void deleteById(Integer id);
    List<Employee> findAll();
}
