package fergie.me.Commands;

import fergie.me.CollectionManager;

import java.util.Scanner;

public class InputCommand extends CollectionCommand{
    protected Scanner scanner;

    public InputCommand(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager);
        this.scanner = scanner;
    }
}
