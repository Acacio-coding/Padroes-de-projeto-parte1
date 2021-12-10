package Strategy;

public class PayPurchase {
    private final Purchase purchase;
    private final InterfacePayPurchase payPurchase;

    public PayPurchase(Purchase purchase, InterfacePayPurchase payPurchase) {
        this.purchase = purchase;
        this.payPurchase = payPurchase;
    }

    public double realizePayment() {
        return (payPurchase.pay(this.purchase) + purchase.getFreight().getPrice());
    }
}
