package org.example;

public class MovieException extends RuntimeException {
    public MovieException(Long id) {
        super("Filmul cu ID-ul " + id + " nu a fost gasit in baza de date!");
    }
}