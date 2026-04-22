package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            initDatabase();

            GenreDAO genres = new GenreDAO();

            try {
                genres.create("Action");
                genres.create("Comedy");
                genres.create("Drama");
                System.out.println("Genurile au fost inserate cu succes!");
            } catch (SQLException e) {
                System.out.println("Genurile exista deja în baza de date.");
            }

            Integer actionId = genres.findByName("Action");
            System.out.println("Genul 'Action' a primit ID-ul: " + actionId);

            if (actionId != null) {
                String genreName = genres.findById(actionId);
                System.out.println("Genul cu ID-ul " + actionId + " este: " + genreName);
            }

            DatabaseConnection.closeConnection();

        } catch (SQLException e) {
            System.err.println("Eroare de baza de date: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void initDatabase() throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        try (Statement stmt = con.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS genres (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL UNIQUE)");

            stmt.execute("CREATE TABLE IF NOT EXISTS movies (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "release_date DATE, " +
                    "duration INT, " +
                    "score DECIMAL(3,1), " +
                    "genre_id INT REFERENCES genres(id))");

            stmt.execute("CREATE TABLE IF NOT EXISTS actors (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL)");

            stmt.execute("CREATE TABLE IF NOT EXISTS movie_actors (" +
                    "movie_id INT REFERENCES movies(id), " +
                    "actor_id INT REFERENCES actors(id), " +
                    "PRIMARY KEY (movie_id, actor_id))");

            System.out.println("Tabelele au fost verificate/create cu succes!");
        }
    }
}