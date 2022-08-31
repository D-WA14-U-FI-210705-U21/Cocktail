package Backend;


public abstract class CocktailsDO {
    private short pk_ID;
    private String name;
    private String description; //nicht der richtige Name

    protected CocktailsDO(String name, String description) {
        this.name = name;
        this.description = description;
    }
      

    public short getPk_ID() {
        return pk_ID;
    }

    public void setPk_ID(short pk_ID) {
        this.pk_ID = pk_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    @Override
    public String toString() {
        return "UsersDAO:"
                + "\n pkID: " + getPk_ID()
                + "\n name: " + getName();
    }

    
    
   
    
    
    
    
}
