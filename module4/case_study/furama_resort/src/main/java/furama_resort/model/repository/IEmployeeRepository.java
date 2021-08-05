package furama_resort.model.repository;

import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee where concat(employee_name,employee_address) like %?1% ",nativeQuery = true)
    Page<Employee> customerList(String name, Pageable pageable);
}
