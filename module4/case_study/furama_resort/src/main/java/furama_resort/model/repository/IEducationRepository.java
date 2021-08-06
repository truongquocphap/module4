package furama_resort.model.repository;

import furama_resort.model.entity.EducationEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<EducationEmployee,Integer> {
}
