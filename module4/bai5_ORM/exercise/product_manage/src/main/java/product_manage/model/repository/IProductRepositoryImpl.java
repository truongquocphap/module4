package product_manage.model.repository;

import org.springframework.stereotype.Repository;
import product_manage.model.bean.Product;

import java.util.*;

@Repository
public class IProductRepositoryImpl implements IProductRepository {
    private static Map<Integer,Product> productMap = new HashMap<>();
    static {
        productMap.put(1,new Product(1,"IphoneX",11000000,"Camera cuộn","Made in Việt Nam"));
        productMap.put(2,new Product(2,"IphoneXX",12000000,"Camera 50px","Made in Việt Nam"));
        productMap.put(3,new Product(3,"IphoneXXX",13000000,"Camera 3 mắt","Made in Việt Nam"));
        productMap.put(4,new Product(4,"IphoneX?",14000000,"Camera 4 mắt","Made in Việt Nam"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
    productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> finByName(String name) {
        Set<Integer> set=productMap.keySet();
        List<Product> productList=new ArrayList<>();
        for (Integer key: set) {
            if (productMap.get(key).getName().contains(name)){
                productList.add(productMap.get(key));
            }
        }
        return productList;
    }
}
