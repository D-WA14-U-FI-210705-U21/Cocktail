/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistence;

import Data.UsersDO;
import java.util.ArrayList;

/**
 * @author Dozent
 */
public interface IUserManager {
    public abstract UsersDO registerUser(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    public abstract UsersDO showUser(int id);
    public abstract UsersDO showUser(String name);
    public abstract ArrayList<UsersDO> showAllUsers();
    public abstract UsersDO editUser(UsersDO usersDO);
    public abstract UsersDO saveUser(UsersDO usersDO);
    public abstract void delete(int id);
    public abstract void delete(String name);
    public abstract void delete(UsersDO usersDO);

    
    /* SELECT/FILTER */
    public abstract UsersDO selectUser(String name);
    public abstract UsersDO selectUserFilter(boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    public abstract UsersDO sortUsers(String column);
    
}
