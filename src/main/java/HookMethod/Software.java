package HookMethod;

import NullObject.AbstractProductCategory;

public class Software extends Product {
    private final AbstractProductCategory category;

    public Software(int id, String name, double price, AbstractProductCategory category) {
        super(id, name, price);
        this.category = category;
    }

    @Override
    protected double tax() {
        return (this.getPrice() * 2.5)/100;
    }

    public String getCategory() {
        return this.category.getName();
    }
}
