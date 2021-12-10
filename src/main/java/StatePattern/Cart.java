package StatePattern;

import HookMethod.Product;
import java.util.ArrayList;

public class Cart {
   private ArrayList<Product> products;
   private CartState state;

    public Cart() {
        this.products = new ArrayList<>();
        this.state = new Empty(this);
    }

    public void fill(Product product) {
        state.fill(product);
    }

    public void listProducts() {
        state.listProducts();
    }

    public void clear() {
        state.clear();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }

    public void setState(CartState state) {
        this.state = state;
    }


}
