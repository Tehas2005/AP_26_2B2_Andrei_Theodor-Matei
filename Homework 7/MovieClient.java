package org.example;

import org.springframework.web.client.RestTemplate;

public class MovieClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        // Am schimbat portul aici in 8081 !!!
        String url = "http://localhost:8081/movies";

        try {
            System.out.println("1. Cream un film (POST)...");
            Movie newMovie = new Movie("Inception", 9.5);
            Movie created = restTemplate.postForObject(url, newMovie, Movie.class);
            System.out.println("Salvat: " + created);

            System.out.println("\n2. Citim toate filmele (GET)...");
            String movies = restTemplate.getForObject(url, String.class);
            System.out.println("Filme din baza de date: " + movies);

            if (created != null) {
                System.out.println("\n3. Stergem filmul creat (DELETE)...");
                restTemplate.delete(url + "/" + created.getId());
                System.out.println("S-a sters cu succes!");
            }
        } catch (Exception e) {
            System.out.println("Eroare la client: Ai pornit aplicatia Main inainte sa rulezi acest client?");
        }
    }
}