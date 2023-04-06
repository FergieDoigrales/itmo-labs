package fergie.me;

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
            try {
                String s = scanner.next();
                scanner.nextLine();

                if (s.equals("exit")) {
                    break;
                }

                commandManager.commands.get(s).execute(); //почему-то не работат addIfMin
            } catch (NullPointerException e) {
                System.out.println("Вы ввели несуществующую команду.");
            }
        }


    }
}