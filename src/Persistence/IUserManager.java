/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistence;

import Data.UsersDO;
import java.util.ArrayList;

/**
 *
 * @author Dozent
 */
public interface IUserManager {
    public abstract UsersDO registerUser(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate);
    public abstract UsersDO read(int id);
    public abstract UsersDO read(String name);
    public abstract ArrayList<UsersDO> readAll();
    public abstract UsersDO saveUser(UsersDO usersDO);
    public abstract void delete(int id);
    public abstract void delete(String name);
    public abstract void delete(UsersDO usersDO);
    
    /* Use-Cases */
    public abstract UsersDO registerGuest(String name, String password, String birthdate);
    public abstract UsersDO registerAdmin(String name, String password, String birthdate);
    public abstract UsersDO registerEditor(String name, String password, String birthdate);
    
    
}
