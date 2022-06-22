/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Persistence.DBConnector;
/**
 *
 * @author Dozent
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        DBConnector dbc = new DBConnector();

        try {
            dbc.read();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
