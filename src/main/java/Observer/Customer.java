package Observer;

public class Customer implements Observer{
    private final int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void freightUpdate(Observable observable, String status) {
        System.out.println(this.getName() + ", there was a status update on purchase #" + observable + ": " + status);
    }
}
