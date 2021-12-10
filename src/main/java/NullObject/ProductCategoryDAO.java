package NullObject;

public class ProductCategoryDAO {
    public static final String[] categories = {"Software", "Hardware", "Furniture", "Home Appliance"};

    public static AbstractProductCategory getCategory(String name) {
        for (String category : categories) {
            if (category.equalsIgnoreCase(name)) return new RegisteredCategory(name);
        }
        return new NullCategory();
    }
}
