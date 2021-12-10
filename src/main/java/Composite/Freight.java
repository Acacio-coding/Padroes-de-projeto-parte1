package Composite;

public class Freight {
    private final double price;
    private final FreightRoute route;

    public Freight(double price, FreightRoute route) {
        this.price = price;
        this.route = route;
    }

    public double getPrice() {
        return price;
    }

    public FreightRoute getRoute() {
        return route;
    }
}
