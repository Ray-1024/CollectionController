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
 * Класс представляющий координаты в 2-мерном пространстве
 */
public class Coordinates implements IInput, IParse {

    private float x; //Максимальное значение поля: 948
    private Integer y; //Значение поля должно быть больше -544, Поле не может быть null

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
    public boolean parse(ArrayList<String> lines, int offset) {
        if (offset + 2 > lines.size()) return false;
        try {
            x = Float.parseFloat(lines.get(offset));
            if (x > 948.0f) return false;
            y = Integer.parseInt(lines.get(offset + 1));
            if (y == null || y < -543)
                return false;
        } catch (RuntimeException ex) {
            return false;
        }
        return true;
    }

    @Override
    public int countLinesForParse() {
        return 2;
    }

    @Override
    public void input(Scanner scanner) throws EOFException {
        if (scanner == null) throw new EOFException();
        Float flt = null;
        Integer yy = null;
        try {
            while (true) {
                flt = Inputter.getFloat(scanner, Phrases.CoordinatesXRequest);
                if (flt == null || flt > 948) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                x = flt;
                break;
            }
            while (true) {
                yy = Inputter.getInt(scanner, Phrases.CoordinatesYRequest);
                if (yy == null || yy < -543) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                y = yy;
                break;
            }
        } catch (EOFException ex) {
            throw new EOFException();
        }
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
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