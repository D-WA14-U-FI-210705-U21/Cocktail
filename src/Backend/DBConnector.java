/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Dozent
 */
public class DBConnector {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet;

    public ResultSet read(String queryString) throws Exception {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mariadb://localhost/cocktail?"
                            + "user=root");
            // Statement dient zum Absetzten von SQL-Queries zur Datenbank
            statement = connect.createStatement();
            // Result Set erhält das Ergebnis eines SQL-Queries
            resultSet = statement.executeQuery(queryString);
            return resultSet;
        } catch (Exception e) {
            throw e;
        } finally {
             close();
        }
    }

    public PreparedStatement getPreparedStatement(String queryString) throws Exception {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mariadb://localhost/cocktail?"
                            + "user=root");
            preparedStatement = connect.prepareStatement(queryString);
            return preparedStatement;
        } catch (Exception e) {
            throw e;
        }
    }

    
    public void write(PreparedStatement ps) throws Exception {
        try {
            // Result Set erhält das Ergebnis eines SQL-Queries
            ps.executeQuery();
            // System.out.println(rs.getString("pk_ID") + " : " + rs.getString("name"));
        } catch(Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
