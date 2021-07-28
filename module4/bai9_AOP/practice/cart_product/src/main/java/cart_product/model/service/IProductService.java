package cart_product.model.service;

import cart_product.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Integer id);
}
