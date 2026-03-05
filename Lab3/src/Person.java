import java.util.Objects;
public class Person implements Profile, Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Person other){
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString(){
        return "Person: " + name;
    }
}

