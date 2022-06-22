/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Dozent
 */
public class DBConnector {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet;
    
    public void read() throws Exception {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mariadb://localhost/cocktail?"
                        + "user=root");
            
            // Statement dient zum Absetzten von SQL-Queries zur Datenbank
            statement = connect.createStatement();
            // Result Set erhält das Ergebnis eines SQL-Queries
            resultSet = statement.executeQuery("select * from cocktail.users");
            while(resultSet.next()) {
                Integer pkID = resultSet.getInt("pk_ID");
                String name = resultSet.getString("name");
                // ...
                
                System.out.println(pkID + " : " + name);
            }
            
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
        } catch(Exception e) {
            
        }
    }
}
