/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Data.UsersDO;
import java.util.ArrayList;

/**
 * @author Jennifer Lange
 */
public interface IAdminManager {
    
    
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
    public abstract void deleteGuest(int id);
    public abstract void deleteGuest(String name);
    public abstract void deleteGuest(UsersDO usersDO);
    public abstract void deleteEditor(int id);
    public abstract void deleteEditor(String name);
    public abstract void deleteEditor(UsersDO usersDO);
    public abstract void deleteAdmin(int id);
    public abstract void deleteAdmin(String name);
    public abstract void deleteAdmin(UsersDO usersDO);
    
    
}
