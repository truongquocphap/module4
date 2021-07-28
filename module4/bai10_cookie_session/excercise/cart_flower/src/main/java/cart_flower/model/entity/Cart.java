package cart_flower.model.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Cart {
    private Map<Optional<Product>, Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Map<Optional<Product>, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Optional<Product>, Integer> productMap) {
        this.productMap = productMap;
    }

    public Object addProduct(Optional<Product> product, String action) {
        Integer current;
        if (productMap.containsKey(product)) {
            if (action.equals("+")) {
                current = productMap.get(product);
                return productMap.put(product, current + 1);
            }
            if (action.equals("-")) {
                current = productMap.get(product);
                return productMap.put(product, current - 1);
            }
            if (action.equals("delete")) {
                return productMap.remove(product);
            }
        }
        return productMap.put(product, 1);
    }
    public float price(){
        float price=0;
        for (Map.Entry<Optional<Product>, Integer> entry : productMap.entrySet()) {
            price += entry.getKey().get().getPrice() *  entry.getValue();
        }
        return price;
    }
}
