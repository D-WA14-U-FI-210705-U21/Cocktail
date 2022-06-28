/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Data.UsersDO;
import java.util.ArrayList;

/**
 * @param <T> Type, as the argument in the method delete() can vary
 * @author Jennifer Lange
 */
public interface IAdminManager<T> {
    
    
    /* Create*/
    public abstract UsersDO registerGuest(String name, String password, String birthdate);
    public abstract UsersDO registerAdmin(String name, String password, String birthdate);
    public abstract UsersDO registerEditor(String name, String password, String birthdate);
    
    /* Read */
    public abstract UsersDO showUser(int id);
    public abstract UsersDO showUser(String name);
    public abstract ArrayList<UsersDO> showAllUsers();
    
    /* Update */
    public abstract UsersDO editGuest(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    public abstract UsersDO editEditor(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    public abstract UsersDO editAdmin(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    
    /* Delete */
    public abstract void deleteGuest(T type);
    public abstract void deleteEditor(T type);
    public abstract void deleteAdmin(T type);
    
    
}
