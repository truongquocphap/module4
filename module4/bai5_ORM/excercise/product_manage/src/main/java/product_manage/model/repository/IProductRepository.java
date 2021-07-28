package product_manage.model.repository;

import product_manage.model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(Product product);
    Product finByName(String name);
}
