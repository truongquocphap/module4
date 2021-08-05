package furama_resort.model.repository;

import furama_resort.model.entity.Customer;
import furama_resort.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IServiceRepository extends JpaRepository<Service,Integer> {
    @Query(value = "select * from service where concat(service_name,service_code) like %?1% ",nativeQuery = true)
    Page<Service> serviceList(String name, Pageable pageable);
}
