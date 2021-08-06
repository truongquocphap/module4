package furama_resort.model.repository;

import furama_resort.model.entity.DivisionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<DivisionEmployee,Integer> {
}
