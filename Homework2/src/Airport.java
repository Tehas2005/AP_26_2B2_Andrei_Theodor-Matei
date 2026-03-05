/**
 * Represents an airport.
 */
public final class Airport extends Location {

    private int terminals;

    public Airport(String name, double x, double y, int terminals) {
        super(name, x, y);
        this.terminals = terminals;
    }

    @Override
    public String toString() {
        return "Airport: " + name + " terminals=" + terminals;
    }
}