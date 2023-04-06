package fergie.me.Commands;

import fergie.me.CollectionManager;
import fergie.me.Data.Checker;
import fergie.me.Data.MovieGenre;

import java.util.Scanner;

public class CountGreaterThanGenre extends InputCommand implements Command {
    String description = "count_greater_than_genre genre : вывести количество элементов, значение поля genre которых больше заданного";

    public CountGreaterThanGenre(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);
    }

    public void execute() {
        String genre = scanner.nextLine();
        Checker.Setter checker = () -> {
            MovieGenre.valueOf(genre);
        };

        Integer count = collectionManager.countGreaterThanGenre(MovieGenre.valueOf(genre));
        System.out.println(count);
    }
    public String getDescription(){
        return description;
    }
}
