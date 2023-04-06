package fergie.me.Commands;

import fergie.me.CollectionManager;

public abstract class CollectionCommand implements Command {
    protected CollectionManager collectionManager ;

    public CollectionCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;

    }
}
