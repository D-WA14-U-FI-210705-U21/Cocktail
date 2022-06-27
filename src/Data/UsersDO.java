/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Date;

/**
 *
 * @author cardi
 */
public abstract class UsersDO {
    private short pk_ID = 0;
    private String name;
    private String password;
    private boolean admin;
    private boolean editor;
    private boolean locked;
    private boolean registered;
    private Date birthdate;

    protected UsersDO(String name, String password, boolean admin, boolean editor, boolean locked, boolean registered, Date birthdate) {
        this.name = name;
        this.password = password;
        this.admin = admin;
        this.editor = editor;
        this.locked = locked;
        this.registered = registered;
        this.birthdate = birthdate;
    }
    
    

    public short getPk_ID() {
        return pk_ID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isEditor() {
        return editor;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isRegistered() {
        return registered;
    }

    public Date getBirthdate() {
        return birthdate;
    }
    
    protected void setPk_ID(short pk_ID) {
        this.pk_ID = pk_ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setEditor(boolean editor) {
        this.editor = editor;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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
