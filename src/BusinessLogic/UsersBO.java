/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.Date;

/**
 *
 * @author cardi
 */
public class UsersBO extends Data.UsersDO {

    public UsersBO(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, Date birthdate) {
        super(name, password, admin, editor, locked, registered, birthdate);
    }
    
    
}
