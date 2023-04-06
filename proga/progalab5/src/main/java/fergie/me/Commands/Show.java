package fergie.me.Commands;

import fergie.me.CollectionManager;
import fergie.me.Data.Movie;

import java.util.ArrayDeque;

public class Show extends CollectionCommand implements Command{
    String description = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

    public Show(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute(){
        collectionManager.show();
    };
    public String getDescription(){
        return description;
    }
}
