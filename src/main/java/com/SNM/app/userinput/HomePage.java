package com.SNM.app.userinput;

import java.util.Scanner;

public class HomePage

{
    Scanner userchoice= new Scanner(System.in);
    String genreofchoice;
    String languageofchoice;
    String moviedetailsneeded;
    String moviedetailsbasedonname;
    String groupdetailsneeded;

  HomePage()
  {
      System.out.println("Enter your choice");
      System.out.println("1: Genre\n2: Language\n3: Trending Now\n4: Groups\n5: Movie Search\n6: Watchlist");
      int userChoice=userchoice.nextInt();
      switch(userChoice)
      {
          case (1):
              System.out.println("Genres Available");
              //Fetch FetchDetails
              System.out.println("Choose a particular genre");
              genreofchoice=userchoice.nextLine();
              //fetch movie list for this genre
              break;
          case (2):
              System.out.println("Languages Available");
              //Fetch
              System.out.println("Choose a particular Language");
              languageofchoice=userchoice.nextLine();
              //fetch all movies corresponding to this language
                break;
          case (3):
              System.out.println("List of all trending movies");
              //Fetch
              System.out.println("If you want to select a particular movie,please proceed");

              moviedetailsneeded=userchoice.nextLine();

              break;
          case (4):
              System.out.println("List of all groups");
              //Fetch
              System.out.println("If you want to view a particular group,please select from the list");
              groupdetailsneeded=userchoice.nextLine();
              break;
          case (5):
              System.out.println("Search on basis of movie name");
              //Fetch
              System.out.println("If you want to view a particular group,please select from the list");
              moviedetailsbasedonname=userchoice.nextLine();
              //call fetchmoviedetails class
              break;
          case (6):
              System.out.println("View Watchlist");
              //Fetch
              break;
          default:
              System.out.println("EXIT");

      }




  }

}
