package furama_resort.model.repository;

import furama_resort.model.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
