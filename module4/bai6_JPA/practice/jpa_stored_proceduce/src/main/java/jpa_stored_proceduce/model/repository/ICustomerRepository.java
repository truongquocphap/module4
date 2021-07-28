package jpa_stored_proceduce.model.repository;

import jpa_stored_proceduce.model.bean.Customer;

public interface ICustomerRepository {
    void insertWithStoredProcedure(Customer customer);
}
