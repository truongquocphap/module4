package bookstore_managerment.model.service.impl;

import bookstore_managerment.model.entity.Book;
import bookstore_managerment.model.entity.KindBook;
import bookstore_managerment.model.repository.IKindBookRepository;
import bookstore_managerment.model.service.IKindBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KindBookServiceImpl implements IKindBookService {
    @Autowired
    IKindBookRepository iKindBookRepository;
    @Override
    public List<KindBook> findAll() {
        return iKindBookRepository.findAll();
    }

    @Override
    public void save(KindBook kindBook) {
        iKindBookRepository.save(kindBook);
    }

    @Override
    public void delete(KindBook kindBook) {
    iKindBookRepository.delete(kindBook);
    }

    @Override
    public KindBook findById(Integer id) {
        return iKindBookRepository.findById(id).orElse(null);
    }
}
