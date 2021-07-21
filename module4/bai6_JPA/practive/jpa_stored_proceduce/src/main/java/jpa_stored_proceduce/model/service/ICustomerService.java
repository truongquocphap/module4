package jpa_stored_proceduce.model.service;

import jpa_stored_proceduce.model.bean.Customer;

public interface ICustomerService {
    void insertWithStoredProcedure(Customer customer);

}
