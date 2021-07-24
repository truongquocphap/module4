package C0321G1.province_manager.model.repository;

import C0321G1.province_manager.model.bean.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long > {
}
