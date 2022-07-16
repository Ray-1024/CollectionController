package ray1024.projects.collectioncontroller.data;

import ray1024.projects.collectioncontroller.tools.Phrases;
import ray1024.projects.collectioncontroller.tools.SteppedInputObject;

import java.util.Objects;

/**
 * Класс представляющий координаты в 2-мерном пространстве
 */
public class Coordinates extends SteppedInputObject {

    private float x; //Максимальное значение поля: 948
    private Integer y; //Значение поля должно быть больше -544, Поле не может быть null

    public Coordinates() {
        maxLines = 2;
    }

    public float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }


    @Override
    public void inputLine(String line) throws IllegalArgumentException {
        try {
            switch (readyLines) {
                case 0:
                    x = Float.parseFloat(line);
                    if (x > 948) break;
                    ++readyLines;
                    return;
                case 1:
                    y = Integer.parseInt(line);
                    if (y < -543) break;
                    ++readyLines;
                    return;

            }
        } catch (NumberFormatException ignored) {
            throw new IllegalArgumentException(Phrases.getPhrase("CantParseNumber"));
        }
        throw new IllegalArgumentException(Phrases.getPhrase("WrongArgument"));
    }

    @Override
    public String getDescription() {
        switch (readyLines) {
            case 0:
                return Phrases.getPhrase("CoordinatesXDescription");
            case 1:
                return Phrases.getPhrase("CoordinatesYDescription");
            default:
                return Phrases.getPhrase("ReadySteppedInputObject");
        }
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Float.compare(that.x, x) != 0) return false;
        return Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }
}