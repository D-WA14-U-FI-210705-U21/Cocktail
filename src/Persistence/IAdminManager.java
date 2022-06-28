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
    public abstract UsersDO registerGuest(String name, String password, String birthdate) throws AdminException;
    public abstract UsersDO registerAdmin(String name, String password, String birthdate) throws AdminException;
    public abstract UsersDO registerEditor(String name, String password, String birthdate) throws AdminException;
    
    /* Update */
    public abstract UsersDO editGuest(UsersDO usersDO) throws AdminException;
    public abstract UsersDO editEditor(UsersDO usersDO) throws AdminException;
    public abstract UsersDO editAdmin(UsersDO usersDO) throws AdminException;
    
    /* Delete */
    public abstract void deleteAdmin(int id) throws AdminException;
    public abstract void deleteAdmin(String name) throws AdminException;
    public abstract void deleteAdmin(UsersDO usersDO) throws AdminException;
    
    
}
