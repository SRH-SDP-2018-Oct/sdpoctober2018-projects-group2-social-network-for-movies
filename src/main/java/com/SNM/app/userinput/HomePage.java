package com.SNM.app.userinput;

import com.SNM.app.globalsearch.GlobalSearch;
import com.SNM.app.crud.*;
import com.SNM.app.dynamicjasper.Jasper;
import com.SNM.app.dynamicjasper.ReviewComment;

import java.io.IOException;
import java.util.Scanner;

public class HomePage

{

    Scanner userchoice= new Scanner(System.in);
    private String genreofchoice;
    private String languageofchoice;
    private String moviedetailsneeded;
    private String moviedetailsbasedonname;
    private String groupdetailsneeded,email;

  public HomePage() throws IOException {
            this.email=ExistingUser.emailID;
          System.out.println("Enter your choice");
          System.out.println("1: Genre\n2: Language\n3: Trending Now\n4: Notifications\n5: Movie Search\n6: Watchlist\n7: Reports\n8: GlobalSearch");
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
                  System.out.println("Notification about Release based on your preferences:");
                        FetchNotification fetchNotification = new FetchNotification(email);
                  System.out.println("1.Last week release information\n2.Last month release information\n3.Next week release information\n4.Next month release information\n");
                  int notificationChoice = userchoice.nextInt();
                  switch (notificationChoice)
                  {
                      case(1):fetchNotification.getPastWeek();
                          break;
                      case(2):fetchNotification.getPast30days();
                          break;
                      case(3):fetchNotification.getNextweek();
                          break;
                      case(4):fetchNotification.getNextMonth();
                          break;
                          default:
                              break;
                  }
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
              case (7):
                  System.out.println("View Reports");
                  System.out.println("1.Movie Details based on genre 2.Review Comments based on movie");
                  int choice = userchoice.nextInt();
                  if (choice == 1){
                    Jasper jasper = new Jasper();
                  }
                  else
              {
                  ReviewComment reviewComment = new ReviewComment();}
                  break;
              case (8):
                  GlobalSearch search=new GlobalSearch();
                  break;
                  default:
                  System.out.println("EXIT");
          }
  }




}


