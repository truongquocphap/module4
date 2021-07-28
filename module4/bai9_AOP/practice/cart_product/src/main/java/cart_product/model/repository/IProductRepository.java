package cart_product.model.repository;

import cart_product.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product,Integer> {
}
