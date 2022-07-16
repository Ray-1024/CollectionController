package ray1024.projects.collectioncontroller.interfaces;

import java.util.ArrayList;

/**
 * Интерфейс используется для разбора данных из множества строк при разборе скрипта
 */
public interface IParse {
    public boolean parse(ArrayList<String> lines, int offset);
    public int countLinesForParse();
}
