package customer_manager.model.repository;

import customer_manager.model.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery("select c from customers c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery("select c from customers c where  c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (customer.getId() != null) {
            BaseRepository.entityManager.merge(customer);
        } else {
            BaseRepository.entityManager.persist(customer);
        }
        entityTransaction.commit();
    }

    @Override
    public void remove(Long id) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Customer customer = findById(id);
        if (customer != null) {
            BaseRepository.entityManager.remove(customer);
        }
        entityTransaction.commit();
    }
}
