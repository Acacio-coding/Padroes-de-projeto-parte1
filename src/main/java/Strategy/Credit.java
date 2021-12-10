package Strategy;

import HookMethod.Product;

public class Credit implements InterfacePayPurchase{
    private  final double tax;
    private double total;

    public Credit(double tax) {
        this.tax = tax;
        this.total = 0;
    }

    @Override
    public double pay(Purchase purchase) {
        for (Product product : purchase.getProducts().getProducts()) {
            setTotal(total += product.totalPrice());
        }

        setTotal(total * tax);

        for (int i = 1; i <= 12; i++) {
            System.out.println(i   + "x de R$" + total/i);
        }
        System.out.println("------------------------------");

        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
