package org.example.commands;
import org.example.Catalog;
import org.example.CatalogException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveCommand implements Command {
    private Catalog catalog;
    private String path;

    public SaveCommand(Catalog catalog, String path) {
        this.catalog = catalog; this.path = path;
    }

    @Override
    public void execute() throws CatalogException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(catalog);
            System.out.println("Catalog salvat la: " + path);
        } catch (Exception e) {
            throw new CatalogException("Nu s-a putut salva catalogul.", e);
        }
    }
}