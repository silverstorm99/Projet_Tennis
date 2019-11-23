package menu;

import java.util.function.Function;

/**
 * <b></b>
 * @author Clément
 * @see Menu
 */
public class MenuItems {
    protected String description;
    public int value;
    
    /* Constructors */
    
    /**
     * @param description 
     */
    public MenuItems(String description ){
        this.description = description;
    }
    
    /**
     * @param description
     * @param value 
     */
    public MenuItems(String description,int value ){
        this.description = description;
        this.value = value;
    }
}
