package org.example.commands;
import org.example.Catalog;

public class ListCommand implements Command {
    private Catalog catalog;
    public ListCommand(Catalog catalog) { this.catalog = catalog; }

    @Override
    public void execute() {
        System.out.println("--- Catalog: " + catalog.getName() + " ---");
        catalog.getResources().forEach(System.out::println);
    }
}