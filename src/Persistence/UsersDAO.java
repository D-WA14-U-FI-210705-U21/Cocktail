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

    public UsersDAO(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate) {
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
        dbc.write(ps);

        ResultSet rsnew = dbc.read("SELECT DISTINCT * FROM USERS WHERE `NAME`='" + name + "'");
        while (rsnew.next()) {
            newUser = new UsersDAO(
                    rsnew.getString("name"),
                    rsnew.getString("password"),
                    rsnew.getBoolean("admin"),
                    rsnew.getBoolean("editor"),
                    rsnew.getBoolean("locked"),
                    rsnew.getBoolean("registered"),
                    rsnew.getDate("birthdate").toString()
            );
            newUser.setPk_ID(rsnew.getShort("pk_ID"));
            return newUser;
        }
        return null;
    }

    @Override
    public String toString() {
        return "UsersDAO:"
                + "\n pkID: " + getPk_ID()
                + "\n name: " + getName()
                + "\n password: " + getPassword()
                + "\n admin: " + isAdmin()
                + "\n editor: " + isEditor()
                + "\n locked: " + isLocked()
                + "\n registered: " + isRegistered()
                + "\n birthdate: " + getBirthdate();
    }

}
