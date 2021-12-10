package Strategy;

import Composite.Freight;
import StatePattern.Cart;

public class Purchase {
    private final int id;
    private Cart products;
    private final Freight freight;

    public Purchase(int id, Cart products, Freight freight) {
        this.id = id;
        this.products = products;
        this.freight = freight;
    }

    public int getId() {
        return id;
    }

    public Cart getProducts() {
        return products;
    }

    public void setProducts(Cart products) {
        this.products = products;
    }

    public Freight getFreight() {
        return freight;
    }
}
