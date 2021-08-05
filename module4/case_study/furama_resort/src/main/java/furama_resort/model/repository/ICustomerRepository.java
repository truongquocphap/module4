package furama_resort.model.repository;

import furama_resort.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where concat(customer_name,customer_code) like %?1% ",nativeQuery = true)
    Page<Customer> customerList(String name, Pageable pageable);

}
