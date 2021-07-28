package com.example.customer_managerment.model.service;
import com.example.customer_managerment.model.bean.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) throws Exception;
    Page<Customer> findAll(Pageable pageable) throws Exception;
    List<Customer> findAll() throws Exception;

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
    Optional<Customer> findOne(Long id) throws Exception;
}
