package fergie.me.Commands;


import fergie.me.CollectionManager;
import fergie.me.CommandManager;

import java.util.HashMap;
import java.util.Map;

public class Help extends CollectionCommand implements Command{
    //protected CommandManager commandManager = new CommandManager(collectionManager);
    String description = "help : вывести справку по доступным командам";
    Map<String, Command> map;

    public Help(CollectionManager collectionManager, Map<String, Command> map) {
        super(collectionManager);
        this.map = map;
    }

    public void execute(){
        for( Command cmd: map.values()) {
            System.out.println(cmd.getDescription() + "\n");
        }
        //CommandManager.help();

    };
    public String getDescription(){
        return description;
    }
}
