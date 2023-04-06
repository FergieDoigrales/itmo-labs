package fergie.me.Commands;

public class ExecuteScript implements Command {
    String description = "execute_script file_name: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    public void execute(){};
    public String getDescription(){
        return description;
    };
}
