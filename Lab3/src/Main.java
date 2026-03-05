import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Profile> list = new ArrayList<>();

        list.add(new Person("Popescu Ion"));
        list.add(new Company("Tech Solutions SRL"));
        list.add(new Person("Ionescu Maria"));
        list.add(new Company("Alpha Design"));

        Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        System.out.println("Lista Sortata alfabetic dupa nume: ");
        for(Profile p : list){
            System.out.println(p);
        }
    }
}