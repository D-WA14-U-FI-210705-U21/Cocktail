/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Persistence.DBConnector;
import Persistence.UsersDAO;
import java.sql.ResultSet;

/**
 *
 * @author Dozent
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            UsersDAO newUser = UsersDAO.create("Editor", "dfsdfsdf", false, true, false, true, "2000-12-10");
            System.out.println(newUser);
            // System.out.println("Es wurde User mit der ID " + newUser.getPk_ID() + " hinzugefügt!");

            DBConnector dbc = new DBConnector();
            ResultSet resultSet = dbc.read("select * from users");
            while (resultSet.next()) {
                Integer pkID = resultSet.getInt("pk_ID");
                String name = resultSet.getString("name");
                // ...

                System.out.println(pkID + " : " + name);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
