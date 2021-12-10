package Composite;

public class UniqueRoute implements FreightRoute {
    private final String sender;
    private final String addressee;

    public UniqueRoute(String initial, String _final) {
        this.sender = initial;
        this.addressee = _final;
    }

    @Override
    public String getInitial() {
        return sender;
    }

    @Override
    public String getFinal() {
        return addressee;
    }

    @Override
    public String toString() {
        return "Cidade inicial: " + sender + ", Cidade final: " + addressee;
    }
}
