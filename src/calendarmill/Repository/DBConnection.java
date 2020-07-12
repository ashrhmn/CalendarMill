/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarmill.Repository;

/**
 *
 * @author ashrh
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBConnection {

    Connection con = null;
    Statement st;
    ResultSet result;

    /**
     * Connect to a sample database
     */
    public void openConnection() {
        try {
            // db parameters
            String url = "jdbc:sqlite:Database.db";
            // create a connection to the database
            con = DriverManager.getConnection(url);
            st = con.createStatement();

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {

        try {
            if (con != null) {
                con.close();
            }
            if (st != null) {
                st.close();
            }
            if (result != null) {
                result.close();
            }
        } catch (Exception e) {
        }

    }
    /**
     * @param args the command line arguments
     */
}
