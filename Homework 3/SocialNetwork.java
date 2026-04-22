import java.util.ArrayList;
import java.util.List;

/**
 * Clasa SocialNetwork gestioneaza o colectie de profiluri si calculeaza
 * importanta lor relativa pe baza conexiunilor din retea.
 */
public class SocialNetwork {
    private List<Profile> profiles;

    public SocialNetwork() {
        this.profiles = new ArrayList<>();
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    /**
     * Calculeaza importanta unui profil in retea.
     * Importanta este definita ca numarul total de relatii ale profilului
     * Atat cele initiate de el, cat si cele primite de la alte persoane.
     */
    public int getImportance(Profile target) {
        int importance = 0;

        if (target instanceof Person) {
            importance += ((Person) target).getRelationships().size();
        }

        for (Profile p : profiles) {
            if (p instanceof Person && p != target) {
                Person person = (Person) p;
                if (person.getRelationships().containsKey(target)) {
                    importance++;
                }
            }
        }

        return importance;
    }

    /**
     * Printeaza toate profilurile din retea la iesirea standard,
     * ordonate descrescator in functie de importanta lor.
     */
    public void printNetworkOrdered() {
        profiles.sort((p1, p2) -> Integer.compare(getImportance(p2), getImportance(p1)));

        System.out.println("Social Network Ordered by Importance");
        for (Profile p : profiles) {
            int importance = getImportance(p);
            System.out.println(p.toString() + " -> Importance: " + importance);
        }
    }
}