package ChainOfResponsibility;

import Observer.Customer;

import java.util.HashMap;
import java.util.Map;

public class DB2 extends SupportTicketFinder {
    private final Map<Integer, SupportTicket> database = new HashMap<>();

    public DB2(SupportTicketFinder next, Customer customer) {
        super(next);
        database.put(1, new SupportTicket(1, "Ticket2", customer));
    }

    @Override
    protected SupportTicket findTicket(int id) {
        if (database.containsKey(id))
            return database.get(id);

        return null;
    }
}
