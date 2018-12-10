package com.SNM.app.userinput;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GlobalSearchTest {
    public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";

    @Test
public void search(){
    GlobalSearchTest globalSearchTest = new GlobalSearchTest();
}

    public GlobalSearchTest() {
        String searchTerm = "abcd";// = "abcd";
        if(searchTerm.equals("")){fail();}
        String search2;
        String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num=10";
        Document document = null;
        try {
            document = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements results = document.select("h3.r > a");
        for (Element result : results) {
            String linkHref = result.attr("href");
            String linkText = result.text();
            System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
        }
        assertTrue(results!=null);
    }

    }