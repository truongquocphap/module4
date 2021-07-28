package bookstore_managerment.model.service;
import bookstore_managerment.model.entity.Book;
import bookstore_managerment.model.entity.KindBook;

import java.util.List;

public interface IKindBookService {
    List<KindBook> findAll();
    void save(KindBook kindBook);
    void delete(KindBook kindBook);
    KindBook findById(Integer id);
}
