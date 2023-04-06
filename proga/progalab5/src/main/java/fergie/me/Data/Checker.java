package fergie.me.Data;

import javax.management.InvalidAttributeValueException;
import java.util.InputMismatchException;

public class Checker {
    public interface Setter {
        void set() throws InvalidAttributeValueException;
    }

    public static void checkData(Setter setter){
        while (true){
            try{
                setter.set();
                break;
            }
            catch (InvalidAttributeValueException e) {
                System.out.println(e.getMessage());
                System.out.println("Хрень ввел. Введите правильные данные: ");
            } catch (NumberFormatException e) {
            System.out.println("Введен неправильный тип данных");
            } catch (IllegalArgumentException e) {
                System.out.println("Введено неправильное значение из справочника");
            }
        }
    }

}
