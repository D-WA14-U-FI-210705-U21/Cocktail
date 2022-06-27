/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Persistence.DBConnector;
import Persistence.IngredientsDAO;
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
            System.out.println(UsersDAO.readAll());
            
            IngredientsDAO newIngredient = IngredientsDAO.create("Orangensaft", 0.0f);
            System.out.println(newIngredient);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
