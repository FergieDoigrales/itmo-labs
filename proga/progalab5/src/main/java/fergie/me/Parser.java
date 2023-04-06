package fergie.me;

import fergie.me.Data.Coordinates;
import fergie.me.Data.Country;
import fergie.me.Data.Movie;
import fergie.me.Data.MovieGenre;

import javax.management.InvalidAttributeValueException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Scanner scanner;
    private String field = "<(\\w+)>(.+)</\\w+>";
    private Pattern pattern = Pattern.compile(field);
                                                                    //throws invalidAttributeValueExcep?
    public List<Movie> readFromFile(String fileName) throws FileNotFoundException, InvalidAttributeValueException {
        List<Movie> movies = new ArrayList<>();
        scanner = new Scanner(new File("src\\main\\java\\fergie\\me\\" + fileName));

        Movie movie = new Movie();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();

            if (s.equals("<Movie>")) {
                movie = new Movie();
                continue;
            }

            if (s.equals("Coordinates>")) {
                Coordinates coordinates = readCoordinates();
                movie.setCoordinates(coordinates);
            }

            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) {
                String fieldName = matcher.group(1);
                String fieldValue = matcher.group(2);
                if (fieldName.equalsIgnoreCase("Name")) {
                    movie.setName(fieldValue);
                } else if (fieldName.equals("x")) {
//                    try {
//                        Double.parseDouble(fieldValue);
//                    } catch (NumberFormatException e) {
//                        throw e;
//                    }
                } else if (fieldName.equals("Country")) {
                    MovieGenre.valueOf("DRAMA");
                    movie.setGenre(MovieGenre.DRAMA);
                }
            }

        }

        return movies;
    }

    private Coordinates readCoordinates() throws InvalidAttributeValueException{ //try catch там, где выз. парсер
        Coordinates coordinates = new Coordinates();
        String s;
        while((s = scanner.nextLine()) != "</Coordinates>") {
            Matcher matcher = pattern.matcher(s);
            String fieldName = matcher.group(1);
            String fieldValue = matcher.group(2);

            if (fieldName.equals("x")) {
                coordinates.setX(Double.parseDouble(fieldValue));
            } else if(fieldName.equals("y")) {
                coordinates.setY(Float.parseFloat(fieldValue));;
            }
        }

        return coordinates;
    }

}
