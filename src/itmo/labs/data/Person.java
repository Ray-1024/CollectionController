package itmo.labs.data;

import itmo.labs.tools.IInput;
import itmo.labs.tools.IParse;
import itmo.labs.tools.Inputter;
import itmo.labs.tools.Phrases;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс представляющий человека
 */
public class Person implements IInput, IParse {
    private String name = ""; //Поле не может быть null, Строка не может быть пустой
    private double weight; //Значение поля должно быть больше 0
    private Location location = new Location(); //Поле может быть null

    @Override
    public boolean parse(ArrayList<String> lines, int offset) {
        if (offset + 2 > lines.size()) return false;
        try {
            name = lines.get(offset);
            if (name == null || "".equals(name)) return false;
            weight = Double.parseDouble(lines.get(offset + 1));
            if (weight <= 0.0d) return false;
            return location.parse(lines, offset + 2);
        } catch (RuntimeException ex) {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int countLinesForParse() {
        if (location == null) location = new Location();
        return 2 + location.countLinesForParse();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (Double.compare(person.weight, weight) != 0) return false;
        if (!Objects.equals(name, person.name)) return false;
        return Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public void input(Scanner scanner) throws EOFException {
        if (scanner == null) throw new EOFException();

        Double dd = null;

        try {
            while (true) {
                name = Inputter.getString(scanner, Phrases.PersonNameRequest);
                if (name == null || "".equals(name)) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                break;
            }
            while (true) {
                dd = Inputter.getDouble(scanner, Phrases.PersonWeightRequest);
                if (dd == null || dd <= 0.0d) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                weight = dd;
                break;
            }
            System.out.println(Phrases.PersonLocationRequest);
            location.input(scanner);
        } catch (EOFException ex) {
            throw new EOFException();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", location=" + location +
                '}';
    }
}
