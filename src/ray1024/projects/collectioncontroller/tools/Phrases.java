package ray1024.projects.collectioncontroller.tools;

import java.util.HashMap;

/**
 * Класс-Инструмент
 * Содержит все фразы выводимые на обозрение пользователя
 * В будущем с помощью функции setLocale можно будет менять язык используемый в приложении
 */
public class Phrases {

    private static final HashMap<String, String> phrases = new HashMap<>();

    private Phrases() {
    }

    public static String getPhrase(String phraseName) {
        return phrases.get(phraseName);
    }

    public static void setLocale(String locale) {
        if (locale.equals("Russian")) {
            phrases.clear();
            phrases.put("ReadySteppedInputObject", "Объект готов.");
            phrases.put("WrongArgument", "Введеное вами значение не соответствует обозначенным условиям.");
            phrases.put("CantParseNumber", "Распознование числа не удалось, возможно вы ввели не число.");
            phrases.put("CoordinatesXDescription", "Пожалуйста введите значение координаты X(вещественное число) не превосходящее 948:");
            phrases.put("CoordinatesYDescription", "Пожалуйста введите значение координаты Y(целое число) не меньшее -543:");
            phrases.put("LocationXDescription", "Пожалуйста введите значение координаты X(вещественное число):");
            phrases.put("LocationYDescription", "Пожалуйста введите значение координаты Y(целое число):");
            phrases.put("LocationZDescription", "Пожалуйста введите значение координаты Z(целое число):");
            phrases.put("PersonNameDescription", "Пожалуйста введите имя человека:");
            phrases.put("PersonWeightDescription", "Пожалуйста введите ширину персоны(вещественное, положительное число):");
            phrases.put("", "");
        }
    }
}
