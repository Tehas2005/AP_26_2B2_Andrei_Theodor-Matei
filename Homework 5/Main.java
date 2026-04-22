package org.example;
import org.example.commands.*;

public class Main {
    public static void main(String[] args) {
        try {
            Catalog catalog = new Catalog("Biblioteca IT");

            Resource r1 = new Resource("java25", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se25/jls25.pdf", 2025, "James Gosling");
            Resource r2 = new Resource("wiki", "Wikipedia", "https://wikipedia.org", 2001, "Jimmy Wales");

            new AddCommand(catalog, r1).execute();
            new AddCommand(catalog, r2).execute();

            new ListCommand(catalog).execute();

            new SaveCommand(catalog, "catalog.dat").execute();

            LoadCommand loadCmd = new LoadCommand("catalog.dat");
            loadCmd.execute();
            Catalog loadedCatalog = loadCmd.getLoadedCatalog();

            new ReportCommand(loadedCatalog).execute();

        } catch (CatalogException e) {
            System.err.println("A aparut o eroare: " + e.getMessage());
            e.printStackTrace();
        }
    }
}