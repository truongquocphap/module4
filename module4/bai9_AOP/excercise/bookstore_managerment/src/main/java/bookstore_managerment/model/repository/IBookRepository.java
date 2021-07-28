package bookstore_managerment.model.repository;

import bookstore_managerment.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
