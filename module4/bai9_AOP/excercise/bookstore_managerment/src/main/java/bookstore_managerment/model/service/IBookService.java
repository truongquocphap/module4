package bookstore_managerment.model.service;

import bookstore_managerment.model.entity.Book;

import java.util.List;

public interface IBookService {
    Book findById(Integer id);
    List<Book> findAll();
    void save(Book book);
    void delete(Book book);

}
