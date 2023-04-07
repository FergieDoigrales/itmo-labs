package fergie.me;

import fergie.me.Data.*;
import jakarta.xml.bind.JAXBException;

import javax.management.InvalidAttributeValueException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidAttributeValueException, JAXBException, IOException {
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

        //create test film
//        Movie movie = new Movie();
//        movie.setName("Titanik");
//        movie.setGenre(MovieGenre.ACTION);
//        movie.setOscarsCount(2L);
//        Coordinates coordinates = new Coordinates();
//        coordinates.setX(12.);
//        coordinates.setY(13f);
//        movie.setCoordinates(coordinates);
//        movie.setMpaaRating(MpaaRating.NC_17);
//        movie.setCreationDate(LocalDate.from(LocalDateTime.now()));
//        movie.setId(1L);
//        Person person = new Person();
//        person.setName("Tim");
//        person.setHeight(8L);
//        person.setEyeColor(Color.GREEN);
//        person.setNationality(Country.FRANCE);
//        Location location = new Location();
//        location.setName("Avstria");
//        location.setX(45);
//        location.setY(21);
//        location.setZ(12);
//        person.setLocation(location);
//        movie.setOperator(person);


//        1) make FileManager.object
//        FileManager fileManager = new FileManager();
//        2)For export to file:
//        fileManager.exportToFile(movie);
//        3)For import from file: (return CollectionManager object with var ArrayDequeue)
//        fileManager.importFromFile();


    }
}