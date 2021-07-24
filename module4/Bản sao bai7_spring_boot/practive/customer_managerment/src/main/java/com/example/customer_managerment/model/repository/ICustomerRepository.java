package com.example.customer_managerment.model.repository;
import com.example.customer_managerment.model.bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long > {
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
