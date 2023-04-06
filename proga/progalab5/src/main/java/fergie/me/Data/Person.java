package fergie.me.Data;

import fergie.me.Commands.Info;

import javax.management.InvalidAttributeValueException;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long height; //Поле может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле может быть null

    public String getName(){
        return this.name;
    }
    public void setName(String name) throws InvalidAttributeValueException{
        if (name.equals("") || name == null)
            throw new InvalidAttributeValueException("имя оператора не может быть пустым или null");
        this.name = name;
    }


    public Long getHeight(){
        return this.height;
    }

    public void setHeight(String height) throws InvalidAttributeValueException {
        setHeight(Long.parseLong(height));
    }
    public void setHeight(Long height) throws InvalidAttributeValueException{
        if (height <= 0 || height == null)
            throw new InvalidAttributeValueException("Рост оператора не может быть меньше 0 и не может быть null");
        this.height = height;
    }
    public Color getEyeColor(){
        return this.eyeColor;
    }
    public void setEyeColor(Color color) throws InvalidAttributeValueException{
        if ( color == null)
            throw new InvalidAttributeValueException("Цвет глаз оператора не может быть null");
        this.eyeColor = color;
    }
    public Country getNationality(){
        return this.nationality;
    }
    public void setNationality(Country nationality) throws InvalidAttributeValueException {
        if ( nationality == null)
            throw new InvalidAttributeValueException("Национальность оператора не может быть null");
        this.nationality = nationality;
    }
    public Location getLocation(){
        return this.location;
    }
    public void setLocation(Location location) throws InvalidAttributeValueException{
        if ( location == null)
            throw new InvalidAttributeValueException("Локация оператора не может быть null");
        this.location = location;
    }
}
