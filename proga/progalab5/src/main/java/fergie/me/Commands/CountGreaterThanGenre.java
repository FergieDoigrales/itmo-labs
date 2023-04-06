package fergie.me.Commands;

import fergie.me.Data.MovieGenre;

public class CountGreaterThanGenre implements Command{
    String description = "count_greater_than_genre genre : вывести количество элементов, значение поля genre которых больше заданного";
    public void execute(){
    }
    public String getDescription(){
        return description;
    }
}
