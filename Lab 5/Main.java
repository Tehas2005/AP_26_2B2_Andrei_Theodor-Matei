package org.example.main;

import org.example.exception.CatalogException;
import org.example.model.Article;
import org.example.model.Book;
import org.example.model.Resource;
import org.example.repository.Catalog;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("Java Resources");

        Resource book1 = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth", "Addison-Wesley");
        Resource article1 = new Article("java25", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se25/jls25.pdf", 2025, "James Gosling & others", "Oracle Docs");
        try {
            catalog.add(book1);
            catalog.add(article1);
            System.out.println("Resurse adăugate cu succes în catalog!");
            System.out.println("Încerc să deschid resursa: " + article1.getTitle());
            catalog.openResource(article1);

        } catch (CatalogException e) {
            System.err.println("Eroare de catalog: " + e.getMessage());
            if (e.getCause() != null) {
                e.getCause().printStackTrace();
            }
        }
    }
}