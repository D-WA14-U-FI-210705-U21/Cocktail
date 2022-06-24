/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.*;
/**
 *
 * @author cardi
 */
public class UsersDAO extends Data.UsersDO {
    private static DBConnector dbc = new DBConnector();
    
    public UsersDAO(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, Date birthdate) {
        super(name, password, admin, editor, locked, registered, birthdate);
    }
    
    // CRUD
    public static UsersDAO create(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, Date birthdate) throws Exception {
          UsersDAO newUser;
          
          PreparedStatement ps = dbc.getPreparedStatement(
                    "INSERT INTO Users (name, `password`, admin, editor, locked, registered, birthdate)"
                            + " VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setBoolean(3, admin);
            ps.setBoolean(4, editor);
            ps.setBoolean(5, locked);
            ps.setBoolean(6, registered);
            ps.setDate(7, birthdate);
            ResultSet rs = dbc.write(ps);
            newUser  = new UsersDAO(
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getBoolean("admin"),
                    rs.getBoolean("editor"),
                    rs.getBoolean("locked"),
                    rs.getBoolean("registered"),
                    rs.getDate("birthdate")
            );
            newUser.setPk_ID(rs.getShort("pk_ID"));

            return newUser;
    }
    //Hier hat der Dozent eine Methohde delete mit throws implementiert
    /*
    
    public static void delete (short id) throws Exception{
    PreparedStatement ps = dbc.getPreparedStatement(
    "Delete FROM User where pk_ID = " + id );
    dbc.write(ps);
    return newUser;
    }
    
    public UsersDAO update() thorws Exception {
    UsersDAO updateUser = null;
    PreparedStatement ps = dbc.getPreparedStatemnt ("UPDATE  ")
    }
    
     public static void delete (String name ) throws Exception{
    PreparedStatement ps = dbc.getPreparedStatement(
    "Delete FROM User where `name` =`" + name + "'"); );
    dbc.write(ps);
    }
    
    
    
    
    )
    }
    
    konkrete Instanz löschen aus der Datenbank 
    
    
    public void delete() throws Exception{
    PreparedStatement ps = dbc.getPrepared Statement
    }
    
    */
    
    
    
    
    
    
    
}
