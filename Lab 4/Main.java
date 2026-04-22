import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Intersection> intersections = IntStream.range(0, 10)
                .mapToObj(i -> new Intersection("I" + i))
                .collect(Collectors.toList());

        System.out.println("Intersectiile generate: " + intersections);

        List<Street> streets = new LinkedList<>();
        streets.add(new Street("S1", 12.5, intersections.get(0), intersections.get(1)));
        streets.add(new Street("S2", 5.0, intersections.get(1), intersections.get(2)));
        streets.add(new Street("S3", 8.2, intersections.get(2), intersections.get(3)));
        streets.add(new Street("S4", 15.1, intersections.get(3), intersections.get(0)));

        streets.sort(Comparator.comparingDouble(Street::getLength));

        System.out.println("\nStrazi sortate dupa lungime:");
        for (Street s : streets) {
            System.out.println(s);
        }

        Set<Intersection> intersectionSet = new HashSet<>();

        intersectionSet.addAll(intersections);
        System.out.println("\nNumar de intersectii in Set: " + intersectionSet.size());

        Intersection duplicateIntersection = new Intersection("I0");
        boolean isAdded = intersectionSet.add(duplicateIntersection);

        System.out.println("A fost adaugat duplicatul 'I0'? " + isAdded);
        System.out.println("Numar de intersectii in Set dupa incercarea adaugarii duplicatului: " + intersectionSet.size());
    }
}