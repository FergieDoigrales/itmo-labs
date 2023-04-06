package fergie.me.Commands;

import fergie.me.CollectionManager;

public class Clear extends CollectionCommand implements Command {
    String description = "clear: очистить коллекцию";

    public Clear(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public void execute() {
        collectionManager.clear();
    }

    public String getDescription() {
        return description;
    }

}
