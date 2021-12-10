package Composite;

public class CompositeRoute implements FreightRoute {
    private FreightRoute initial;
    private FreightRoute _final;

    public CompositeRoute(FreightRoute initial, FreightRoute _final) {
        this.initial = initial;
        this._final = _final;

        if (!initial.getFinal().equalsIgnoreCase(_final.getInitial()))
            throw new RuntimeException("O destino da rota inicial é diferente da origem da rota final!");
    }

    @Override
    public String getInitial() {
        return initial.getInitial();
    }

    @Override
    public String getFinal() {
        return _final.getFinal();
    }

    @Override
    public String toString() {
        return initial.toString() + "\n" + _final.toString();
    }
}
