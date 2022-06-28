/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistence;

import Data.UsersDO;
import java.util.ArrayList;

/**
 * @param <T> Type
 * @author Dozent
 */
public interface IUserManager<T> {
    public abstract UsersDO registerUser(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    public abstract UsersDO showUser(int id);
    public abstract UsersDO showUser(String name);
    public abstract ArrayList<UsersDO> showAllUsers();
    public abstract UsersDO editUser(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    public abstract UsersDO saveUser(UsersDO usersDO);
    public abstract void delete(int id);
    public abstract void delete(String name);
    public abstract void delete(UsersDO usersDO);
    
    /* Use-Cases */
    public abstract UsersDO registerGuest(String name, String password, String birthdate);
    public abstract UsersDO registerAdmin(String name, String password, String birthdate);
    public abstract UsersDO registerEditor(String name, String password, String birthdate);
    
    /* EDIT/UPDATE */
    public abstract UsersDO editGuest(String name, String password);
    public abstract UsersDO editEditor(String name, String password);
    public abstract UsersDO editAdmin(String name, String password, boolean admin, boolean editor, String birthdate);
    
    /* DELETE */
    public abstract void deleteGuest(UsersDO usersDO);
    public abstract void deleteEditor(UsersDO usersDO);
    public abstract void deleteAdmin(T type);
    
    /* SELECT/FILTER */
    public abstract UsersDO selectUser(String name);
    public abstract UsersDO selectUserFilter(boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    public abstract UsersDO sortUsers(String column);
    
}
