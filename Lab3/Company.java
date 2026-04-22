public class Company implements Profile, Comparable<Company> {
    private String name;

    public Company(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    public int compareTo(Company other){
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString(){
        return "Company: " + name;
    }
}
