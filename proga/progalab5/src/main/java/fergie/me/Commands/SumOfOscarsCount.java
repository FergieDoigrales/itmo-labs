package fergie.me.Commands;


import fergie.me.CollectionManager;

public class SumOfOscarsCount extends CollectionCommand implements Command{
    String description = "sum_of_oscars_count : вывести сумму значений поля oscarsCount для всех элементов коллекции";

    public SumOfOscarsCount(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute(){
        System.out.println(collectionManager.SumOfOscarsCount());
    };
    public String getDescription(){
        return description;
    }
}
