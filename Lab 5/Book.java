package org.example.model;

public class Book extends Resource {
    private String publisher;

    public Book(String id, String title, String location, int year, String author, String publisher) {
        super(id, title, location, year, author);
        this.publisher = publisher;
    }

    public String getPublisher() { return publisher; }
}