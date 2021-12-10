package Observer;

import Strategy.Purchase;

public class FreightUpdateService implements Observable {
    private final Purchase purchase;
    private final Observer observer;

    public FreightUpdateService(Purchase purchase, Observer observer) {
        this.purchase = purchase;
        this.observer = observer;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public Observer getObserver() {
        return observer;
    }

    @Override
    public void update(String status) {
        observer.freightUpdate(this, status);
    }

    @Override
    public String toString() {
        return String.valueOf(purchase.getId());
    }
}
