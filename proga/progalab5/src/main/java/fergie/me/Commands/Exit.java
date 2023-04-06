package fergie.me.Commands;

public class Exit implements Command {
    String description = "exit : завершить программу (без сохранения в файл)";
    public void execute() {

    };
    public String getDescription(){
        return description;
    };
}
