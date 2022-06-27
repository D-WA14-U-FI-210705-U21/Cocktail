/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author cardi
 */
public class IngredientsDO {
    
    private short pk_ID = 0;
    private String name;
    private float alcohol = 0.0f;

    protected IngredientsDO(String name, float alc) {
        this.name = name;
        this.alcohol = alc;
    }

    public short getPk_ID() {
        return pk_ID;
    }

    protected void setPk_ID(short pk_ID) {
        this.pk_ID = pk_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }
    
    @Override
    public String toString() {
        return "Ingredient:"
                + "\n pk_ID: " + getPk_ID()
                + "\n name: " + getName()
                + "\n alcohol: " + getAlcohol()
                + " Vol.\n";
    } 
    
}
