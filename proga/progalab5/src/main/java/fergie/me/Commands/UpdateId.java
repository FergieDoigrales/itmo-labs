package fergie.me.Commands;


import fergie.me.CollectionManager;
import fergie.me.Data.Movie;

import java.util.Scanner;

public class UpdateId extends InputCommand implements Command{
    String description = "update id {element} : обновить значение элемента коллекции, id которого равен заданному";

    public UpdateId(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);
    }

    public void execute(){
        long id = scanner.nextLong();

        if (collectionManager.checkID(id)) {
            Movie movie = Movie.createNewMovie(this.scanner);
            movie.setId(id);
            collectionManager.updateMovie(movie);
        } else {
            System.out.println("ID не найден в текщей коллекции");
        }

    };
    public String getDescription(){
        return description;
    }
}
