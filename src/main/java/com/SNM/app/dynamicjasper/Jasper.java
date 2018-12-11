package com.SNM.app.dynamicjasper;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import com.SNM.app.userinput.ExistingUser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.Scanner;

public class Jasper
{       private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
        private static String myUrl = "jdbc:mysql://localhost:3306/snm_final";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "root123";

        public Jasper(){

            PreparedStatement preparedStatement;
            Connection dbConnection = null;
            try {
                Scanner scan = new Scanner(System.in);
                    System.out.println("Confirm your the email");
                    String email = scan.nextLine();
                    if(!(email.equals(ExistingUser.emailID))){
                        System.out.println("Malicious activity detected!!\nExiting application.");
                        System.exit(-2);
                    }
                    System.out.println("Enter the month");
                    String month = scan.nextLine();
                    System.out.println("Enter the year");
                    String year = scan.nextLine();

                    dbConnection = null;
                    preparedStatement = null;
                    String query = "SELECT g.genre,m.movie_name,m.releasedate from genrelist g join preferences p on p.genre=g.genre join moviedetail m on g.movie_ID=m.movie_ID where email_ID= ? and MONTH(releasedate)=? and YEAR(releasedate)=?";
                    Class.forName(DB_DRIVER);
                    dbConnection = DriverManager.getConnection(myUrl, DB_USER, DB_PASSWORD);
                    preparedStatement = dbConnection.prepareStatement(query);
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2,month);
                    preparedStatement.setString(3,year);
                    ResultSet r = preparedStatement.executeQuery();
                    if (!r.next() ) {
                        System.out.println("No data found for your selection");
                    }
                    else {
                        FastReportBuilder drb = new FastReportBuilder();
                        DynamicReport dr = drb
                                .addColumn("Genre", "genre", String.class.getName(), 30)
                                .addColumn("Movie Name", "movie_name", String.class.getName(), 50)
                                .addColumn("Release Date", "releasedate", String.class.getName(), 30).setTitle("Movies based on your preferred genre")
                                .setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();
                        JRResultSetDataSource jasRs = new JRResultSetDataSource(r);
                        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), jasRs);
                        JasperViewer.viewReport(jp);
                    }

                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (JRException e1) {
                    e1.printStackTrace();
                }

            }
    }
