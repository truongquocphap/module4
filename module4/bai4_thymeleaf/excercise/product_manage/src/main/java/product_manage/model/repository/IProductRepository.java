package product_manage.model.repository;

import product_manage.model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
    List<Product>   finByName(String name);
}
