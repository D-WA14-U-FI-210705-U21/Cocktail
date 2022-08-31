/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author cardi
 */
public class ZutatenDO {
    private int fk_pk_cocktail_ID;
    private int fk_pk_ingredient_ID;
    private int amount;
    private String unit;
    
    public ZutatenDO(int fk_pk_cocktail_ID, int fk_pk_ingredient_ID, int amount, String unit) {
        this.fk_pk_cocktail_ID = fk_pk_cocktail_ID;
        this.fk_pk_ingredient_ID = fk_pk_ingredient_ID;
        this.amount = amount;
        this.unit = unit;
    }

    public int getFk_pk_cocktail_ID() {
        return fk_pk_cocktail_ID;
    }

    public void setFk_pk_cocktail_ID(int fk_pk_cocktail_ID) {
        this.fk_pk_cocktail_ID = fk_pk_cocktail_ID;
    }

    public int getFk_pk_ingredient_ID() {
        return fk_pk_ingredient_ID;
    }

    public void setFk_pk_ingredient_ID(int fk_pk_ingredient_ID) {
        this.fk_pk_ingredient_ID = fk_pk_ingredient_ID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    
}
