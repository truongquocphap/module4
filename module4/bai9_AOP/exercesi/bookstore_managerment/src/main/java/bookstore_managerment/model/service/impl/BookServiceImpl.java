package bookstore_managerment.model.service.impl;

import bookstore_managerment.model.entity.Book;
import bookstore_managerment.model.repository.IBookRepository;
import bookstore_managerment.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
     iBookRepository.delete(book);
    }
}
