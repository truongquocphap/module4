package jpa_stored_proceduce.model.service;

import jpa_stored_proceduce.model.bean.Customer;
import jpa_stored_proceduce.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public void insertWithStoredProcedure(Customer customer) {
         iCustomerRepository.insertWithStoredProcedure(customer);
    }
}
