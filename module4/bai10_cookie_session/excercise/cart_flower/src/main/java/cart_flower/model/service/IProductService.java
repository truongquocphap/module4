package cart_flower.model.service;

import cart_flower.model.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Integer id);

}
