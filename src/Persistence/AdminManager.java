/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Data.UsersDO;
import java.util.ArrayList;

/**
 *
 * @author Jennifer Lange
 */
public class AdminManager extends UserManager implements IAdminManager {

    @Override
    public UsersDO registerGuest(String name, String password, String birthdate) throws AdminException {
        UsersDO newUser = null;
        try {
            newUser = UsersDAO.create(name, password, false, false, false, true, birthdate);
        } catch (Exception e) {
            System.out.println(e);
        }
        return newUser;
    }

    @Override
    public UsersDO registerAdmin(String name, String password, String birthdate) throws AdminException {
        UsersDO newUser = null;
        try {
            newUser = UsersDAO.create(name, password, true, false, false, true, birthdate);
        } catch (Exception e) {
            System.out.println(e);
        }
        return newUser;
    }

    @Override
    public UsersDO registerEditor(String name, String password, String birthdate) throws AdminException {
        UsersDO newUser = null;
        try {
            newUser = UsersDAO.create(name, password, false, true, false, true, birthdate);
        } catch (Exception e) {
            System.out.println(e);
        }
        return newUser;
    }

    @Override
    public UsersDO showUser(int id) {
        UsersDO user = null;
        try {
            user = UsersDAO.read(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public UsersDO showUser(String name) {
        UsersDO user = null;
        try {
            user = UsersDAO.read(name);
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public ArrayList<UsersDO> showAllUsers() {
        ArrayList<UsersDO> resList = new ArrayList<>();
        try {
            for (UsersDAO user : UsersDAO.readAll()) {
                resList.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return resList;
    }
    
    @Override
    public UsersDO editAdmin(UsersDO usersDO) throws AdminException {
        if(!usersDO.isAdmin())throw new AdminException("You're not an admin!");
        UsersDAO user = new UsersDAO(usersDO.getName(),
                usersDO.getPassword(),
                usersDO.isAdmin(),
                usersDO.isEditor(),
                usersDO.isLocked(),
                usersDO.isRegistered(),
                usersDO.getBirthdate()) {
        };
        try {
            return user.update();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }

    @Override
    public UsersDO editGuest(UsersDO usersDO) throws AdminException {
        return editAdmin(usersDO);
    }

    @Override
    public UsersDO editEditor(UsersDO usersDO) throws AdminException {
        return editAdmin(usersDO);
    }

    @Override
    public void deleteAdmin(int id) throws AdminException {
        try{
        UsersDAO.delete((short) id);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAdmin(String name) throws AdminException {
        try{
        UsersDAO.delete(name);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAdmin(UsersDO usersDO) throws AdminException {
        try{
         UsersDAO.read(usersDO.getPk_ID()).delete();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
   

    

}
