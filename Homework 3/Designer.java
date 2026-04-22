import java.time.LocalDate;

/**
 * Reprezinta un Designer, care este un tip specific de Person.
 * Include o proprietate suplimentara pentru software-ul de design preferat.
 */
public class Designer extends Person {
    private String designSoftware;

    public Designer(String name, LocalDate birthDate, String hobby, String designSoftware){
        super(name, birthDate, hobby);
        this.designSoftware = designSoftware;
    }

    public String getDesignSoftware(){
        return designSoftware;
    }

    @Override
    public String toString(){
        return "Designer [name= " + name + ", software= " + designSoftware + "]";
    }
}
