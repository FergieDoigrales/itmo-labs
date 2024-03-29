package fergie.me.Data;

import jakarta.xml.bind.annotation.XmlRootElement;

import javax.management.InvalidAttributeValueException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
@XmlRootElement
public class Movie implements Comparable<Movie> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private MovieGenre genre; //Поле не может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person operator; //Поле не может быть null
    //private long Id;

    //private static long nextId = 1L;

    public Movie() {
    }



    public Movie(long id, String name, Coordinates coordinates, String creationDate, Long oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person operator) {
        //setId();
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.operator = operator;
    }

    //    Set<Long> Id = new HashSet<>();
//    // @NotNull
//    public void setId(){
//        if (nextId == Long.MAX_VALUE){
//            this.id = 1L;
//            nextId = 1;
//        }
//        else{
//            this.id = nextId;
//            nextId += 1;
//        }
//        Id.add(this.id);
//    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws InvalidAttributeValueException {
        if (name == null || name.equals("")) {
            throw new InvalidAttributeValueException("имя фильма не может быть пустым");
        } else {
            this.name = name;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) throws InvalidAttributeValueException {
        if ((coordinates == null))
            throw new InvalidAttributeValueException("Координаты не могут быть null");
        else
            this.coordinates = coordinates;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.time.LocalDate creationDate) {
        this.creationDate = creationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Long getOscarsCount() {
        return oscarsCount;
    }

    public void setOscarsCount(String oscarsCount) throws InvalidAttributeValueException {
        setOscarsCount(Long.parseLong(oscarsCount));
    }

    public void setOscarsCount(Long oscarsCount) throws InvalidAttributeValueException {
        if (oscarsCount == null || oscarsCount == 0)
            throw new InvalidAttributeValueException("Количество оскаров не может равнять 0 или null");
        this.oscarsCount = oscarsCount;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) throws InvalidAttributeValueException {
        if (genre == null)
            throw new InvalidAttributeValueException("Значение поля жанр не может быть null");
        this.genre = genre;
    }

    public MpaaRating getMpaaRating() {
        return this.mpaaRating;
    }

    public void setMpaaRating(MpaaRating mpaaRating) throws InvalidAttributeValueException {
        if (mpaaRating == null)
            throw new InvalidAttributeValueException("Значение поля MpaaRating не может быть null");
        this.mpaaRating = mpaaRating;
    }

    public Person getOperator() {
        return this.operator;
    }

    public void setOperator(Person operator) throws InvalidAttributeValueException {
        if (operator == null)
            throw new InvalidAttributeValueException("Значение поля operator не может быть null");
        this.operator = operator;
    }

    //переопределить equals hashcode и toString для movie
    @Override
    public String toString() {
        return "Название: " + this.name + " | id: " + this.id + " ";
    }

    public static Movie createNewMovie(Scanner scanner) {
        System.out.println("Введите параметры.");
        Movie movie = new Movie();

        { // movie: movieGenre, MpaaRating, coordinates
            movie.setCreationDate(LocalDate.from(LocalDateTime.now()));
            System.out.println("Введите название фильма:");
            Checker.Setter checker = () -> {
                        movie.setName(scanner.nextLine());
            };
            Checker.checkData(checker);


            System.out.println("Введите количество оскаров:");

            checker = () -> {
                movie.setOscarsCount(scanner.nextLine());
            };
            Checker.checkData(checker);



            System.out.println("Выберите из списка MpaaRating и введите его:"
                    + "\n" + Arrays.toString(MpaaRating.values()));
            checker = () -> {
                movie.setMpaaRating(MpaaRating.valueOf(scanner.nextLine()));
            };
            Checker.checkData(checker);


            System.out.println("Выберите жанр из списка: ");
            System.out.println(Arrays.toString(MovieGenre.values()));
            checker = () -> {
                movie.setGenre(MovieGenre.valueOf(scanner.nextLine()));
            };
            Checker.checkData(checker);

            //coordinates
            {
                Coordinates coordinates = new Coordinates();
                System.out.println("Введите координаты x: ");
                checker = () -> {
                    coordinates.setX(scanner.nextLine()); //сделать проверку на null
                };
                Checker.checkData(checker);
                System.out.println("Введите координаты y: ");
                checker = () -> {
                    coordinates.setY(scanner.nextLine());
                };
                Checker.checkData(checker);

                checker = () -> {
                    movie.setCoordinates(coordinates); //убрать проверку
                };
                Checker.checkData(checker);


            }

            { //person
                Person operator = new Person();
                System.out.println("Введите имя режиссера:");
                checker = () -> {
                    operator.setName(scanner.nextLine());
                };
                Checker.checkData(checker);

                //color
                System.out.println("Выберите цвет глаз режиссера из предложенных и введите его: ");
                System.out.println(Arrays.toString(Color.values()));
                checker = () -> {
                    operator.setEyeColor(Color.valueOf(scanner.nextLine()));
                };
                Checker.checkData(checker);

                //country
                System.out.println("Введите национальность оператора: ");
                System.out.println(Arrays.toString(Country.values()));
                checker = () -> {
                    operator.setNationality(Country.valueOf(scanner.nextLine()));
                };
                Checker.checkData(checker);

                //height
                System.out.println("Введите рост режиссера:");
                checker = () -> {
                    operator.setHeight(scanner.nextLine());
                };
                Checker.checkData(checker);

                { //location + coordinates
                    Location location = new Location();
                    System.out.println("Введите построчно координаты (x,y) оператора в формате 0.0 (КАКиЕ ЕЩЕ КООРДиНАТЫ ОПЕРАТОРА?????????): ");
                    checker = () -> {
                    location.setX(scanner.nextLine());
                    };
                    Checker.checkData(checker);
                    checker = () -> {
                        location.setY(scanner.nextLine());
                    };
                    Checker.checkData(checker);
                    System.out.println("Введите координату z оператора (long): ");
                    checker = () -> {
                    location.setZ(scanner.nextLine());
                    };
                    Checker.checkData(checker);
                    System.out.println("Введите название локации:");
                    checker = () -> {location.setName(scanner.nextLine());
                    };
                    Checker.checkData(checker);

//                    checker = () -> {
//                        operator.setLocation(location);
//                    };
//                    Checker.checkData(checker);

                }
                checker = () -> {
                    movie.setOperator(operator);
                };
            }
        }
        return movie;
    }

    @Override
    public int compareTo(Movie movie) {
        return Objects.equals(this.getOscarsCount(), movie.getOscarsCount()) ? 0 :
                this.getOscarsCount().compareTo(movie.getOscarsCount());
    }
}
