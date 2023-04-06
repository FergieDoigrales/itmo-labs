package fergie.me.Commands;

import fergie.me.CollectionManager;

import java.util.Scanner;

public class RemoveById extends CollectionCommand implements Command{
    String description = "remove_by_id id : удалить элемент из коллекции по его id";

    public RemoveById(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute(){
        collectionManager.removeById();
    };
    public String getDescription(){
        return description;
    }
}
