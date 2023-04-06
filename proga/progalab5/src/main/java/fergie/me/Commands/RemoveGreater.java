package fergie.me.Commands;

import fergie.me.CollectionManager;
import fergie.me.Data.Movie;

import java.util.Scanner;

public class RemoveGreater extends InputCommand implements Command {
    String description = "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";

    public RemoveGreater(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);
    }

    public void execute(){
        Movie movie = Movie.createNewMovie(scanner);
        collectionManager.removeIfGreater(movie);
    };
    public String getDescription(){
        return description;
    }
}
