package com.SNM.app.dynamicjasper;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.Scanner;

public class Jasper
{       private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
        private static String myUrl = "jdbc:mysql://localhost:3306/test";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "root123";

        public Jasper(){

            PreparedStatement preparedStatement;
            Connection dbConnection = null;
            try {
                Scanner scan = new Scanner(System.in);
                    System.out.println("Enter the email");
                    String email = scan.nextLine();
                    System.out.println("Enter the month");
                    String month = scan.nextLine();
                    System.out.println("Enter the year");
                    String year = scan.nextLine();

                    dbConnection = null;
                    preparedStatement = null;
                    String query = "SELECT p.email_ID,g.genre,m.movie_name,m.releasedate from genrelist g join preferences p on p.genre=g.genre join moviedetail m on g.movie_ID=m.movie_ID where email_ID= ? and MONTH(releasedate)=? and YEAR(releasedate)=?";
                    //String query1 = "SELECT count(movie_name) FROM test.moviedetail where MONTH(releasedate)=? and YEAR(releasedate)=?";
                    Class.forName(DB_DRIVER);
                    dbConnection = DriverManager.getConnection(myUrl, DB_USER, DB_PASSWORD);
                    preparedStatement = dbConnection.prepareStatement(query);
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2,month);
                    preparedStatement.setString(3,year);
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
                                          .addColumn("Genre", "genre", String.class.getName(), 30)
                                          .addColumn("Movie Name", "movie_name", String.class.getName(), 50)
                                          .addColumn("Release Date", "releasedate", String.class.getName(), 30)
                            .setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();
                    JRResultSetDataSource jasRs = new JRResultSetDataSource(r); // Convert Resultset to Jasper Resultset
                    JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), jasRs);
                    JasperViewer.viewReport(jp);

                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (JRException e1) {
                    e1.printStackTrace();
                }

            }
    }
