/**
 * Clasa abstractă care reprezintă o locație generică.
 * Este sealed pentru că doar anumite clase o pot extinde.
 */
public abstract sealed class Location permits City, Airport, GasStation {

    protected String name;
    protected double x;
    protected double y;

    /**
     * Constructorul clasei Location.
     * Inițializează numele și coordonatele.
     */
    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Override pentru metoda equals din clasa Object.
     * Compară două locații după nume și coordonate.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Location other)) return false;
        return name.equals(other.name) && x == other.x && y == other.y;
    }

    /**
     * Metoda toString este folosită pentru a afișa
     * informațiile despre locație într-un format ușor de citit.
     */
    @Override
    public String toString() {
        return name + " (" + x + "," + y + ")";
    }
}