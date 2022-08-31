package Middleware;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Cocktail {

    private Getraenk[] zutaten;
    private int[] menge;
    private String name;
    private String rezept;

    /*
    Konstruktoren
     */
    public Cocktail(Getraenk[] z, int[] m, String name, String rezept) throws IllegalArgumentException {
        setZutatenUndMenge(z, m);
        this.name = name;
        this.rezept = rezept;
    }

    public Cocktail(Getraenk[] z, int[] m, String name) {
        this(z, m, name, "");
    }

    public Cocktail() {
        this(new Getraenk[0], new int[0], "", "");
    }

    /*
    Getter und Setter
     */
    public Getraenk[] getZutaten() {
        return zutaten;
    }

    public void setZutaten(Getraenk[] zutaten) {
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

    public String getRezept() {
        return rezept;
    }

    public void setRezept(String rezept) {
        this.rezept = rezept;
    }

    /**
     * Die Methode setZutatenUndMenge() ermoeglicht das konsistente erstelleine
     * einer Zutatenliste aus Getraenke und Mengenangaben. Die MEthode prueft ob
     * die beiden uebergebenden Arrays dieselbe Laenge haben. Ist dies nicht der
     * Fall wird ein Laufzeitfehler ausgegeben
     *
     * @param zutaten Array
     * @param mengen Array
     * @throws IllegalArgumentException
     */
    public void setZutatenUndMenge(Getraenk[] z, int[] m) throws IllegalArgumentException {
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
        final Cocktail other = (Cocktail) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.rezept, other.rezept)) {
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

    public void addZutat(Getraenk getraenk, int menge) {
        if (getraenk != null) {
            this.zutaten = getraenk.add(this.zutaten);
            this.menge = this.add(this.menge, menge);
        }
    }

    public void removeZutat(int pos) {
        int in = 0;
        Getraenk[] g = new Getraenk[this.zutaten.length - 1];
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
    }

    public void removeZutat(Getraenk zutat) {
        int pos = 0;
        for (int i = 0; i < this.zutaten.length; i++) {
            if (this.zutaten[i].getName().equals(zutat.getName())) {
                removeZutat(i);
                break;
            }
        }
    }

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
