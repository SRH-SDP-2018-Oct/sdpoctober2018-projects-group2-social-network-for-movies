package com.SNM.app.fetchdetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class FetchDetails {

    String genre_name;
    String language_name;
    String movie_name;
    public Connection connection;
    public Statement statement;
    public ResultSet resultset;

    public FetchDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/socialnetworkformovies", "binitan", "themother");
            statement = connection.createStatement();
        } catch (Exception db_ex) {
            System.out.println("Connection Failed :" + db_ex);
        }

    }
        public void fetchGenreList()
        {
            try {
                String query = "SELECT genre FROM socialnetworkformovies.moviecategory";
                resultset = statement.executeQuery(query);
                while (resultset.next()) {
                    String genre = resultset.getString("genre");
                    System.out.println("genre" + genre);
                }
            } catch (Exception ex) {
                System.out.println("Failed to fetch Genre List :" + ex);
            }
        }

    public void fetchLanguageList()
    {
        try
        {
            String query = "SELECT language FROM socialnetworkformovies.moviecategory";
            resultset = statement.executeQuery(query);
            while (resultset.next())
            {
                String language = resultset.getString("language");
                System.out.println("genre" +language);
            }
        }
        catch (Exception ex) {
            System.out.println("Failed to fetch Language List :" + ex);
        }
    }

        public void fetchMoviesBasedOnGenre(String genre_name)
        {
            try {
                String query = ("SELECT movie_name FROM socialnetworkformovies.moviecategory where genre="+genre_name);
                resultset = statement.executeQuery(query);
                while (resultset.next())
                {
                    String movie_name = resultset.getString("movie_name");
                    System.out.println("genre" + movie_name);
                }
                } catch (Exception ex)
            {
                System.out.println("Failed to fetch Movies List based on genre :" + ex);
            }
        }
    public void fetchMoviesBasedOnLanguage(String language_name)
    {
        try {
            String query = ("SELECT movie_name FROM socialnetworkformovies.moviecategory where language="+language_name);
            resultset = statement.executeQuery(query);
            while (resultset.next())
            {
                String movie_name = resultset.getString("movie_name");
                System.out.println("genre" + movie_name);
            }
        } catch (Exception ex)
        {
            System.out.println("Failed to fetch Movies List based on language :" + ex);
        }
    }
    public void fetchTrendingMovies()
    {
        try {
            String query = ("SELECT movie_name FROM socialnetworkformovies.moviedetails where user_rating");
            //to be written
            resultset = statement.executeQuery(query);
            while (resultset.next())
            {
                String trending_movie = resultset.getString("movie_name");
                System.out.println(trending_movie);
            }
        } catch (Exception ex)
        {
            System.out.println("Failed to fetch Trending Movies List based on user ratings :" + ex);
        }
    }




}