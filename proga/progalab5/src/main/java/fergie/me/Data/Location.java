package fergie.me.Data;

import fergie.me.Exceptions.CannotBeNullException;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.management.InvalidAttributeValueException;
import java.util.Objects;
@XmlRootElement
public class Location {
    private float x;
    private float y;
    private long z;
    private String name; //Длина строки не должна быть больше 870, Поле не может быть null

    public float getX(){
        return x;
    }

    public void setX(String x) throws InvalidAttributeValueException {
        setY(Float.parseFloat(x));
    }
    public void setX(float x){
        this.x = x;
    }
    public float getY(){
        return y;
    }
    public void setY(String y) throws InvalidAttributeValueException {
        setY(Float.parseFloat(y));
    }
    public void setY(float y){
        this.y = y;
    }
    public long getZ(){
        return z;
    }
    public void setZ(String z) throws InvalidAttributeValueException {
        setY(Long.parseLong(z));
    }
    public void setZ(long z){
        this.z = z;
    }

    public  String getName(){
        return name;
    }

    public  void setName(String name) throws InvalidAttributeValueException{
        if (name == null || name.length() > 870)
            throw new InvalidAttributeValueException("Название локации не может отсутствовать.");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return Float.compare(that.x, x) == 0 && y == that.y && name.equals(that.name);
    } //???

    @Override
    public int hashCode() {
        return Objects.hash(x, y, name);
    }

    @Override
    public String toString() {
        return "Coordinates " + name + "{x= " + x + ", y= " + y + '}';
    }
}
