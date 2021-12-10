package StatePattern;

import HookMethod.Product;

public abstract class CartState {
    private Cart shoppingCart;

    public CartState(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public abstract void fill(Product product);

    public abstract void clear();

    public abstract void listProducts();

    public Cart getShoppingCart() {
        return shoppingCart;
    }
}
