/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Middleware.Bestandteile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author cardi
 */
public class BestandteileDAO {
    
    private static DBConnector dbc = new DBConnector();
    private Bestandteile bObj;
    
    public BestandteileDAO(Bestandteile obj) {
        this.bObj = obj;
    }
    
    public static BestandteileDAO create(String name, float alc) throws Exception{
        PreparedStatement ps = dbc.getPreparedStatement(
                "INSERT INTO `ingredients` (name, alcohol)"
                + " VALUES (?, ?)");
        
        ps.setString(1, name);
        ps.setFloat(2, alc);
        dbc.write(ps);
        
        return BestandteileDAO.read(name);
    }
    
    public static BestandteileDAO read(int pk_ID) throws Exception{
        BestandteileDAO newIngredient = null;
        ResultSet rs = dbc.read("SELECT * FROM `ingredients` "
                + "WHERE `pk_ID`=" + pk_ID);
        while(rs.next()){
            newIngredient = new BestandteileDAO(
                    rs.getString("name"),
                    rs.getFloat("alcohol"));
            newIngredient.setPk_ID(rs.getShort("pk_ID"));
        }
        return newIngredient;
    }
    
    public static BestandteileDAO read(String name) throws Exception{
        BestandteileDAO newIngredient = null;
        ResultSet rs = dbc.read("SELECT * FROM `ingredients` "
                + "WHERE `name`= '" + name + "'");
        
        while(rs.next()){
            newIngredient = new BestandteileDAO(
                    rs.getString("name"),
                    rs.getFloat("alcohol"));
            newIngredient.setPk_ID(rs.getShort("pk_ID"));
        }
        return newIngredient;
    }
    
    public static ArrayList<BestandteileDAO> readAll() throws Exception{
        short i = 1;
        ArrayList<BestandteileDAO> ingredientsList = new ArrayList<>();
        ResultSet rs = dbc.read("SELECT * FROM `ingredients`");
        while(rs.next()){
            ingredientsList.add(read(i));
            i++;
        }
        
        return ingredientsList;
    }
    
    public BestandteileDAO update() throws Exception {
        BestandteileDAO updatedIngredient = null;
        
        PreparedStatement ps = dbc.getPreparedStatement(
                "UPDATE Users SET "
                        + "`name` = ? , "
                        + "`alcohol` = ? , "
                        + "WHERE `pk_ID` = ? ;");
        ps.setString(1, this.getName());
        ps.setDouble(2, this.getAlk());
        ps.setInt(3, this.getPk_ID());
        
        dbc.write(ps);
        
        updatedIngredient = read(this.getPk_ID());
        
        return updatedIngredient;
    }
    
    public static void delete(short id) throws Exception {
         PreparedStatement ps = dbc.getPreparedStatement(
                "DELETE FROM ingredients WHERE pk_ID = " + id);
        
        dbc.write(ps);      
    }
    
    public static void delete(String name) throws Exception {
         PreparedStatement ps = dbc.getPreparedStatement(
                "DELETE FROM ingredients WHERE `name` = '" + name + "'");
        
        dbc.write(ps);      
    }
    
}
