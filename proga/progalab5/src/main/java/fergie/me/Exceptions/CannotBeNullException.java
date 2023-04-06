package fergie.me.Exceptions;

public class CannotBeNullException extends RuntimeException {
    public CannotBeNullException(String s){}

    @Override
    public String toString(){
        return "Объект не может отсутствовать.";
    }

}
