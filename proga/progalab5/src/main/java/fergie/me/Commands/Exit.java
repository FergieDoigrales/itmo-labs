package fergie.me.Commands;


public class Exit implements Command {
    String description = "exit : завершить программу (без сохранения в файл)";
    public void execute() {
        System.exit(0);
    };
    public String getDescription(){
        return description;
    };
}
