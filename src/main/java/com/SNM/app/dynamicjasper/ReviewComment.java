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
    private static String myUrl = "jdbc:mysql://localhost:3306/SNM_Final";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root123";



    public ReviewComment() {

        PreparedStatement preparedStatement;
        Connection dbConnection = null;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the movie name for its review comment list:\n");
            String moviename = scan.nextLine();
            dbConnection = null;
            preparedStatement = null;
            String query = "SELECT userreview.email_ID,userreview.timestamp,userreview.review from userreview  join moviedetail  on moviedetail.movie_ID=userreview.movie_ID and moviedetail.movie_name=?";
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(myUrl, DB_USER, DB_PASSWORD);
            preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, moviename);
            ResultSet r = preparedStatement.executeQuery();
            FastReportBuilder drb = new FastReportBuilder();
            DynamicReport dr = drb.addColumn("Email ID", "email_ID", String.class.getName(), 30)
                                  .addColumn("Time&Date", "timestamp", String.class.getName(), 50)
                                  .addColumn("User Review", "review", String.class.getName(), 50)
                    .setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();
            JRResultSetDataSource jasRs = new JRResultSetDataSource(r); // Convert Resultset to Jasper Resultset
            JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), jasRs);
            JasperViewer.viewReport(jp); // finally display the report
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (JRException e1) {
            e1.printStackTrace();
        }
    }

}

