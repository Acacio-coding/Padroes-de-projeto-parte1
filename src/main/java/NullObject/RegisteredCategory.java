package NullObject;

public class RegisteredCategory extends  AbstractProductCategory {
    public RegisteredCategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
