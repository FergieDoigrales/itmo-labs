package fergie.me.Commands;

public interface Command {
    //boolean execute(String[] commandArgs);
    //String description = null;
    void execute();
    String getDescription();

}
