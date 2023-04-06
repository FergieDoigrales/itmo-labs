package fergie.me;

import fergie.me.Data.Movie;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager(collectionManager, scanner);
        Parser parser = new Parser();

//        String fileName = System.getenv("file");
//        try {
//            List<Movie> movies = parser.readFromFile(fileName);
//            collectionManager.addAll(movies);
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл" + fileName + "не найден");
//        } catch (NumberFormatException e) {
//            System.out.println("Н");
//        }

        while (true) {

                String s = scanner.next();
                scanner.nextLine();

                if (s.equals("exit")) {
                    break;
                }

                commandManager.getCommands().get(s).execute();

        }


    }
}