package menu;

/**
 * 
 * @author clement
 *
 */
public class MenuItems {
    protected String description; //Description of the Items that will be display
    public int value; // Value (can be not defined )
    
    /**
     * Constructor of a items in the menu models
     * @param description
     */
    public MenuItems(String description ){
        this.description = description;
    }
    
    /**
     * Constructor with special value, permit to return special value 
     * <h3>Example</h3>
     * For the items "quit program", or "return to precedent menu"   
     * @param description
     * @param value
     */
    public MenuItems(String description,int value ){
        this.description = description;
        this.value = value;
    }
}
