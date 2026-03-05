/**
 * Represents a gas station.
 */
public final class GasStation extends Location {

    private double gasPrice;

    public GasStation(String name, double x, double y, double gasPrice) {
        super(name, x, y);
        this.gasPrice = gasPrice;
    }

    @Override
    public String toString() {
        return "GasStation: " + name + " price=" + gasPrice;
    }
}