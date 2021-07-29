package restfull.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restfull.model.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
