package Strategy;

import HookMethod.Product;

public class Debt implements InterfacePayPurchase {
    private final int discount;
    private double total;

    public Debt(int discount) {
        this.discount = discount;
        this.total = 0;
    }

    @Override
    public double pay(Purchase purchase) {

        for (Product product : purchase.getProducts().getProducts()) {
            setTotal(total += product.totalPrice());
        }

        setTotal(total -= (total * discount)/100);

        return  total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
