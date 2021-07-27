package com.example.customer_managerment.model.service;


import com.example.customer_managerment.exception.DuplicateFirstNameLastNameException;
import com.example.customer_managerment.model.entity.Customer;
import com.example.customer_managerment.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {

        return iCustomerRepository.findAllByFirstNameContaining(firstname,pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) throws Exception{
        if (true) throw new Exception();
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() throws Exception {
        if (true) throw new Exception();
        List<Customer> customerList= (List<Customer>) iCustomerRepository.findAll();
        return customerList;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return  iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) throws DuplicateFirstNameLastNameException {
        try{
            iCustomerRepository.save(customer);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateFirstNameLastNameException();
        }

    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findOne(Long id) throws Exception{
        Optional<Customer> customerOptional = iCustomerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new Exception("customer not found!");
        }
        return customerOptional;
    }

}
