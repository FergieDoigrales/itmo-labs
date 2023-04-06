package fergie.me.Commands;

import fergie.me.CollectionManager;

public class RemoveHead extends CollectionCommand implements Command{
    String description = "remove_head : вывести первый элемент коллекции и удалить его";

    public RemoveHead(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute(){
        collectionManager.removeHead();
    };
    public String getDescription(){
        return description;
    }
}
