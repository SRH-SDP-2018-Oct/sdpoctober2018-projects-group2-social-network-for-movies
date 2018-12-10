package com.SNM.app.userinput;

import com.SNM.app.crud.*;
import com.SNM.app.dynamicjasper.Jasper;
import com.SNM.app.dynamicjasper.ReviewComment;

import java.io.IOException;
import java.util.Scanner;

public class HomePage {

    Scanner userchoice = new Scanner(System.in);
    private String genreofchoice;
    private String languageofchoice;
    private String moviedetailsneeded;
    private String moviedetailsbasedonname;
    private String groupdetailsneeded, email;

    public HomePage() throws IOException {
        this.email = ExistingUser.emailID;
        boolean i=true;
        while (i) {
            System.out.println("------------------");
            System.out.println("    DASHBOARD     ");
            System.out.println("------------------");
            System.out.println("1: Genre\n2: Language\n3: Trending Now\n4: Notifications\n5: Movie Search\n6: My Watchlist\n7: Reports\n8: GlobalSearch\n9: Exit\n");
            System.out.println("Enter your choice");
            int userChoice = userchoice.nextInt();
            switch (userChoice) {
                case (1):
                    System.out.println("Genres available:");
                    System.out.println("-----------------");
                    System.out.println("Action\nAdventure\nBiography\nComedy\nCrime\nDrama\nFamily\nFantasy\nHistory\nRomance\nScience Fiction\nSport\nWar\n");
                    System.out.println("Enter your choice of genre :");
                    genreofchoice = userchoice.next();
                    FetchMoviesGenre fetchMoviesGenre = new FetchMoviesGenre(genreofchoice);
                    break;
                case (2):
                    System.out.println("Languages available:");
                    System.out.println("--------------------");
                    System.out.println("en - English en\nka - Kannada\nhi - Hindi\nte - Telugu\nta - Tamil\nma - Malyalam\nge - German\nsp - Spanish\nfr - French\nit - Italian\n");
                    System.out.println("Enter your choice of language : Example, Press en for English");
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
                    switch (notificationChoice) {
                        case (1):
                            fetchNotification.getPastWeek();
                            break;
                        case (2):
                            fetchNotification.getPast30days();
                            break;
                        case (3):
                            fetchNotification.getNextweek();
                            break;
                        case (4):
                            fetchNotification.getNextMonth();
                            break;
                        default:
                            break;
                    }
                    break;
                case (5):
                    System.out.println("Please enter name of the Movie :");
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
                        System.out.println("1.Movie details based on your genre\n 2.Review comments based on movie");
                        int choice = userchoice.nextInt();
                        if (choice == 1) {
                            Jasper jasper = new Jasper();
                        } else if (choice == 2) {
                            ReviewComment reviewComment = new ReviewComment();
                        }

                        break;

                case (8):
                    GlobalSearch search = new GlobalSearch();
                    break;
                case(9):
                    i=false;
                    System.out.println("Auf wiedersehen!");
                    break;
                default:
                    System.out.println("EXIT");
            }
        }


    }
}


