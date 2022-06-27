/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Persistence.DBConnector;
import Persistence.UsersDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Dozent
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        

        try {
            UsersDAO newUser = UsersDAO.create("Editor", "dfsdfsdf", false, true, false, true, new java.sql.Date(2000, 12, 10));
            
            // System.out.println("Es wurde User mit der ID " + newUser.getPk_ID() + " hinzugefügt!");
            
//            DBConnector dbc = new DBConnector();
//            ResultSet resultSet = dbc.read("select * from users");
//            while(resultSet.next()) {
//                Integer pkID = resultSet.getInt("pk_ID");
//                String name = resultSet.getString("name");
//                // ...
//                
//                System.out.println(pkID + " : " + name);
//            }
            ArrayList<UsersDAO> daoList = UsersDAO.readAll();
            int n = daoList.size();
            System.out.println("List of Users after create():");
            System.out.println("=============================");
            for(int i = 0; i < n; i++){
                UsersDAO udao = daoList.get(i);
                System.out.println(udao.getPk_ID() + " : " + udao.getName()); 
            }
            
            newUser.delete();
            
            daoList = UsersDAO.readAll();
            n = daoList.size();
            System.out.println("\n\nList of Users after delete():");
            System.out.println("=============================");
            for(int i = 0; i < n; i++){
                UsersDAO udao = daoList.get(i);
                System.out.println(udao.getPk_ID() + " : " + udao.getName()); 
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
