/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author cardi
 */
public class IngredientsDAO extends Data.IngredientsDO {
    
    private static DBConnector dbc = new DBConnector();
    
    public IngredientsDAO(String name, float alc) {
        super(name, alc);
    }
    
    public static IngredientsDAO create(String name, float alc) throws Exception{
        PreparedStatement ps = dbc.getPreparedStatement(
                "INSERT INTO `ingredients` (name, alcohol)"
                + " VALUES (?, ?)");
        
        ps.setString(1, name);
        ps.setFloat(1, alc);
        dbc.write(ps);
        return read(name);
    }
    
    public static IngredientsDAO read(short pk_ID) throws Exception{
        IngredientsDAO newIngredient = null;
        ResultSet rs = dbc.read("SELECT DISTINCT FROM `ingredients` "
                + "WHERE `pk_ID`=" + pk_ID);
        while(rs.next()){
        rs.getString("name");
        rs.getFloat("alcohol");
        }
            newIngredient.setPk_ID(rs.getShort("pk_ID"));
        return newIngredient;
    }
    
    public static IngredientsDAO read(String name) throws Exception{
        IngredientsDAO newIngredient = null;
        ResultSet rs = dbc.read("SELECT DISTINCT FROM `ingredients` "
                + "WHERE `name`=" + name);
        
        while(rs.next()){
        rs.getString("name");
        rs.getFloat("alcohol");
        }
            newIngredient.setPk_ID(rs.getShort("pk_ID"));
        return newIngredient;
    }
    
    public IngredientsDAO update() throws Exception {
        IngredientsDAO updatedIngredient = null;
        
        PreparedStatement ps = dbc.getPreparedStatement(
                "UPDATE Users SET "
                        + "`name` = ? , "
                        + "`alcohol` = ? , "
                        + "WHERE `pk_ID` = ? ;");
        ps.setString(1, this.getName());
        ps.setFloat(2, this.getAlcohol());
        ps.setShort(3, this.getPk_ID());
        
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

    
    // konkrete Instanz löschen aus der Datenbank
    public void delete() throws Exception {
        UsersDAO.delete(this.getPk_ID());
        this.setPk_ID((short)0);
    }
    
    @Override
    public String toString() {
        return "Ingredients:"
                + "\n pk_ID: " + getPk_ID()
                + "\n name: " + getName()
                + "\n alcohol: " + getAlcohol()
                + "\n";
    } 
    
}
