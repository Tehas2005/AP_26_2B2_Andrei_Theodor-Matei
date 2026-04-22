package org.example.model;

public class Article extends Resource {
    private String journal;

    public Article(String id, String title, String location, int year, String author, String journal) {
        super(id, title, location, year, author);
        this.journal = journal;
    }

    public String getJournal() {
        return journal;
    }
}