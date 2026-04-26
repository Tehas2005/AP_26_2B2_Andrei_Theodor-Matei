package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double score;

    public Movie() {}

    public Movie(String title, Double score) {
        this.title = title;
        this.score = score;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    @Override
    public String toString() {
        return "Movie{id=" + id + ", title='" + title + "', score=" + score + "}";
    }
}