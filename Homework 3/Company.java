/**
 * Reprezinta o Companie in reteaua sociala.
 * Implementeaza interfata Profile si adauga o proprietate specifica pentru industrie.
 */
public class Company implements Profile {
    private String name;
    private String industry;

    public Company(String name, String industry) {
        this.name = name;
        this.industry = industry;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }

    @Override
    public String toString() {
        return "Company [name=" + name + ", industry=" + industry + "]";
    }
}