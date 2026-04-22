import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Reprezinta o persoana in reteaua sociala.
 * Contine informatii de baza precum data nasterii, o proprietate specifica (hobby)
 * si un map care defineste relatiile cu alte profiluri.
 */
public class Person implements Profile {
    protected String name;
    protected LocalDate birthDate;
    protected String hobby;
    protected Map<Profile, String> relationships;

    /**
     * Un map care stocheaza relatiile. Cheia este profilul tinta Profile,
     * iar valoarea este un String care descrie tipul relatiei
     */
    public Person(String name, LocalDate birthDate, String hobby) {
        this.name = name;
        this.birthDate = birthDate;
        this.hobby = hobby;
        this.relationships = new HashMap<>();
    }

    public void addRelationship(Profile profile, String relationshipType) {
        this.relationships.put(profile, relationshipType);
    }

    public Map<Profile, String> getRelationships() {
        return relationships;
    }

    @Override
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", hobby=" + hobby + "]";
    }
}