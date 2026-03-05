/**
 * Clasa City reprezintă un oraș.
 * Extinde clasa Location.
 */
public final class City extends Location {

    private int population;

    /**
     * Constructor pentru City.
     */
    public City(String name, double x, double y, int population) {
        super(name, x, y);
        this.population = population;
    }

    @Override
    public String toString() {
        return "City: " + name + " population=" + population;
    }
}