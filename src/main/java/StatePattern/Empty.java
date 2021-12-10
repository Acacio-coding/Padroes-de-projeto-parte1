package StatePattern;

import HookMethod.Product;

public class Empty extends CartState {

    public Empty(Cart shoppingCart) {
        super(shoppingCart);
    }

    public void listProducts() {
        System.out.println("There isn't any product in your shopping cart yet...");
    }

    @Override
    public void fill(Product product) {
        getShoppingCart().setProducts(product);
        getShoppingCart().setState(new Filled(getShoppingCart()));
        System.out.println("Product added to you shopping cart...");
    }

    @Override
    public void clear() {
        System.out.println("There's no product in the shopping cart to be removed yet...");
    }
}
