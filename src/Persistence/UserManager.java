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
public class UserManager implements IUserManager{

    @Override
    public UsersDO registerUser(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, String birthdate) {
        UsersDO newUser = null;
        try{
            newUser = UsersDAO.create(name, password, admin, editor, locked, registered, birthdate);
        }catch (Exception e){
            System.out.println(e);
        }       
        return newUser;
    }

    @Override
    public UsersDO showUser(int id) {
        UsersDO user = null;
        try{
            user = UsersDAO.read(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    @Override
    public UsersDO showUser(String name) {
        UsersDO user = null;
        try{
            user = UsersDAO.read(name);
        }catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    @Override
    public ArrayList<UsersDO> showAllUsers(){
        ArrayList<UsersDO> resList = new ArrayList<>();
        try{
        for(UsersDAO user : UsersDAO.readAll()){
            resList.add(user);
        }
        }catch (Exception e){
            System.out.println(e);
        }
        return resList;
    }

    @Override
    public UsersDO editUser(UsersDO usersDO) {
        UsersDAO user = new UsersDAO(usersDO.getName(),
                usersDO.getPassword(),
                usersDO.isAdmin(),
                usersDO.isEditor(),
                usersDO.isLocked(),
                usersDO.isRegistered(),
                usersDO.getBirthdate()) {
        };
        try{
            return user.update();
        }catch (Exception e){
            System.out.println(e);
        }
            return null;
    }

    @Override
    public UsersDO saveUser(UsersDO usersDO) {
        return editUser(usersDO);
    }

    @Override
    public void delete(int id) {
        try{
        UsersDAO.delete((short) id);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(String name) {
        try{
        UsersDAO.delete(name);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(UsersDO usersDO) {
        try{
         UsersDAO.read(usersDO.getPk_ID()).delete();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public UsersDO selectUser(String name) {
        try{
         return UsersDAO.read(name);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public UsersDO selectUserFilter(boolean admin, boolean editor, boolean locked, boolean registered) {
        
        return null;
    }

    @Override
    public UsersDO sortUsers(String column) {
        return null;
    }
    
}
