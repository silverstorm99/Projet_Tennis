package menu;

import java.util.function.Function;

public class MenuItems<T,R> {
    protected String description;
    protected String valeur;
    public MenuItems(String description, String valeur, Function<T,R> p ){
        this.description = description;
        this.valeur = valeur;
    }
}
