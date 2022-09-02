/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Middleware.Cocktail;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author cardi
 */
public class CocktailsDAO {
    private static DBConnector dbc = new DBConnector();
    private Cocktail cObj;

    public CocktailsDAO(Cocktail obj) {
        this.cObj = obj;
    }
    
    //CRUD
    public static CocktailsDAO create(String name, String description) throws Exception {
        CocktailsDAO newCocktail = null;

        PreparedStatement ps = dbc.getPreparedStatement(
                "INSERT INTO Users (name, description)"
                + " VALUES (?, ?)");
        ps.setString(1, name);
        ps.setString(2, description);
        dbc.write(ps);
        
        return CocktailsDAO.read(name);
   }
    
    
    public static CocktailsDAO read(int id) throws Exception {
        CocktailsDAO newCocktail = null;

        ResultSet rs = dbc.read("select DISTINCT * FROM Cocktails WHERE `pk_ID`=" + id);
        while (rs.next()) {
            newCocktail = new CocktailsDAO(
                    rs.getString("name"),
                    rs.getString("description")
                   
            );
            
            newCocktail.setPk_ID(rs.getShort("pk_ID"));
        }
        
        return newCocktail;
    }
    
     
    public static CocktailsDAO read(String name) throws Exception {
        CocktailsDAO newCocktail = null;

        ResultSet rs = dbc.read("select DISTINCT * FROM Cocktails WHERE `name`='" + name + "'");
        while (rs.next()) {
            newCocktail = new CocktailsDAO(
                    rs.getString("name"),
                    rs.getString("description")
                   
            );
            
            newCocktail.setPk_ID(rs.getShort("pk_ID"));
        }
        
        return newCocktail;
    }
    
    public static ArrayList<CocktailsDAO> readAll() throws Exception
    {
        int i = 1;
        ArrayList<CocktailsDAO> resultList = new ArrayList<CocktailsDAO>();
        ResultSet resultSet = dbc.read("Select * From users ");
        while (resultSet.next()) {
            resultList.add(new CocktailsDAO(resultSet.getString("name"), resultSet.getString("description")));
            //resultList.add(resultSet(i));// später von Jenny klauen ;)!!!!!!!!!!!!
            
        }
        
        
       
        return resultList;
    }
    
     public CocktailsDAO update() throws Exception {
        CocktailsDAO updatedCocktail = null;
        
        PreparedStatement ps = dbc.getPreparedStatement(
                "UPDATE Users SET "
                        + "`name` = ? "
        );
        ps.setString(1, this.getName());
       // ps.setString(2, this.getDescription());
        
        //ps.setShort(8, this.getPk_ID());
        
        dbc.write(ps);
        
        updatedCocktail = CocktailsDAO.read(this.getPk_ID());
        
        return updatedCocktail;
    }
     
      
    public static void delete(int id) throws Exception {
         PreparedStatement ps = dbc.getPreparedStatement(
                "DELETE FROM Users WHERE pk_ID = " + id);
        
        dbc.write(ps);      
    }
    
    public static void delete(String name) throws Exception {
         PreparedStatement ps = dbc.getPreparedStatement(
                "DELETE FROM Users WHERE `name` = '" + name + "'");
        
        dbc.write(ps);      
    }
    
    // konkrete Instanz löschen aus der Datenbank
    public void delete() throws Exception {
        CocktailsDAO.delete(this.getPk_ID());
        this.setPk_ID(0);
    }
    
}
