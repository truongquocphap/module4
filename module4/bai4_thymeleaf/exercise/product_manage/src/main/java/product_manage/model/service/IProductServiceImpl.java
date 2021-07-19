package product_manage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_manage.model.bean.Product;
import product_manage.model.repository.IProductRepository;

import java.util.List;
@Service
public class IProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
    iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
    iProductRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
    iProductRepository.remove(id);
    }

    @Override
    public List<Product> finByName(String name) {
        return iProductRepository.finByName(name);
    }
}
