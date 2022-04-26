package itmo.labs.data;

import itmo.labs.tools.IInput;
import itmo.labs.tools.IParse;
import itmo.labs.tools.Inputter;
import itmo.labs.tools.Phrases;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс представляющий координаты в 3х-мерном пространстве
 */
public class Location implements IInput, IParse {
    private double x;
    private int y;
    private int z;

    @Override
    public boolean parse(ArrayList<String> lines, int offset) {
        if (offset + 3 > lines.size()) return false;
        try {
            x = Double.parseDouble(lines.get(offset));
            y = Integer.parseInt(lines.get(offset + 1));
            z = Integer.parseInt(lines.get(offset + 2));
        } catch (RuntimeException ex) {
            return false;
        }
        return true;
    }

    @Override
    public int countLinesForParse() {
        return 3;
    }

    @Override
    public void input(Scanner scanner) throws EOFException {
        if (scanner == null) throw new EOFException();
        Double dd = null;
        Integer yy = null, zz = null;
        try {
            while (true) {
                dd = Inputter.getDouble(scanner, Phrases.LocationXRequest);
                if (dd == null) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                x = dd;
                break;
            }
            while (true) {
                yy = Inputter.getInt(scanner, Phrases.LocationYRequest);
                if (yy == null) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                y = yy;
                break;
            }
            while (true) {
                zz = Inputter.getInt(scanner, Phrases.LocationZRequest);
                if (zz == null) {
                    System.out.println(Phrases.WrongInput);
                    continue;
                }
                z = zz;
                break;
            }
        } catch (EOFException ex) {
            throw new EOFException();
        }

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.x, x) != 0) return false;
        if (y != location.y) return false;
        return z == location.z;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
