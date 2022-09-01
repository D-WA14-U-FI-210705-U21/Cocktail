package Middleware;

import Frontend.Dialog;

public class Bestandteile {
    private int pk_ID = 0;
    private String name;
    private double alk = 0.0f;
    private boolean status = true; // true=Getraenk, false=Sonstiges
    
    /*
    Konstruktoren
    */
    public Bestandteile(String name, double alk) {
        if(name == null)name = "";
        if (alk < 0) alk = -alk;
            
        this.name = name;
        this.alk = alk;
        
    }

    public Bestandteile(String name) {
        this(name, 0.0);
    }

    public Bestandteile() {
        this("",0.0); // Konstruktor ruft eine überladene Version von sich selbst
        // mit this auf
        // mit super würde ein Konstruktor der uebergeordneten Klasse aufgerufen werden
    }
    
    /*
    Getter und Setter
    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlk() {
        return alk;
    }

    public void setAlk(double alk) {
        this.alk = alk;
    }

    public int getPk_ID() {
        return pk_ID;
    }

    public void setPk_ID(int pk_ID) {
        this.pk_ID = pk_ID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
   
    
    /*
    Methoden
    */
    @Override
    public String toString(){
        return this.name+" ("+this.alk+")";
    }
    public String toString(boolean status){
        if(status)
            return this.name+" ("+this.alk+")";
        else
            return this.name;
    }
    @Override
    public boolean equals(Object obj) {
       
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Bestandteile other = (Bestandteile) obj;
        if (this.alk != other.alk) {
            return false;
        }
        if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    public Bestandteile[] add(Bestandteile[] arr)
    {
        int i;
        Bestandteile[] retval = null;
        if(arr == null)
        {
            retval = new Bestandteile[1];
        }else
        {
            retval = new Bestandteile[arr.length + 1];
        }
        for( i = 0; i < retval.length - 1; i++)
        {
            retval[i] = arr[i]; // kopieren 
        }
        retval[i] = this; 
        return retval;
    }
    
    /**
     * Speichert einen Bestandteile in der Datenbank unter Beruecksichtigung des
     * Aufrufparameters. Bestandteile koennen sowohl erzeugt alsauch geaendert
     * werden.
     * @param create true=erzeugen, false=aendern
     * @return       Speichervorgang erfolgreich(ja/nein)
     */
    public boolean save(boolean create){
        try 
            {
            // BestandteileDAO
            if(create){
                //SQL INSERT Getraenke...
            } else {
                //SQL UPDATE Getraenke...
            }
        } 
        catch(Exception ex) {
            new Dialog("Fehler", ex.getMessage(), true).setVisible(true);
            return false;
        }
        return true;
    }

}
