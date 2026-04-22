package org.example.repository;

import org.example.exception.CatalogException;
import org.example.model.Resource;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    private List<Resource> resources;

    public Catalog(String name) {
        this.name = name;
        this.resources = new ArrayList<>();
    }

    /**
     * Adaugă o resursă în repository. Aruncă o excepție dacă resursa e invalidă.
     */
    public void add(Resource resource) throws CatalogException {
        if (resource == null || resource.getId() == null) {
            throw new CatalogException("Resursa sau ID-ul resursei nu poate fi null!");
        }
        boolean idExists = resources.stream().anyMatch(r -> r.getId().equals(resource.getId()));
        if (idExists) {
            throw new CatalogException("O resursă cu ID-ul " + resource.getId() + " există deja în catalog!");
        }
        resources.add(resource);
    }

    public List<Resource> getResources() {
        return resources;
    }

    /**
     * Deschide resursa folosind aplicația nativă a sistemului (clasa Desktop).
     */
    public void openResource(Resource resource) throws CatalogException {
        if (!Desktop.isDesktopSupported()) {
            throw new CatalogException("Clasa Desktop nu este suportată pe acest sistem de operare!");
        }

        try {
            Desktop desktop = Desktop.getDesktop();
            String location = resource.getLocation();

            if (location.toLowerCase().startsWith("http://") || location.toLowerCase().startsWith("https://")) {
                desktop.browse(new URI(location));
            } else {
                File file = new File(location);
                if (!file.exists()) {
                    throw new CatalogException("Fișierul local nu a putut fi găsit: " + location);
                }
                desktop.open(file);
            }
        } catch (Exception e) {
            throw new CatalogException("Eroare la deschiderea resursei: " + resource.getTitle(), e);
        }
    }
}