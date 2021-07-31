package smart_phone.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smart_phone.model.entity.Smartphone;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
