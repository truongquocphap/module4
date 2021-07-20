package product_manage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_manage.model.bean.Product;
import product_manage.model.repository.IProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{
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
    public void update(Product product) {
iProductRepository.update(product);
    }

    @Override
    public void remove(Product product) {
iProductRepository.remove(product);
    }

    @Override
    public Product finByName(String name) {
        return iProductRepository.finByName(name);
    }
}
