package furama_resort.model.repository;

import furama_resort.model.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
