package org.example.commands;
import org.example.Catalog;
import org.example.Resource;

public class AddCommand implements Command {
    private Catalog catalog;
    private Resource resource;

    public AddCommand(Catalog catalog, Resource resource) {
        this.catalog = catalog;
        this.resource = resource;
    }

    @Override
    public void execute() {
        catalog.getResources().add(resource);
        System.out.println("S-a adăugat: " + resource.getTitle());
    }
}