package ChainOfResponsibility;

import Observer.Customer;

import java.util.HashMap;
import java.util.Map;

public class DB1 extends  SupportTicketFinder {
    private final Map<Integer, SupportTicket> database = new HashMap<>();

    public DB1(SupportTicketFinder next, Customer customer) {
        super(next);
        database.put(0, new SupportTicket(0, "Ticket1", customer));
    }

    @Override
    protected SupportTicket findTicket(int id) {
        if (database.containsKey(id))
            return database.get(id);

        return null;
    }
}
