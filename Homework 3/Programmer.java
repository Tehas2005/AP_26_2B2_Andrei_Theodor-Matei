import java.time.LocalDate;

/**
 * Reprezinta un Programator, care este un tip specific de Person.
 * Include o proprietate suplimentara pentru limbajul de programare favorit.
 */
public class Programmer extends Person {
    private String favouriteLanguage;

    public Programmer(String name, LocalDate birthDate, String hobby, String favouriteLanguage){
        super(name, birthDate, hobby);
        this.favouriteLanguage = favouriteLanguage;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    @Override
    public String toString(){
        return "Programmer [name= " + name + ", language" + favouriteLanguage + "]";
    }
}
