package ray1024.projects.collectioncontroller.data;

import ray1024.projects.collectioncontroller.tools.Phrases;
import ray1024.projects.collectioncontroller.tools.SteppedInputObject;

import java.lang.ref.PhantomReference;
import java.util.Objects;

/**
 * Класс представляющий человека
 */
public class Person extends SteppedInputObject {
    private String name = ""; //Поле не может быть null, Строка не может быть пустой
    private double weight; //Значение поля должно быть больше 0
    private Location location; //Поле может быть null

    public Person() {
        location = new Location();
        maxLines = 2 + location.getMaxLines();
    }

    @Override
    public void inputLine(String line) throws IllegalArgumentException {
        try {
            switch (readyLines) {
                case 0:
                    if (line == null) break;
                    name = line;
                    ++readyLines;
                    return;
                case 1:
                    weight = Double.parseDouble(line);
                    if (weight <= 0.0d) break;
                    ++readyLines;
                    return;
                default:
                    if (location.isObjectReady()) return;
                    location.inputLine(line);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(Phrases.getPhrase("CantParseNumber"));
        }
        throw new IllegalArgumentException(Phrases.getPhrase("WrongArgument"));
    }

    @Override
    public String getDescription() {
        switch (readyLines) {
            case 0:
                return Phrases.getPhrase("PersonNameDescription");
            case 1:
                return Phrases.getPhrase("PersonWeightDescription");
            default:
                return location.getDescription();
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
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", weight=" + weight + ", location=" + location + '}';
    }
}
