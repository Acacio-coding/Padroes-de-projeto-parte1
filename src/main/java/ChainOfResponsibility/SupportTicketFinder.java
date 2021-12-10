package ChainOfResponsibility;

public abstract class SupportTicketFinder {
    private SupportTicketFinder next;

    public SupportTicketFinder(SupportTicketFinder next) {
        this.next = next;
    }

    public SupportTicket find(int id) {
        SupportTicket ticket1 = findTicket(id);

        if (ticket1 == null)
            return getNext(id);

        return ticket1;
    }

    public SupportTicket getNext(int id) {
        if (next == null)
            throw new RuntimeException("We couldn't find the ticket which has id: " + id);

        return next.find(id);
    }

    protected abstract SupportTicket findTicket(int id);
}
