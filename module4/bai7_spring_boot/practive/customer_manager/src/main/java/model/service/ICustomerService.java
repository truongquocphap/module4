package model.service;
import model.bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
