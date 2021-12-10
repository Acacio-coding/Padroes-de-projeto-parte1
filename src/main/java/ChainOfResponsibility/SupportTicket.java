package ChainOfResponsibility;

import Observer.Customer;

public class SupportTicket {
    private final int id;
    private final String description;
    private final Customer costumer;

    public SupportTicket(int id, String description, Customer costumer) {
        this.id = id;
        this.description = description;
        this.costumer = costumer;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Customer getCostumer() {
        return costumer;
    }
}
