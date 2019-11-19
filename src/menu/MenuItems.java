package menu;

import java.util.function.Function;

public class MenuItems {
    protected String description;
    public int value;
    
    public MenuItems(String description ){
        this.description = description;
    }
    public MenuItems(String description,int value ){
        this.description = description;
        this.value = value;
    }
}
