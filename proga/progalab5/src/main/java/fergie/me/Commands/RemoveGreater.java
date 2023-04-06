package fergie.me.Commands;

import fergie.me.CollectionManager;
import fergie.me.Data.Movie;

public class RemoveGreater extends CollectionCommand implements Command {
    String description = "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";

    public RemoveGreater(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute(){
       // Movie movie = Movie.createNewMovie(scanner);
    };
    public String getDescription(){
        return description;
    }
}
