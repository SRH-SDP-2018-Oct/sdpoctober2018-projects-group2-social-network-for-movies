package com.SNM.app.userinput;

import org.junit.*;

import static org.junit.Assert.*;

public class HomePageTest {

    String genre;
    String genre1="Action";
    String genre2="Romance";
    String language1="Kannada";
    String language2="English";
    String mess1="Genre 1 are action movies";
    String mess2="Genre 2 are romance movies";



    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Before Switch Case");
    }

    @Test
    public void switchCases() throws Exception
    {
        assertEquals("You chose Action","Action",genre1);
        assertEquals("You chose Romance","Romance",genre2);

        assertFalse("Genre 1 are action movies", genre1!="Action");
        System.out.println("You selected the genre Action");
        assertFalse("Genre 2 are romance movies", genre2!="Romance");
        System.out.println("You selected genre Romance");
        assertFalse("You selected Kannada", language1!="Kannada");
        System.out.println("You selected the Language Kannada");
        assertFalse("You selected English", language2!="English");
        System.out.println("You selected the Language English");


    }


    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("Succesfully executed switch case");
    }


//    Annotations such as @Test cannot be run here, because there has to be a method inside the class to be tested
//    @Test
//    public void switchCase throws Exception{
//
//        assertTrue("It is an action movie",genre1=="Action");
//    }
}