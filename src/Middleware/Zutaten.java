/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;

import Frontend.Dialog;

/**
 *
 * @author buennig
 */
public class Zutaten {
    private int fk_pk_c_ID;
    private int fk_pk_i_ID;
    private int menge;
   
    
    public Zutaten(){
        this(-1,-1,0);
    }
    public Zutaten(int fk_pk_cocktail_ID, int fk_pk_ingredient_ID, int amount) {
        this.fk_pk_c_ID = fk_pk_cocktail_ID;
        this.fk_pk_i_ID = fk_pk_ingredient_ID;
        this.menge = amount;
    }
    
    public int getFk_pk_c_ID() {
        return fk_pk_c_ID;
    }

    public void setFk_pk_c_ID(int fk_pk_cocktail_ID) {
        this.fk_pk_c_ID = fk_pk_cocktail_ID;
    }

    public int getFk_pk_i_ID() {
        return fk_pk_i_ID;
    }

    public void setFk_pk_i_ID(int fk_pk_ingredient_ID) {
        this.fk_pk_i_ID = fk_pk_ingredient_ID;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    
    /**
     * Speichert Zutaten in die Datenbank unter Beruecksichtigung des
     * Aufrufparameters. Zutaten koennen sowohl erzeugt alsauch geaendert
     * werden.
     * @param create true=erzeugen, false=aendern
     * @return       Speichervorgang erfolgreich(ja/nein)
     */
    public boolean save(boolean create){
        try 
            {
            // via ZutatenDAO
            if(create){
                //SQL INSERT Zutaten...
            } else {
                //SQL UPDATE Zutaten...
            }
        } 
        catch(Exception ex) {
            new Dialog("Fehler", ex.getMessage(), true).setVisible(true);
            return false;
        }
        return true;
    }

}
