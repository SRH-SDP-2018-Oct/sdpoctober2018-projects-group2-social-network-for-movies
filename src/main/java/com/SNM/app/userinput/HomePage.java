package com.SNM.app.userinput;

import com.SNM.app.crud.*;

import java.util.Scanner;

public class HomePage

{
    Scanner userchoice= new Scanner(System.in);
    private String genreofchoice;
    private String languageofchoice;
    private String moviedetailsneeded;
    private String moviedetailsbasedonname;
    private String groupdetailsneeded;

  HomePage()
  {

          System.out.println("Enter your choice");
          System.out.println("1: Genre\n2: Language\n3: Trending Now\n4: Groups\n5: Movie Search\n6: Watchlist");
          int userChoice = userchoice.nextInt();
          switch (userChoice) {
              case (1):
                  System.out.println("Genres available:\nAction\nRomance");
                  System.out.println("Choose a particular genre:");
                  genreofchoice = userchoice.next();
                  FetchMoviesGenre fetchMoviesGenre = new FetchMoviesGenre(genreofchoice);
                  break;
              case (2):
                  System.out.println("Languages available");
                  System.out.println("Kannada ka \n English en\n Please enter your choice:");
                  languageofchoice = userchoice.next();
                  FetchMoviesLanguage fetchMoviesLanguage = new FetchMoviesLanguage(languageofchoice);
                  break;
              case (3):
                  System.out.println("List of all trending movies");
                  FetchTrendingMovies fetchTrendingMovies = new FetchTrendingMovies();
                  fetchTrendingMovies.fetchTrendingMovies();
                  break;
              case (4):
                  System.out.println("List of all groups");
                  //Fetch
                  System.out.println("If you want to view a particular group,please select from the list");
                  groupdetailsneeded = userchoice.nextLine();
                  break;
              case (5):
                  System.out.println("Please enter name of the Movie:");
                  moviedetailsbasedonname = userchoice.next();
                  FetchMovieSearch fetchMovieSearch = new FetchMovieSearch(moviedetailsbasedonname);
                  break;
              case (6):
                  System.out.println("View Watchlist");

                  FetchWatchList viewwatchlist = FetchWatchList.getFetchWatchListInstance();
                  viewwatchlist.fetchWatchList();
                  break;
              default:
                  System.out.println("EXIT");
          }
  }
}


