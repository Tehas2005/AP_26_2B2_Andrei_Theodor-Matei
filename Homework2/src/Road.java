/**
 * Represents a road between two locations.
 */
public class Road {

    private final Location from;
    private final Location to;
    private final RoadType type;
    private final double length;
    private final int speedLimit;

    public Road(Location from, Location to, RoadType type, double length, int speedLimit) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    /**
     * Override pentru metoda equals.
     * Verifică dacă două drumuri sunt identice.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Road other)) return false;
        return from.equals(other.from) &&
                to.equals(other.to) &&
                type == other.type;
    }

    @Override
    public String toString() {
        return "Road " + from.getName() + " -> " + to.getName() + " (" + type + ")";
    }
}