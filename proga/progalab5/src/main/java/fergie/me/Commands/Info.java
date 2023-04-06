package fergie.me.Commands;

import fergie.me.CollectionManager;

public class Info extends CollectionCommand implements Command{
    String description = "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)";

    public Info(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute(){
    System.out.println(collectionManager.getInitializationDate());
    System.out.println(collectionManager.getCurrency());
    System.out.println(collectionManager.getClassName());
    };
    public String getDescription(){
        return description;
    }
}
