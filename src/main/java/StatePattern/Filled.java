package StatePattern;

import HookMethod.Product;

public class Filled extends CartState {

    public Filled(Cart shoppingCart) {
        super(shoppingCart);
    }

    public void listProducts() {
        for (int i = 0; i < getShoppingCart().getProducts().size(); i++) {
            System.out.println(i + " - Product: " + getShoppingCart().getProducts().get(i).getName() + " - Price: " + getShoppingCart().getProducts().get(i).totalPrice());
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Total: " + this.getTotal());
    }

    public double getTotal() {
        double total = 0;
        for (Product product : getShoppingCart().getProducts()) {
            total += product.totalPrice();
        }
        return  total;
    }

    @Override
    public void fill(Product product) {
        getShoppingCart().setProducts(product);
        System.out.println("Product added to you shopping cart...");
    }

    @Override
    public void clear() {
        getShoppingCart().getProducts().clear();
        System.out.println("All products were removed...");
        getShoppingCart().setState(new Empty(getShoppingCart()));
    }
}
