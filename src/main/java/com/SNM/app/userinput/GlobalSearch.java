package com.SNM.app.userinput;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class GlobalSearch {

    public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
    public GlobalSearch() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the movie to be searched in internet:  ");
        String searchTerm = scanner.nextLine();
        String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num=10";
        Document document = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
        Elements results = document.select("h3.r > a");
        for (Element result : results) {
            String linkHref = result.attr("href");
            String linkText = result.text();
            System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
        }
    }

}
