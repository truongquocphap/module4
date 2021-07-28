package customer_manager.model.repository;

import customer_manager.model.bean.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);

    public void edit(Customer customers);

    boolean exists(Long id);

    List<Customer> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
