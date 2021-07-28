package C0321G1.province_manager.model.service;

import C0321G1.province_manager.model.bean.Customer;
import C0321G1.province_manager.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList= (List<Customer>) iCustomerRepository.findAll();
        return customerList;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return  iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }
}
