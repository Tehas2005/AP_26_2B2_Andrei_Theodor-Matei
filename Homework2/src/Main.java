public class Main {

    public static void main(String[] args) {

        City c1 = new City("Iasi",0,0,300000);
        City c2 = new City("Cluj",5,5,320000);
        Airport a1 = new Airport("Otopeni",10,10,3);
        GasStation g1 = new GasStation("Petrom",2,2,7.5);

        Road r1 = new Road(c1,c2,RoadType.HIGHWAY,7,130);
        Road r2 = new Road(c2,a1,RoadType.EXPRESS,8,100);
        Road r3 = new Road(c1, g1, RoadType.COUNTRY, 3, 70);

        Problem p = new Problem();

        p.addLocation(c1);
        p.addLocation(c2);
        p.addLocation(a1);
        p.addLocation(g1);

        p.addRoad(r1);
        p.addRoad(r2);
        p.addRoad(r3);

        System.out.println("Problem valid: " + p.isValid());
        System.out.println("Can reach airport: " + p.canReach(c1,a1));
        System.out.println("Can reach gas station: " + p.canReach(c1,g1));

    }
}