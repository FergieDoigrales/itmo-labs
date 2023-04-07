package fergie.me.Data;

import jakarta.xml.bind.annotation.XmlRootElement;

import javax.management.InvalidAttributeValueException;
import java.util.Objects;
@XmlRootElement
public class Coordinates {
    private double x;
    private Float y; //Поле не может быть null

    public double getX(){
        return x;
    }

    public void setX(String s) {
        setX(Double.parseDouble(s));
    }

    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return y;
    }

    public void setY(String y) throws InvalidAttributeValueException {
        setY(Float.parseFloat(y));
    }

    public void setY(Float y) throws InvalidAttributeValueException{
        if (y == null)
            throw new InvalidAttributeValueException("Значение поля Y не может быть null");
        this.y = y;
    }
   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates th = (Coordinates) o;
        return (Double.compare((double)th, x) == 0) && (y == th.y);
    } */

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }



}

