package restfull.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restfull.model.entity.Customer;
import restfull.model.repository.ICustomerRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
