package fergie.me.Commands;

import fergie.me.CollectionManager;

public class GroupCountingById extends CollectionCommand implements Command {
    String description = "group_counting_by_id : сгруппировать элементы коллекции по значению поля id, " +
            " вывести количество элементов в каждой группе";

    public GroupCountingById(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute(){};
    public String getDescription(){
        return description;
    };
}
