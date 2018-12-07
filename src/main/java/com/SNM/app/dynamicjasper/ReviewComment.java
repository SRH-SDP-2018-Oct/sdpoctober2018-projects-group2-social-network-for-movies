package com.SNM.app.dynamicjasper;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.Scanner;

public class ReviewComment {
    private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String myUrl = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root123";



    public ReviewComment() {

        PreparedStatement preparedStatement;
        Connection dbConnection = null;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the movie for its review comments");
            String moviename = scan.nextLine();
            dbConnection = null;
            preparedStatement = null;
            String query = "SELECT userreview.email_ID,userreview.timestamp,userreview.review from userreview  join moviedetail  on moviedetail.movie_ID=userreview.movie_ID and moviedetail.movie_name=?";
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(myUrl, DB_USER, DB_PASSWORD);
            preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, moviename);
            ResultSet r = preparedStatement.executeQuery();

//                    while (r.next()) {
//
//                        String emailid = r.getString("email_ID");
//                        String genre1 = r.getString("genre");
//                        String movieid1 = r.getString("movie_name");
//                        String releasedate = r.getString("releasedate");
//
//
//                        System.out.println("email_ID : " + emailid);
//                        System.out.println("genre : " + genre1);
//                        System.out.println("movie_ID :" + movieid1);
//                        System.out.println("releasedate :" + releasedate);
//
//
//                    }

            FastReportBuilder drb = new FastReportBuilder();
            DynamicReport dr = drb.addColumn("Email ID", "email_ID", String.class.getName(), 30)
                                  .addColumn("Time&Date", "timestamp", String.class.getName(), 50)
                                  .addColumn("User Review", "review", String.class.getName(), 50)
                    .setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();
            JRResultSetDataSource jasRs = new JRResultSetDataSource(r); // Convert Resultset to Jasper Resultset
            JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), jasRs);
            JasperViewer.viewReport(jp); // finally display the report report
//                    while (r.next()) {
//
//                        String emailid = r.getString("email_ID");
//                        String genre1 = r.getString("genre");
//                        String movieid1 = r.getString("movie_name");
//                        String releasedate = r.getString("releasedate");
//
//
//                        System.out.println("email_ID : " + emailid);
//                        System.out.println("genre : " + genre1);
//                        System.out.println("movie_ID :" + movieid1);
//                        System.out.println("releasedate :" + releasedate);
//
//                        System.out.format("%s, %s, %s, %s\n", emailid, genre1, movieid1, releasedate);
//
//
//                    }
//                    r.close();

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (JRException e1) {
            e1.printStackTrace();
        }
    }
//                try{
//                String query2 = "SELECT count(movie_name) FROM test.moviedetail where MONTH(releasedate)=? and YEAR(releasedate)=?";
//                Class.forName(DB_DRIVER);
//                dbConnection = DriverManager.getConnection(myUrl, DB_USER, DB_PASSWORD);
//                preparedStatement = dbConnection.prepareStatement(query2);
//                preparedStatement.setString(1, date);
//                ResultSet rs = preparedStatement.executeQuery();
//                FastReportBuilder drb = new FastReportBuilder();
//                DynamicReport dr = drb.addColumn("No of times movie released", "count(movie_name)", String.class.getName(), 30)
//
////                        .addColumn("Genre", "genre", String.class.getName(), 30)
////                        .addColumn("Movie Name", "movie_name", String.class.getName(), 50)
//                        .setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();
//                JRResultSetDataSource resultsetdatasource = new JRResultSetDataSource(rs); // Convert Resultset to Jasper Resultset
//                JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), resultsetdatasource);
//                JasperViewer.viewReport(jp); // finally display the report report
//                while (rs.next()) {
//
//                    String count = rs.getString("count(movie_name)");
////                    String genre1 = rs.getString("genre");
////                    String movieid1 = rs.getString("movie_name");
////
////
////                    System.out.println("email_ID : " + emailid);
////                    System.out.println("genre : " + genre1);
//                    System.out.println("count(movie_name) :" + count);
//                    //System.out.format("%s, %s, %s\n", emailid, genre1, movieid1);
//
//
//                }
//                rs.close();
//
//            } catch (ClassNotFoundException e1) {
//    e1.printStackTrace();
//} catch (SQLException e1) {
//    e1.printStackTrace();
//} catch (JRException e1) {
//    e1.printStackTrace();
//}


    }

