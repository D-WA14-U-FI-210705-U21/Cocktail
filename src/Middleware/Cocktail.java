package Middleware;

//import Frontend.Dialog;
import java.util.Arrays;
//import java.util.HashSet;
import java.util.Objects;

public class Cocktail {
    private int pk_ID = -1;

    private Bestandteile[] zutaten;
    private int[] menge;
    private String name;
    private String bild;

    /*
    Konstruktoren
     */
    public Cocktail(Bestandteile[] z, int[] m, String name, String bild) throws IllegalArgumentException {
        setZutatenUndMenge(z, m);
        this.name = name;
        this.bild = bild;
    }

    public Cocktail(Bestandteile[] z, int[] m, String name) {
        this(z, m, name, "");
    }

    public Cocktail() {
        this(new Bestandteile[0], new int[0], "", "");
    }

    /*
    Getter und Setter
     */
    
    public int getPk_ID() {
        return pk_ID;
    }

    public void setPk_ID(int pk_ID) {
        this.pk_ID = pk_ID;
    }
    
    public Bestandteile[] getZutaten() {
        return zutaten;
    }

    public void setZutaten(Bestandteile[] zutaten) {
        this.zutaten = zutaten;
    }

    public int[] getMenge() {
        return menge;
    }

    public void setMenge(int[] menge) {
        this.menge = menge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    /**
     * Die Methode setZutatenUndMenge() ermoeglicht das konsistente erstelleine
     * einer Zutatenliste aus Getraenke und Mengenangaben. Die MEthode prueft ob
     * die beiden uebergebenden Arrays dieselbe Laenge haben. Ist dies nicht der
     * Fall wird ein Laufzeitfehler ausgegeben
     *
     * @param z Array fuer Getraenke-Zutaten
     * @param m Array fuer Getraenke-Mengen
     * @throws IllegalArgumentException
     */
    public final void setZutatenUndMenge(Bestandteile[] z, int[] m) throws IllegalArgumentException {
        if (z == null || m == null) {
            throw new IllegalArgumentException("Zutaten oder Mengen Array fehlend");
        } else {
            if (z.length != m.length) {
                throw new IllegalArgumentException("Zutaten oder Mengen Array stimmen nicht überein");
            }
        }
        this.zutaten = z;
        this.menge = m;
    }

    /*
     * Sonstige Schnittstellen-Methoden
     */
    @Override
    public String toString(){
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
        final Cocktail other = (Cocktail) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.bild, other.bild)) {
            return false;
        }
        if (!Arrays.deepEquals(this.zutaten, other.zutaten)) {
            return false;
        }
        if (!Arrays.equals(this.menge, other.menge)) {
            return false;
        }
        return true;
    }
    /**
     * Die Methode addZutat fuegt dem Cocktail eine einzelne Zutat hinzu.
     * @param getraenk  Getraenke-Objekt der Zutat
     * @param menge     Menge der Zutat in cl
     */
    public void addZutat(Bestandteile getraenk, int menge) {
        if (getraenk != null) {
            this.zutaten = getraenk.add(this.zutaten);
            this.menge = this.add(this.menge, menge);
        }
    }
    /**
     * Die Methode removeZutat(pos) entfernt eine einzelne Zutat eines 
     * Cocktail-Objektes aus der Liste der Zutaten anhand der uebergeben
     * Listenposition.
     * @param pos Listenposition der Zutat
     */
    public void removeZutat(int pos) {
        int in = 0;
        Bestandteile[] g = new Bestandteile[this.zutaten.length - 1];
        int[] m = new int[this.menge.length - 1];
        for (int i = 0; i < this.zutaten.length; i++) {

            if (i != pos) {
                g[in] = this.zutaten[i];//kopieren
                m[in] = this.menge[i];//kopieren
                in++;
            }else
            {
                this.zutaten[i] = null;// Zutat frei geben
            }
        }
        this.zutaten = g; // backmapping
        this.menge = m;// backmapping
        // Aus Datenbank loeschen...
    }
    /**
     * Die Methode removeZutat(zutat) entfernt eine einzelne Zutat eines 
     * Cocktail-Objektes aus der Liste der Zutaten anhand der uebergeben
     * Zutaten Identität.
     * @param zutat Zu entfernendes Zutaten-Objekt
     */
    public void removeZutat(Bestandteile zutat) {
        int pos = 0;
        for (int i = 0; i < this.zutaten.length; i++) {
            if (this.zutaten[i].getName().equals(zutat.getName())) {
                removeZutat(i);
                break;
            }
        }
    }
    /**
     * Speichert einen Cocktail in der Datenbank unter Beruecksichtigung des
     * Aufrufparameters. Cocktails koennen sowohl erzeugt alsauch geaendert
     * werden.
     * @param create true=erzeugen, false=aendern
     * @return       Speichervorgang erfolgreich(ja/nein)
     */
    public boolean save(boolean create){
        try 
            {   
            // CocktialDAO und ZutatenDAO
            if(create){
                //SQL INSERT Cocktails...
                //SQL INSERT Zutaten...
            } else {
                //SQL UPDATE Cocktails...
                //SQL DELETE Zutaten von Cocktail...
                //SQL INSERT Zutaten von Cocktail...
            }
        } 
        catch(Exception ex) {
          //new Dialog("Fehler", ex.getMessage(), true).setVisible(true);
            return false;
        }
        return true;
    }

    /*
     * Interne Service-Methoden
    */
    private int[] add(int[] arr, int m) {
        int i;
        int[] retVal = null;
        if (arr == null) {
            retVal = new int[1];
        } else {
            retVal = new int[arr.length + 1];
        }
        for (i = 0; i < retVal.length - 1; i++) {
            retVal[i] = arr[i]; // Kopieren
        }
        retVal[i] = m; // Anfuegen
        return retVal;
    }
}
