/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Persistence.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Dozent
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        DBConnector dbc = new DBConnector();

        try {
            PreparedStatement ps = dbc.getPreparedStatement(
                    "INSERT INTO Users (name, `password`, admin, editor, locked, registered, birthdate)"
                            + " VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, "Admin");
            ps.setString(2, "jksbdkbsadjkc");
            ps.setBoolean(3, true);
            ps.setBoolean(4, false);
            ps.setBoolean(5, false);
            ps.setBoolean(6, true);
            ps.setDate(7, new java.sql.Date(2000, 12, 10));
            int n = dbc.write(ps);
            System.out.println("Es wurden " + n + " User hinzugefügt!");
            
            ResultSet resultSet = dbc.read("select * from cocktail.users");
            while(resultSet.next()) {
                Integer pkID = resultSet.getInt("pk_ID");
                String name = resultSet.getString("name");
                // ...
                
                System.out.println(pkID + " : " + name);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
