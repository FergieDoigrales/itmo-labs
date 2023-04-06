package fergie.me;

import fergie.me.Commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {
    private CollectionManager collectionManager;

    public Map<String, Command> commands = new HashMap<>();


    public CommandManager(CollectionManager collectionManager, Scanner scanner) {
        this.collectionManager = collectionManager;
        Command update = new UpdateId(collectionManager, scanner);
        Command addElement = new AddElement(collectionManager, scanner);
        Command info = new Info(collectionManager);
        Command clear = new Clear(collectionManager);
        Command addIfMin = new AddIfMin(collectionManager);
        Command help = new Help(collectionManager, commands);
        Command show = new Show(collectionManager);
        Command countGreaterThanGenre = new CountGreaterThanGenre();
        Command executeScript = new ExecuteScript();
        Command removeByID = new RemoveById(collectionManager);




        commands.put("update", update);
        commands.put("add", addElement);
        commands.put("show", show);
        commands.put("info", info);
        commands.put("clear", clear);
        commands.put("help", help);
        commands.put("addIfMin", addIfMin);
        commands.put("removeById", new RemoveById(collectionManager));
        commands.put("removeHead", new RemoveHead(collectionManager));
        commands.put("removeGreater", new RemoveGreater(collectionManager));
        commands.put("sumOfOscarsCount", new SumOfOscarsCount(collectionManager));
        commands.put("save", new Save());
        commands.put("executeScript", new ExecuteScript());
        commands.put("groupCountingById", new GroupCountingById(collectionManager));


    }

//    public static void help() {
//
//        for( Command cmd: commands.values()) {
//            System.out.println(cmd.getDescription() + "\\n");
//        }
//    }





    public boolean execute(String[] commandArgs) {
        return true;
    }
    //через switch case или hashmap
}
