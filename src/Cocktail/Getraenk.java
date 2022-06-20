package Cocktail;

import java.util.Objects;

public class Getraenk {

    private String name;
    private double alk;
    
    /*
    Konstruktoren
    */
    public Getraenk(String name, double alk) {
        if(name == null)name = "";
        if (alk < 0) alk = -alk;
            
        this.name = name;
        this.alk = alk;
        
    }

    public Getraenk(String name) {
        this(name, 0.0);
    }

    public Getraenk() {
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

    
    
    /*
    Methoden
    */
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
        Getraenk other = (Getraenk) obj;
        if (this.alk != other.alk) {
            return false;
        }
        if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    public Getraenk[] add(Getraenk[] arr)
    {
        int i;
        Getraenk[] retval = null;
        if(arr == null)
        {
            retval = new Getraenk[1];
        }else
        {
            retval = new Getraenk[arr.length + 1];
        }
        for( i = 0; i < retval.length - 1; i++)
        {
            retval[i] = arr[i]; // kopieren 
        }
        retval[i] = this; 
        return retval;
    }
    
    
}
