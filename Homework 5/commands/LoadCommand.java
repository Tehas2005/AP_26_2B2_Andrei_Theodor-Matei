package org.example.commands;
import org.example.Catalog;
import org.example.CatalogException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadCommand implements Command {
    private String path;
    private Catalog loadedCatalog;

    public LoadCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() throws CatalogException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            loadedCatalog = (Catalog) ois.readObject();
            System.out.println("Catalog incarcat: " + loadedCatalog.getName());
        } catch (Exception e) {
            throw new CatalogException("Eroare la incarcarea catalogului.", e);
        }
    }
    public Catalog getLoadedCatalog() { return loadedCatalog; }
}