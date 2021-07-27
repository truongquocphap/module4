package bookstore_managerment.model.repository;

import bookstore_managerment.model.entity.KindBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKindBookRepository extends JpaRepository<KindBook,Integer> {
}
