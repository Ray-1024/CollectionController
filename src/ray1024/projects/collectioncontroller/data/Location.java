package ray1024.projects.collectioncontroller.data;

import ray1024.projects.collectioncontroller.tools.Phrases;
import ray1024.projects.collectioncontroller.tools.SteppedInputObject;

/**
 * Класс представляющий координаты в 3х-мерном пространстве
 */
public class Location extends SteppedInputObject {
    private double x;
    private int y;
    private int z;

    public Location() {
        maxLines = 3;
    }

    @Override
    public void inputLine(String line) throws IllegalArgumentException{
        try {
            switch (readyLines) {
                case 0:
                    x = Double.parseDouble(line);
                    ++readyLines;
                    return;
                case 1:
                    y = Integer.parseInt(line);
                    ++readyLines;
                    return;
                case 2:
                    z = Integer.parseInt(line);
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
                return Phrases.getPhrase("LocationXDescription");
            case 1:
                return Phrases.getPhrase("LocationYDescription");
            case 2:
                return Phrases.getPhrase("LocationZDescription");
            default:
                return Phrases.getPhrase("ReadySteppedInputObject");
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
        return "Location{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
