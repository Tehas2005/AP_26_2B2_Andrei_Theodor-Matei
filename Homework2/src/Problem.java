import java.util.*;
/**
 * Clasa Problem reprezintă o instanță a problemei.
 * Conține locațiile și drumurile.
 */
public class Problem {

    private final List<Location> locations = new ArrayList<>();
    private final List<Road> roads = new ArrayList<>();

    public void addLocation(Location location) {
        if (!locations.contains(location)) {
            locations.add(location);
        }
    }

    public void addRoad(Road road) {
        if (!roads.contains(road)) {
            roads.add(road);
        }
    }

    /**
     * Verifică dacă instanța problemei este validă.
     * Un drum trebuie să conecteze două locații existente.
     */
    public boolean isValid() {
        for (Road r : roads) {
            if (!locations.contains(r.getFrom()) ||
                    !locations.contains(r.getTo()))
                return false;
        }
        return true;
    }

    /**
     * Metoda verifică dacă se poate ajunge
     * de la o locație la alta folosind drumurile.
     * Algoritmul folosit este BFS (Breadth First Search).
     */
    public boolean canReach(Location start, Location target) {

        Set<Location> visited = new HashSet<>();
        Queue<Location> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            if (current.equals(target))
                return true;

            visited.add(current);

            for (Road r : roads) {
                if (r.getFrom().equals(current) && !visited.contains(r.getTo())) {
                    queue.add(r.getTo());
                }
            }
        }
        return false;
    }
}