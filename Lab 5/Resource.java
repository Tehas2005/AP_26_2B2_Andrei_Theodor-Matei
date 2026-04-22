package org.example.model;
/**
 * Clasa de bază abstractă care modelează o resursă bibliografică.
 */
public abstract class Resource {
    protected String id;
    protected String title;
    protected String location;
    protected int year;
    protected String author;

    public Resource(String id, String title, String location, int year, String author) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Resource{" + "id='" + id + '\'' + ", title='" + title + '\'' + '}';
    }
}