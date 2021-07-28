package customer_manage.model.service;

import customer_manage.model.bean.Customer;
import customer_manage.model.repository.ICustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ICustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepositoryImpl iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        iCustomerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.remove(id);
    }
}
