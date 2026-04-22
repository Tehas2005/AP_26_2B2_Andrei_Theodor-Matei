import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        Programmer dev = new Programmer("Alice", LocalDate.of(1995, 5, 20), "Cycling", "Java");
        Designer designer = new Designer("Bob", LocalDate.of(1992, 10, 15), "Photography", "Figma");
        Person manager = new Person("Charlie", LocalDate.of(1988, 3, 10), "Chess");
        Company google = new Company("Google", "Tech");
        Company adobe = new Company("Adobe", "Software");

        network.addProfile(dev);
        network.addProfile(designer);
        network.addProfile(manager);
        network.addProfile(google);
        network.addProfile(adobe);

        dev.addRelationship(google, "Employee");
        dev.addRelationship(designer, "Colleague");

        designer.addRelationship(adobe, "Freelancer");
        designer.addRelationship(dev, "Friend");

        manager.addRelationship(dev, "Manager of");
        manager.addRelationship(designer, "Manager of");
        manager.addRelationship(google, "Partner");

        network.printNetworkOrdered();
    }
}